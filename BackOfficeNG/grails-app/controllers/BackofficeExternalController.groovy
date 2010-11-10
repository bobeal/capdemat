import fr.cg95.cvq.business.external.ExternalServiceTrace
import fr.cg95.cvq.business.external.TraceStatusEnum
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.util.Critere

class BackofficeExternalController {

    def externalService
    def requestAdaptorService

    def defaultSortBy = ExternalServiceTrace.SEARCH_BY_DATE
    def count = 15

    def search = {
        if (request.get) {
            return [
                "inSearch" : false,
                "sortBy" : defaultSortBy,
                "lastOnly" : true,
                "filters" : [:]
            ].plus(initSearchReferential())
        } else if (request.post) {
            Set<Critere> criteria = new HashSet<Critere>()
            if (params.key)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                    params.key, Critere.EQUALS))
            if (params.dateFrom)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                    DateUtils.stringToDate(params.dateFrom), Critere.GTE))
            if (params.dateTo)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                    DateUtils.stringToDate(params.dateTo), Critere.LTE))
            def parsedFilters = SearchUtils.parseFilters(params.filterBy)
            if (parsedFilters.filters.externalServiceLabelFilter)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_NAME,
                    parsedFilters.filters.externalServiceLabelFilter,
                    Critere.EQUALS))
            if (parsedFilters.filters.statusFilter)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_STATUS,
                    TraceStatusEnum.forString(parsedFilters.filters.statusFilter),
                    Critere.EQUALS))
            if (parsedFilters.filters.requestTypeFilter)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_REQUEST_TYPE,
                    parsedFilters.filters.requestTypeFilter, Critere.EQUALS))
            if (parsedFilters.filters.requestStateFilter)
                criteria.add(new Critere(ExternalServiceTrace.SEARCH_BY_REQUEST_STATE,
                    parsedFilters.filters.requestStateFilter, Critere.EQUALS))
            def sortBy = params.sortBy ? params.sortBy : defaultSortBy
            def offset
            try {
                offset = Integer.valueOf(params.offset)
            } catch (NumberFormatException e) {
                offset = 0
            }
            def traces
            def totalRecords
            if (params.lastOnly) {
                traces = externalService.getLastTraces(criteria, sortBy, "desc", count, offset)
                totalRecords = externalService.getLastTracesCount(criteria)
            } else {
                traces = externalService.getTraces(criteria, sortBy, "desc", count, offset)
                totalRecords = externalService.getTracesCount(criteria)
            }
            traces = requestAdaptorService.prepareTraces(traces)
            return [
                "key" : params.key,
                "dateFrom" : params.dateFrom,
                "dateTo" : params.dateTo,
                "traces" : traces,
                "totalRecords" : totalRecords,
                "lastOnly" : params.lastOnly,
                "filters":parsedFilters.filters,
                "filterBy":parsedFilters.filterBy,
                "offset" : offset,
                "sortBy" : sortBy,
                "inSearch" : true
            ].plus(initSearchReferential())
        }
    }

    private initSearchReferential() {
        return [
            "externalServiceLabels" : SecurityContext.currentConfigurationBean
                .externalProviderServices.collect { it.key.label },
            "traceStatuses" : TraceStatusEnum.allTraceStatuses,
            "requestStates" : RequestState.allRequestStates.findAll { it != RequestState.DRAFT },
            "requestTypes" : requestAdaptorService.translateAndSortRequestTypes()
        ]
    }
}
