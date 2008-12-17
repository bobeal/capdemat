import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.util.Critere

//import groovy.GoogleChartBuilder

import java.text.SimpleDateFormat

class StatisticController {
    
    IRequestStatisticsService requestStatisticsService
    IRequestService defaultRequestService
	ICategoryService categoryService
    
    def translationService

    def beforeInterceptor = {
            session["currentMenu"] = "statistics"
    }

	def defaultAction = "view"

	def timescales = [
		"Semaine" : IRequestStatisticsService.Timescale.WEEK ,
		"Mois" : IRequestStatisticsService.Timescale.MONTH,
		"Année" : IRequestStatisticsService.Timescale.YEAR
	]
    
    def view = {
            // TEMP : move to a better place
            def allRequestTypes = defaultRequestService.getAllRequestTypes()
            def requestTypes = [:]
            allRequestTypes.each {
                def requestTypeId = it.id.toString()
                def label = translationService.getEncodedRequestTypeLabelTranslation(it.label)
            	requestTypes[requestTypeId] = label
            }
            
    		// deal with search parameters
    		def timescale = params.timescale ? timescales[params.timescale] : IRequestStatisticsService.Timescale.MONTH
    		
            ["detailedCreatedUrl":
                detailedStatsUrl(timescale, IRequestStatisticsService.Lifecycle.CREATED,
                        params.requestTypeId, params.categoryId), 
             "summarizedCreatedUrl":summarizedStatsUrl(IRequestStatisticsService.Lifecycle.CREATED),
             "detailedTreatedUrl":
                 detailedStatsUrl(timescale, IRequestStatisticsService.Lifecycle.TREATED,
                         params.requestTypeId, params.categoryId),
             "summarizedTreatedUrl":summarizedStatsUrl(IRequestStatisticsService.Lifecycle.TREATED),
             "qualityUrl":qualityStatsUrl(),
             "categories":categoryService.getAll(),
             "timescales":timescales,
             "requestTypes":requestTypes]
    }
    
    def detailedStatsUrl(timescale, lifecycle, requestTypeId, categoryId) {
        def labels = []
        def maxY = 1
        def cdData = []
        def titleRow = lifecycle == IRequestStatisticsService.Lifecycle.CREATED ? "Nombre de téléservices créés par jour" : "Nombre de téléservices traités par jour"
        def monthViewDateFormatter = new SimpleDateFormat("dd/MM")
        def results = 
            requestStatisticsService.getDetailedStats(timescale, lifecycle, requestTypeId, categoryId)
        results.eachWithIndex { k,v,index ->
            if (index % 3 == 0)
            	labels.add(monthViewDateFormatter.format(k))
            else 
                labels.add('')
            cdData.add(v.intValue())
            if (v.intValue() > maxY)
                maxY = v.intValue()
        }            
        def transformedCdData = cdData.collect {  k ->
               k = ((k * 100) / maxY).floatValue();
        }
        
        def chart = new GoogleChartBuilder()
        def url = chart.barChart(['vertical','grouped']) {
            size(w:400,h:200)
            /*
            title() {
                row(titleRow)
                row("(total : ${cdData.sum()})")
            }
            */
            barSize(witdth:4, space:2)
            data(encoding:'text') {
        		dataSet(transformedCdData)        
            }
            axis(bottom:labels,left:(0..maxY).step((maxY/10).intValue()).toList())
            colors {
                color('84c984')
            }
        }            
        
      	return url
    }
    
    def summarizedStatsUrl(lifecycle) {
        def textLabels = []
        def cdData = []
        def results = requestStatisticsService.getSummarizedStats(IRequestStatisticsService.Timescale.MONTH,
                lifecycle, null, null)
        results.each { k,v ->
			if (v.intValue() > 0) {
			    def label = new StringBuffer().append(translationService.getEncodedRequestTypeLabelTranslation(k.label))
			    	.append(" (").append(v).append(")")
        		textLabels.add(label.toString())
            	cdData.add(v.intValue())
			}
        }            
        
        def chart = new GoogleChartBuilder()
        def url = chart.pieChart {
            size(w:700,h:200)
            /*
            title() {
                row('Total : ${cdData.sum()}')
            }
            */
            data(encoding:'text') {
        		dataSet(cdData)        
            }
			labels {
			    textLabels.each { label(it) }
			}
        }            
        
      	return url
    }

    def qualityStatsUrl() {
        def textLabels = []
        def cdData = []
        def cdColors = []
        def results = requestStatisticsService.getQualityStats(IRequestStatisticsService.Timescale.MONTH,
                null, null)
        results.each { k,v ->
			if (v.intValue() > 0) {
			    if (k == "qualityTypeOk")
        			cdColors.add('74c343')
        		else if (k == "qualityTypeOrange")
        		    cdColors.add('ff9523')
        		else if (k == "qualityTypeRed")
        		    cdColors.add('ed2024')
            	cdData.add(v.intValue())
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
        }            
        
      	return url
    }

}
