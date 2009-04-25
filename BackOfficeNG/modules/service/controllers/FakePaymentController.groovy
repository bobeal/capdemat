class FakePaymentController {
    
    def defaultAction = 'index'
    
    def index = {}

    def process = {
        def url = "${params.callbackUrl}?cvqReference=${params.cvqReference}"+
            "&bankReference=${params.cvqReference}&capDematFake=true&status="
        
        if (params.cardNumber.equals('0123456789')) url = url + 'OK'
        else if (params.cardNumber.equals('0000000000')) url = url + 'CANCELLED'
        else if (params.cardNumber.equals('9999999999')) url = url + 'REFUSED'

        redirect(url:url)
        return false
    }
}
