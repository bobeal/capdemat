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
                      'pageState' : (new JSON(state)).toString().encodeAsHTML(),
                      'state': state,
                      'currentStatisticType':'type'].plus(initStatisticsReferential()))
    }

//    def detailedStatsUrl(timescale, lifecycle, requestTypeId, categoryId) {
//        def labels = []
//        def maxY = 1
//        def cdData = []
//        def titleRow = lifecycle == IRequestStatisticsService.Lifecycle.CREATED ? "Nombre de téléservices créés par jour" : "Nombre de téléservices traités par jour"
//        def monthViewDateFormatter = new SimpleDateFormat("dd/MM")
//        def results =
//            requestStatisticsService.getDetailedStats(timescale, lifecycle, requestTypeId, categoryId)
//        results.eachWithIndex { k,v,index ->
//            if (index % 3 == 0)
//            	labels.add(monthViewDateFormatter.format(k))
//            else
//                labels.add('')
//            cdData.add(v.intValue())
//            if (v.intValue() > maxY)
//                maxY = v.intValue()
//        }
//        def transformedCdData = cdData.collect {  k ->
//               k = ((k * 100) / maxY).floatValue();
//        }
//
//        def chart = new GoogleChartBuilder()
//        def url = chart.barChart(['vertical','grouped']) {
//            size(w:400,h:200)
//            /*
//            title() {
//                row(titleRow)
//                row("(total : ${cdData.sum()})")
//            }
//            */
//            barSize(witdth:4, space:2)
//            data(encoding:'text') {
//        		dataSet(transformedCdData)
//            }
//            if (maxY < 10)
//                axis(bottom:labels,left:(0..maxY).toList())
//            else
//                axis(bottom:labels,left:(0..maxY).step((maxY/10).intValue()).toList())
//            colors {
//                color('84c984')
//            }
//        }
//
//      	return url
//    }
//
//    def summarizedStatsUrl(lifecycle) {
//        def textLabels = []
//        def cdData = []
//        def results = requestStatisticsService.getSummarizedStats(IRequestStatisticsService.Timescale.MONTH,
//                lifecycle, null, null)
//        results.each { k,v ->
//			if (v.intValue() > 0) {
//			    def label = new StringBuffer().append(translationService.getEncodedRequestTypeLabelTranslation(k.label))
//			    	.append(" (").append(v).append(")")
//        		textLabels.add(label.toString())
//            	cdData.add(v.intValue())
//			}
//        }
//
//        def chart = new GoogleChartBuilder()
//        def url = chart.pieChart {
//            size(w:700,h:200)
//            /*
//            title() {
//                row('Total : ${cdData.sum()}')
//            }
//            */
//            data(encoding:'text') {
//        		dataSet(cdData)
//            }
//			labels {
//			    textLabels.each { label(it) }
//			}
//        }
//
//      	return url
//    }

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
            title() {
                row('Qualité de service')
            }
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
                'timescales':timescales,
                'allRequestTypes':requestAdaptorService.translateAndSortRequestTypes(true),
                'statisticTypes':statisticTypes]
    }
}
