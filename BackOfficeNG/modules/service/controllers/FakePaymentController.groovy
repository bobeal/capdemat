

class FakePaymentController {
    
    def defaultAction = "index"
    def beforeInterceptor = {}
    
    def index = {}
    def process = {
        def url = "${params.callbackUrl}?cvqReference=${params.cvqReference}"
            +"&bankReference=${params.cvqReference}&capDematFake=true&status="
        
        if (params.cardNumber.equals("0123456789")) url.append("OK");
        else if (params.cardNumber.equals("0000000000")) url.append("CANCELLED");
        else if (params.cardNumber.equals("9999999999")) url.append("REFUSED");
        
        redirect(url:url)
        return false
    }
    
}
