import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.service.payment.PaymentResultStatus

class ServiceFakePaymentController {

    IPaymentService paymentService

    def defaultAction = 'index'
    
    def index = {}

    def process = {

        def separator = params.callbackUrl.contains('?') ? '&' : '?'
        def url = "${params.callbackUrl}${separator}cvqReference=${params.cvqReference}"+
            "&bankReference=${params.cvqReference}&capDematFake=true&status="
        
        def status = ''
        if (params.cardNumber == '0123456789') status = 'OK'
        else if (params.cardNumber == '0000000000') status = 'CANCELLED'
        else if (params.cardNumber == '9999999999') status = 'REFUSED'
        url = url + status

        // Commit payment in CapDemat to know immediatly result in Fake context
        def paymentParams = [:]
        paymentParams.capDematFake = 'capDematFake'
        paymentParams.cvqReference = params.cvqReference
        paymentParams.status = status
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT)
        PaymentResultStatus paymentResultStatus = paymentService.commitPayment(paymentParams)

        redirect(url:url)
        return false
    }
}
