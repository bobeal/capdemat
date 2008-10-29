package fr.cg95.cvq;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the fr.cg95.cvq.service package or any sub-package
     * under that.
     */
    /*
    @Pointcut("within(fr.cg95.cvq.service..*)")
    public void inServiceLayer() {}
     */
    
    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the fr.cg95.cvq.dao package or any sub-package
     * under that.
     */
    /*
    @Pointcut("within(fr.cg95.cvq.dao..*)")
    public void inDataAccessLayer() {}
     */
    
    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     * 
     * If you group service interfaces by functional area (for example, 
     * in packages com.xyz.someapp.abc.service and com.xyz.def.service) then
     * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
     * could be used instead.
     *
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* fr.cg95.cvq.service..*Service.*(..)) || execution(* fr.cg95.cvq.payment..*Service.*(..)) || execution(* fr.cg95.cvq.external..*Service.*(..))")
    public void businessService() {}
    
    /**
     * A data access operation is the execution of any method defined on a 
     * dao interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
    /*
    @Pointcut("execution(* fr.cg95.cvq.dao..*.*(..))")
    public void dataAccessOperation() {}
    */
}
