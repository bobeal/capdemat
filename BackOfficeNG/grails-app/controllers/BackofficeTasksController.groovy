import java.util.Hashtable

import fr.cg95.cvq.business.QoS
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

class BackofficeTasksController {

    IRequestSearchService requestSearchService
    IIndividualService individualService

    def defaultAction = 'tasks'

    // Default number of tasks to show per type
    def tasksShownNb = 5
    def beforeInterceptor = {
        session['currentMenu'] = 'tasks'
    }

    def tasks = {
        def taskMap = [:]

        taskMap.aboutRequests = [
            'late' : [
                'count' : requestSearchService.countTasks(Request.QUALITY_TYPE_RED),
                'all' : requestSearchService.listTasks(Request.QUALITY_TYPE_RED,
                        Request.SEARCH_BY_CREATION_DATE,
                        tasksShownNb)
            ],
            'urgent' : [
                'count' : requestSearchService.countTasks(Request.QUALITY_TYPE_ORANGE),
                'all' : requestSearchService.listTasks(Request.QUALITY_TYPE_ORANGE,
                        Request.SEARCH_BY_CREATION_DATE,
                        tasksShownNb)
            ],
            'good' : [
                'count' : requestSearchService.countTasks(Request.QUALITY_TYPE_OK),
                'all' : requestSearchService.listTasks(Request.QUALITY_TYPE_OK,
                        Request.SEARCH_BY_CREATION_DATE,
                        tasksShownNb)
            ]
        ]

        taskMap.aboutIndividuals = [
            'late' : [
                'count' : individualService.countTasks(QoS.LATE),
                'all' : individualService.listTasks(QoS.LATE, tasksShownNb)
            ],
            'urgent' : [
                'count' : individualService.countTasks(QoS.URGENT),
                'all' : individualService.listTasks(QoS.URGENT, tasksShownNb)
            ],
            'good' : [
                'count' : individualService.countTasks(QoS.GOOD),
                'all' : individualService.listTasks(QoS.GOOD, tasksShownNb)
            ]
        ]

        return ['taskMap' : taskMap]
    }
}
