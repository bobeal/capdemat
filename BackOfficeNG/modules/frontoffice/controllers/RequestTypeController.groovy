class RequestTypeController {

    def index = { 
        ['groups': CapdematUtils.requestGroup()]
    }
}
