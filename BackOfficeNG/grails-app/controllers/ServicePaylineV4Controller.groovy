import org.apache.commons.lang.StringUtils

import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.payment.IPaymentService

class ServicePaylineV4Controller {

    IPaymentService paymentService

    def commit = {
        if (log.isDebugEnabled()) {
            params.each {
                log.debug "Got parameter ${it.key} with value ${it.value}"
            }
        }
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT)
        paymentService.commitPayment(["token" : params.token])
        render ""
    }
}
