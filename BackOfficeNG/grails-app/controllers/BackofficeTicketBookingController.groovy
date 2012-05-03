import fr.cg95.cvq.business.request.ticket.Entertainment
import fr.cg95.cvq.business.request.ticket.PlaceCategory
import fr.cg95.cvq.business.request.ticket.Fare
import fr.cg95.cvq.business.request.ticket.Event
import fr.cg95.cvq.business.request.ticket.Subscriber
import fr.cg95.cvq.business.request.ticket.FareType
import fr.cg95.cvq.service.request.ITicketBookingService
import fr.cg95.cvq.service.request.ILocalReferentialService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Version

import fr.cg95.cvq.exception.CvqTicketBookingException
import fr.cg95.cvq.util.DateUtils
import fr.cg95.cvq.util.ImageUtils
import org.joda.time.IllegalFieldValueException

import grails.converters.JSON

class BackofficeTicketBookingController {

    ITicketBookingService ticketBookingService
    ILocalReferentialService localReferentialService
    ILocalAuthorityRegistry localAuthorityRegistry

    def beforeInterceptor = { session['currentMenu'] = 'requestType' }
    
    def subscriberRecordsReturned = 15

    def index = {
        def entertainments = ticketBookingService.getAllEntertainments()
        render(template:'ticketBooking', model:['entertainments':entertainments])
    }

    def entertainments = {
        def entertainments = ticketBookingService.getAllEntertainments()
        render(template:'entertainments', model:['entertainments':entertainments])
    }

    def entertainment = {
        def entertainment = params.id ? ticketBookingService.getEntertainmentById(Long.valueOf(params.id)) : null
        if (request.get) {
            def categories = localReferentialService.getLocalReferentialType('Ticket Booking', 'entertainmentCategories')
            render(template:'entertainmentForm',  model:['entertainment':entertainment, 'categories':categories])
            return false
        } else if (request.post) {
            response.contentType = 'text/html; charset=utf-8'
            if (params.logoFile) {
                def logoFile = request.getFile('logoFile')
                if (!logoFile.empty) {
                    if (ImageUtils.getFormatName(logoFile.bytes) != 'png'
                        || ImageUtils.getWidth(logoFile.bytes) > 100 || ImageUtils.getHeight(logoFile.bytes) > 100) {
                        render (new JSON(['status':'warning', 'message':message(code:'entertainment.message.logoInformation')]).toString())
                        return false
                    } else {
                        entertainment.logo = logoFile.bytes
                    }
                }
            }
            if (entertainment == null) entertainment = new Entertainment()
            DataBindingUtils.initBind(entertainment, params)
            bind(entertainment)
            if (entertainment.id == null) ticketBookingService.createEntertainment(entertainment)

            render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
            return false
        }
    }

    def removeEntertainment = {
        ticketBookingService.deleteEntertainment(Long.valueOf(params.id))
        render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
        return false
    }

    def event = {
        if (request.get) {
            def event = params.id != '' ? ticketBookingService.getEventById(Long.valueOf(params.id)) : null
            if (request.get) {
                render(template:'eventForm',  
                      model:['entertainmentId': params.entertainmentId, 
                             'event': event,
                            ])
                return false
            }
        } else if (request.post) {
            def event
            if (params.eventId == '') {
                event = new Event()
                def entertainment = ticketBookingService.getEntertainmentById(Long.valueOf(params.entertainmentId))
                event.entertainment = entertainment
                entertainment.events.add(event) 
            } else {
                event = ticketBookingService.getEventById(Long.valueOf(params.eventId))
            }
            bind(event)
            try {
                event.date = DateUtils.setTime(event.date, params.dateHour, params.dateMinute)
                event.bookingStart = DateUtils.setTime(event.bookingStart, params.bookingStartHour, params.bookingStartMinute)
                event.bookingEnd = DateUtils.setTime(event.bookingEnd, params.bookingEndHour, params.bookingEndMinute)
            } catch (IllegalFieldValueException e) {
                render (new JSON(['status':'error', 'message':message(code:'ticketBooking.error.minutesOrHoursOutOfRange')]).toString())
                return false
            }
            render (new JSON([
                'status': 'success', 
                'message': message(code:'message.updateDone'),
                'eventAsItem': formatDate(formatName:'format.fullDate', date:event.date) + ' (' + event.place + ')'    
            ]).toString())
            return false
        }
    }

    def removeEvent = {
        ticketBookingService.deleteEvent(Long.valueOf(params.eventId))
        render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
        return false
    }

    def entertainmentLogo = {
        def entertainment = ticketBookingService.getEntertainmentById(Long.valueOf(params.id))   
        response.contentType = 'image/png'
        response.outputStream << entertainment.logo
        return false
    }

    def fares = {
        def event = ticketBookingService.getEventById(Long.valueOf(params.eventId))
        if (request.get) {
            render(template:'faresForm',  
                  model:['event': event,
                         'lrTypes': localReferentialAsMap('Ticket Booking', event) 
                        ])
        }
    }

    def addPlaceCategory = {
        def event = ticketBookingService.getEventById(Long.valueOf(params.eventId))
        event.placeCategories.add(new PlaceCategory(params.placeCategoryName))
        render (new JSON(['status':'success', 'message':message(code:'ticketBooking.message.addCategory', args:[params.placeCategoryName])]).toString())
        return false
    }

    def removePlaceCategory = {
        ticketBookingService.deletePlaceCategory(
            Long.valueOf(params.placeCategoryId), Long.valueOf(params.eventId))
        render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
        return false
    }

    def savePlaceCategory = {
        def placeCategory = ticketBookingService.getPlaceCategoryById(Long.valueOf(params.id))
        placeCategory.placeNumber = Integer.valueOf(params.placeNumber)
        render (new JSON(['status':'success', 'message':message(code:'ticketBooking.message.placeCategoryUpdate', args:[placeCategory.name])]).toString())
        return false
    }

    def addFare = {
        def placeCategory = ticketBookingService.getPlaceCategoryById(Long.valueOf(params.placeCategoryId))
        def fare = new Fare()
        ticketBookingService.updateFare(fare)
        placeCategory.fares.add(fare) 
        render (new JSON([
                'fareId':fare.id, 
                'status':'success', 
                'message':message(code:'message.updateDone')]).toString())
        return false
    }

    def saveFare = {
        def fare = ticketBookingService.getFareById(Long.valueOf(params.id))
        bind(fare)
        render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
        return false
    }

    def removeFare = {
         ticketBookingService.deleteFare(
            Long.valueOf(params.fareId), Long.valueOf(params.placeCategoryId))
        render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
        return false
    }

    private localReferentialAsMap (requestTypeLabel, event) {
        def referentials = localReferentialService.getLocalReferentialTypes(requestTypeLabel)
        def lrTypes = [:]
        referentials.each {lrTypes.put(it.name, it)}
        
        def configuredPlaceCategories = []
        event.placeCategories.each {configuredPlaceCategories.add(it.name)}
        def it = lrTypes.placeCategories?.entries?.iterator()
        while (it.hasNext()) {
            def lre = it.next()
            if (configuredPlaceCategories.contains(lre.label))
                it.remove()
        }
        return lrTypes
    }

    def importEntertainments = {
        def file = request.getFile('csvFile')
        response.contentType = 'text/html; charset=utf-8'
        if (file.empty) {
            render (new JSON(['status':'warning', 'message':message(code:'ticketBooking.message.noFile')]).toString())
            return false
        }
        def report
        try {
            report = ticketBookingService.importEntertainments(file.bytes)
        } catch (CvqTicketBookingException e){
            render (new JSON(['status':'error', 'message':message(code:e.i18nKey)]).toString())
            return false
        }
        def msg = message(code:'ticketBooking.message.entertainùentsImported')
        ['entertainment','event','placeCategory','fare'].each {
            msg += '<br> ' + message(code:it + '.message.ImportReport', args:[report[it]])
        }
        render (new JSON(['status':'success', 'message':msg]).toString())
        return false
    }

    def defaultLogo = {
        def file = request.getFile('logo') 
        response.contentType = 'text/html; charset=utf-8'
        if (file.empty) {
            render (new JSON(['status':'warning', 'message':message(code:'message.noFile')]).toString())
            return false
        }
        if (ImageUtils.getFormatName(file.bytes) != 'png'
            || ImageUtils.getWidth(file.bytes) > 100 || ImageUtils.getHeight(file.bytes) > 100) {
            render (new JSON(['status':'warning', 'message':message(code:'entertainment.error.logoInformation')]).toString())
            return false
        }

        localAuthorityRegistry.saveLocalAuthorityResource(Type.IMAGE, 'ticketBookingNoLogo', file.bytes)
        render (new JSON([ 'status':'success', 'message':message(code:'message.updateDone')]).toString())
    }

    def subscribers = {
        def orderBy = params.orderBy
        def startIndex = params.startIndex ? Integer.valueOf(params.startIndex) : 0
        if (params.dir == 'next') startIndex += subscriberRecordsReturned
        if (params.dir == 'prev') startIndex -= subscriberRecordsReturned

        def subscribers = ticketBookingService.getSubscribers(
            null, orderBy, null, subscriberRecordsReturned, startIndex)

        def displayDir = [:]
        displayDir.prev = startIndex > 0 ? true : false
        // FIXME: use "select count ..." instead
        displayDir.next = subscribers.size() == subscriberRecordsReturned ? true : false

        render(template:'subscribers', model:[
            'subscribers': subscribers,
            'orderBySubscriber': orderBy,
            'startIndexSubscriber': startIndex,
            'displayDirSubscriber': displayDir
            ])
    }

    def importSubscribers = {
        def file = request.getFile('csvFile')
        response.contentType = 'text/html; charset=utf-8'
        if (file.empty) {
            render (new JSON(['status':'warning', 'message':message(code:'ticketBooking.message.noFile')]).toString())
            return false
        }
        def report
        try {
            report = ticketBookingService.importSubscribers(file.bytes)
        } catch (CvqTicketBookingException e){
            render (new JSON([ 'status':'error', 'message':message(code:e.i18nKey)]).toString())
            return false
        }
        def msg = message(code:'ticketBooking.message.subscribersImported')
        msg += '<br> ' + message(code:'subscriber.message.ImportReport', args:[report['subscriber']])
        render (new JSON(['status':'success', 'message':msg]).toString())
        return false
    }

    def subscriber = {
        def subscriber = params.id ? ticketBookingService.getSubscriberById(Long.valueOf(params.id)) : null
        if (request.get) {
            if (subscriber == null) subscriber = new Subscriber()
            render(template:'subscriberForm',  model:['subscriber':subscriber])
            return false
        } else if (request.post) {
            if (subscriber == null) subscriber = new Subscriber()
            bind(subscriber)
            if (params.fullFareLimit) subscriber.limits[FareType.PLEIN] = Integer.valueOf(params.fullFareLimit)
            if (params.reduceFareLimit) subscriber.limits[FareType.REDUIT] = Integer.valueOf(params.reduceFareLimit)
            if (subscriber.id == null) ticketBookingService.updateSubscriber(subscriber)
            render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
            return false
        }
    }

    def removeSubscriber = {
        ticketBookingService.deleteSubscriber(Long.valueOf(params.id))
        render (new JSON(['status':'success', 'message':message(code:'message.updateDone')]).toString())
        return false
    }
}

