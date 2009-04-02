import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

import GoogleChartBuilder

import java.text.SimpleDateFormat

class StatisticController {
    
    IRequestStatisticsService requestStatisticsService
    IRequestTypeService requestTypeService
	ICategoryService categoryService
    
    def requestAdaptorService
    def translationService

    def beforeInterceptor = {
        session['currentMenu'] = 'statistics'
    }

	def defaultAction = 'quality'

    def statisticTypes = ['state','type','quality']

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
                    .append(translationService.getEncodedRequestTypeLabelTranslation(requestType.label))
			    	.append(" (").append(count).append(")")
        		textLabels.add(label)
            	cdData.add(count.intValue())
			}
        }

        def chart = new GoogleChartBuilder()
        def url = chart.pieChart {
            size(w:700,h:300)
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
            /*
            title() {
                row('Qualité de service')
            }
            */
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
}
