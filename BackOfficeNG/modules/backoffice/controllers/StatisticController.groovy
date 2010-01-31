import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.ICategoryService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

import GoogleChartBuilder

import au.com.bytecode.opencsv.CSVWriter

import java.text.SimpleDateFormat

class StatisticController {
    
    IRequestStatisticsService requestStatisticsService
    IRequestTypeService requestTypeService
	ICategoryService categoryService
    
    def requestAdaptorService
    def translationService

    def statisticTypes

    def beforeInterceptor = {
        session['currentMenu'] = 'statistics'
        statisticTypes = ['state','type']
        if (SecurityContext.getCurrentSite().instructionAlertsEnabled) statisticTypes.add('quality')
    }

	def defaultAction = 'type'

    def quality = {
        def state = [:]
        if (params.pageState) state = JSON.parse(params.pageState)

        def categoryId = LongUtils.stringToLong(state['categoryId'])
        def requestTypeId = LongUtils.stringToLong(state['requestTypeId'])
        def startDate = DateUtils.stringToDate(state['startDate'])
        def endDate = DateUtils.stringToDate(state['endDate'])

        def detailedQualityStats = 
            requestStatisticsService.getQualityStatsByType(startDate, endDate, requestTypeId, categoryId)
        def detailedQualityData = []
        // populate results according to authorized request types and selected filters
        if (detailedQualityStats != null) {
            requestAdaptorService.translateAndSortRequestTypes(true).each {
                if ((requestTypeId == null || requestTypeId == it.id)
                    && (categoryId == null || categoryId == it.categoryId)) {
                    def qualityStatsForRt = detailedQualityStats[it.id]
                    detailedQualityData.add([
                        'requestType':it.label,
                        'green':qualityStatsForRt?.get(IRequestStatisticsService.QUALITY_TYPE_OK),
                        'orange':qualityStatsForRt?.get(IRequestStatisticsService.QUALITY_TYPE_ORANGE),
                        'red':qualityStatsForRt?.get(IRequestStatisticsService.QUALITY_TYPE_RED)
                    ])
                }
            }
        }

        render(view:'index',
               model:['summarizedQualityUrl':summarizedQualityStatsUrl(startDate, endDate, requestTypeId, categoryId),
                      'detailedQualityData':detailedQualityData,
                      'pageState' : (new JSON(state)).toString().encodeAsHTML(),
                      'state': state,
                      'currentStatisticType':'quality'].plus(initStatisticsReferential()))
    }

    def state = {
        def state = [:]
        if (params.pageState) state = JSON.parse(params.pageState)

        def categoryId = LongUtils.stringToLong(state['categoryId'])
        def requestTypeId = LongUtils.stringToLong(state['requestTypeId'])
        def startDate = DateUtils.stringToDate(state['startDate'])
        def endDate = DateUtils.stringToDate(state['endDate'])

        render(view:'index',
               model:['stateUrl':stateStatsUrl(startDate, endDate, requestTypeId, categoryId),
                      'pageState' : (new JSON(state)).toString().encodeAsHTML(),
                      'state': state,
                      'currentStatisticType':'state'].plus(initStatisticsReferential()))
    }

    def type = {
        def state = [:]
        if (params.pageState) state = JSON.parse(params.pageState)

        def categoryId = LongUtils.stringToLong(state['categoryId'])
        def requestTypeId = LongUtils.stringToLong(state['requestTypeId'])
        def startDate = DateUtils.stringToDate(state['startDate'])
        def endDate = DateUtils.stringToDate(state['endDate'])

        render(view:'index',
               model:['typeUrl':typeStatsUrl(startDate, endDate, requestTypeId, categoryId),
                      'periodUrl':typeStatsByPeriodUrl(startDate, endDate, requestTypeId, categoryId),
                      'pageState' : (new JSON(state)).toString().encodeAsHTML(),
                      'state': state,
                      'currentStatisticType':'type'].plus(initStatisticsReferential()))
    }

    def typeStatsByPeriodUrl(startDate, endDate, requestTypeId, categoryId) {
        def labels = []
        def maxY = 1
        def cdData = []
        def results =
            requestStatisticsService.getTypeStatsByPeriod(startDate, endDate, requestTypeId, categoryId)
        def typeStatsIntervalType =
            requestStatisticsService.getTypeStatsIntervalType(startDate, endDate)
        results.each { date,count ->
            def format
            if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.HOUR)
                format = message(code:'statistics.type.hourlyDateFormat')
            else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.DAY)
                format = message(code:'statistics.type.dailyDateFormat')
            else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.TWO_DAYS)
                format = message(code:'statistics.type.bidaylyDateFormat')
            else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.WEEK)
                format = message(code:'statistics.type.weeklyDateFormat')
            else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.MONTH)
                format = message(code:'statistics.type.monthlyDateFormat')
            else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.YEAR)
                format = message(code:'statistics.type.yearlyDateFormat')
            labels.add(new SimpleDateFormat(format).format(date))
            cdData.add(count.intValue())
            if (count.intValue() > maxY)
                maxY = count.intValue()
        }
        def transformedCdData = cdData.collect {  k ->
           k = ((k * 100) / maxY).floatValue()
        }

        def chart = new GoogleChartBuilder()
        def url = chart.barChart(['vertical','grouped']) {
            size(w:700,h:400)
            barSize(width:'r', space:1, spaceGroups:1)
            data(encoding:'text') {
        		dataSet(transformedCdData)
            }
            if (maxY < 10)
                axis(bottom:labels,left:(0..maxY).toList())
            else
                axis(bottom:labels,left:(0..maxY).step((maxY/10).intValue()).toList())
            colors {
                color('84c984')
            }
        }

      	return url
    }

    def stateStatsUrl(startDate, endDate, requestTypeId, categoryId) {
        def textLabels = []
        def cdData = []
        def results =
            requestStatisticsService.getStateStats(startDate, endDate, requestTypeId, categoryId)
        results.each { requestState,count ->
			if (count.intValue() > 0) {
			    def stateI18nKey = CapdematUtils.adaptCapdematEnum(requestState,'request.state').i18nKey
                def label =
                    new StringBuffer(message(code:stateI18nKey)).append(' (').append(count).append(')')
        		textLabels.add(label)
            	cdData.add(count.intValue())
			}
        }

        def chart = new GoogleChartBuilder()
        def url = chart.pieChart {
            size(w:700,h:200)
            title() {
                row("Total : ${cdData.sum()}")
            }
            data(encoding:'text') {
        		dataSet(cdData)
            }
			labels {
			    textLabels.each { label(it) }
			}
        }

      	return url
    }

    def typeStatsUrl(startDate, endDate, requestTypeId, categoryId) {
        def textLabels = []
        def cdData = []
        def results =
            requestStatisticsService.getTypeStats(startDate, endDate, requestTypeId, categoryId)
        results.each { rtId,count ->
			if (count.intValue() > 0) {
                def requestType = requestTypeService.getRequestTypeById(rtId)
                def label = new StringBuffer()
                    .append(translationService.translateRequestTypeLabel(requestType.label).encodeAsHTML())
			    	.append(" (").append(count).append(")")
        		textLabels.add(label)
            	cdData.add(count.intValue())
			}
        }

        def chart = new GoogleChartBuilder()
        def url = chart.pieChart {
            size(w:700,h:300)
            title() {
                row("Total : ${cdData.isEmpty() ? 0 : cdData.sum()}")
            }
            data(encoding:'text') {
        		dataSet(cdData)
            }
			labels {
			    textLabels.each { label(it) }
			}
        }

      	return url
    }

    def summarizedQualityStatsUrl(startDate, endDate, requestTypeId, categoryId) {
        def textLabels = []
        def cdData = []
        def cdColors = []
        def results = 
            requestStatisticsService.getQualityStats(startDate, endDate, requestTypeId, categoryId)
        results.each { k,v ->
			if (v.intValue() > 0) {
			    if (k == "qualityTypeOk")
        			cdColors.add('74c343')
        		else if (k == "qualityTypeOrange")
        		    cdColors.add('ff9523')
        		else if (k == "qualityTypeRed")
        		    cdColors.add('ed2024')
            	cdData.add(v.intValue())
                textLabels.add(v.intValue())
			}
        }
        
        def chart = new GoogleChartBuilder()
        def url = chart.pieChart {
            size(w:600,h:200)
            data(encoding:'text') {
        		dataSet(cdData)        
            }
            colors {
                cdColors.each { color(it) }
            }
			labels {
			    textLabels.each { label(it) }
			}
        }            
        
      	return url
    }

    def initStatisticsReferential() {
        return ['allCategories':categoryService.getManaged().sort { it.name },
                'allRequestTypes':requestAdaptorService.translateAndSortRequestTypes(true),
                'statisticTypes':statisticTypes]
    }

    def export = {
        def state = [:]
        if (params.pageState) state = JSON.parse(params.pageState)
        def categoryId = LongUtils.stringToLong(state['categoryId'])
        def requestTypeId = LongUtils.stringToLong(state['requestTypeId'])
        def startDate = DateUtils.stringToDate(state['startDate'])
        def endDate = DateUtils.stringToDate(state['endDate'])

        def filenameParts = []
        [message(code : "statistics.header." + params.currentStatisticType),
         categoryId != null ? categoryService.getById(categoryId).name : null,
         requestTypeId != null ? translationService.translateRequestTypeLabel(requestTypeService.getRequestTypeById(requestTypeId).label) : null,
         startDate != null ? message(code : "statistics.filename.start.date") + fr.cg95.cvq.util.DateUtils.format(startDate) : null,
         endDate != null ? message(code : "statistics.filename.end.date") + fr.cg95.cvq.util.DateUtils.format(endDate) : null].each {
            if (it != null) {
                filenameParts.add(it)
            }
        }
        def extension
        def contentType
        def content

        if (params.format == "csv") {
            extension = "csv"
            contentType = "text/csv"
            content = new StringWriter()
            def writer = new CSVWriter(content)

            // stats taken from service
            def stats
            // the data to feed CSVWriter (must be a List of String[])
            def data = []

            switch (params.currentStatisticType) {
                case "type" :
                    stats = requestStatisticsService.getTypeStats(startDate, endDate, requestTypeId, categoryId)
                    def currentRequestTypeId
                    def statsForRequest
                    def typeStatsIntervalType
                    def format
                    def shiftUnit
                    def line = new String[4]
                    line[0] = message(code : "property.requestType")
                    line[1] = message(code : "statistics.start.date")
                    line[2] = message(code : "statistics.end.date")
                    line[3] = message(code : "statistics.number.of.requests")
                    data.add(line)
                    stats.entrySet().sort{it.value}.reverse().each {
                        if (it.value > 0) {
                            currentRequestTypeId = it.key
                            statsForRequest = requestStatisticsService.getTypeStatsByPeriod(startDate, endDate, currentRequestTypeId, null)
                            typeStatsIntervalType = requestStatisticsService.getTypeStatsIntervalType(startDate, endDate)
                            statsForRequest.eachWithIndex { date, count, i ->
                                if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.HOUR) {
                                    format = message(code:'statistics.type.hourlyDateFormat')
                                    shiftUnit = Calendar.HOUR_OF_DAY
                                } else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.DAY) {
                                    format = message(code:'statistics.type.dailyDateFormat')
                                    shiftUnit = Calendar.DAY_OF_MONTH
                                } else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.TWO_DAYS) {
                                    format = message(code:'statistics.type.bidaylyDateFormat')
                                    shiftUnit = Calendar.DAY_OF_MONTH
                                } else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.WEEK) {
                                    format = message(code:'statistics.type.weeklyDateFormat')
                                    shiftUnit = Calendar.DAY_OF_MONTH
                                } else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.MONTH) {
                                    format = message(code:'statistics.type.monthlyDateFormat')
                                    shiftUnit = Calendar.MONTH
                                } else if (typeStatsIntervalType == IRequestStatisticsService.TypeStatsIntervalType.YEAR) {
                                    format = message(code:'statistics.type.yearlyDateFormat')
                                    shiftUnit = Calendar.YEAR
                                }
                                line = new String[4]
                                line[0] = translationService.translateRequestTypeLabel(requestTypeService.getRequestTypeById(currentRequestTypeId).label)
                                line[1] = new SimpleDateFormat(format).format(date)
                                //if (i == statsForRequest.size() - 1) {
                                //    line[2] = line[1]
                                //}
                                if (i > 0) {
                                    data[data.size() - 1][2] = new SimpleDateFormat(format).format(fr.cg95.cvq.util.DateUtils.getShiftedDate(date, shiftUnit, -1))
                                }
                                line[3] = count.toString()
                                data.add(line)
                                if (i > 0) {
                                    data[data.size() - 2][2] = new SimpleDateFormat(format).format(fr.cg95.cvq.util.DateUtils.getShiftedDate(date, shiftUnit, -1))
                                }
                            }
                        }
                    }
                    break
                case "state" :
                    stats = requestStatisticsService.getStateStats(startDate, endDate, requestTypeId, categoryId)
                    def statesLine = new String[stats.size()]
                    def valuesLine = new String[stats.size()]
                    def index = 0
                    stats.entrySet().each {
                        statesLine[index] = message(code : CapdematUtils.adaptCapdematEnum(it.key, 'request.state').i18nKey)
                        valuesLine[index] = it.value.toString()
                        index++
                    }
                    data.add(statesLine)
                    data.add(valuesLine)
                    break
                case "quality" :
                    def line = new String[4]
                    line[0] = message(code : "property.requestType")
                    line[1] = message(code : "statistics.quality.green")
                    line[2] = message(code : "statistics.quality.orange")
                    line[3] = message(code : "statistics.quality.red")
                    data.add(line)
                    stats = requestStatisticsService.getQualityStatsByType(startDate, endDate, requestTypeId, categoryId)
                    requestAdaptorService.translateAndSortRequestTypes(true).each {
                        if ((requestTypeId == null || requestTypeId == it.id) && (categoryId == null || categoryId == it.categoryId)) {
                            line = new String[4]
                            line[0] = it.label
                            line[1] = stats[it.id] != null && stats[it.id].get(IRequestStatisticsService.QUALITY_TYPE_OK) != null ? stats[it.id].get(IRequestStatisticsService.QUALITY_TYPE_OK) : 0
                            line[2] = stats[it.id] != null && stats[it.id].get(IRequestStatisticsService.QUALITY_TYPE_ORANGE) != null ? stats[it.id].get(IRequestStatisticsService.QUALITY_TYPE_ORANGE) : 0
                            line[3] = stats[it.id] != null && stats[it.id].get(IRequestStatisticsService.QUALITY_TYPE_RED) != null ? stats[it.id].get(IRequestStatisticsService.QUALITY_TYPE_RED) : 0
                            data.add(line)
                        }
                    }
                    break
            }
            writer.writeAll(data)
            writer.close()
        }
        response.setHeader("Content-disposition", "attachment; filename=\"" + filenameParts.join(" - ") + "." + extension + "\"")
        render(contentType : contentType, text : content)
    }
}
