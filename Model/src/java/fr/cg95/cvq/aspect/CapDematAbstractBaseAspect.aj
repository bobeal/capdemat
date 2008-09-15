package fr.cg95.cvq.aspect;

public abstract aspect CapDematAbstractBaseAspect {

    public pointcut serviceCalls() : 
        call(* fr.cg95.cvq.external..*.*(..))
        || call(* fr.cg95.cvq.payment..*.*(..))
        || call(* fr.cg95.cvq.platform..*.*(..))
        || call(* fr.cg95.cvq.service..*.*(..)) 
        || call(* fr.cg95.cvq.util..*.*(..)) ;

    public pointcut securityCalls() : 
        call(* fr.cg95.cvq.authentication..*.*(..))
        || call(* fr.cg95.cvq.permission..*.*(..))
        || call(* fr.cg95.cvq.security..*.*(..));
    
    public pointcut daoCalls() : call(* fr.cg95.cvq.dao..*.*(..));


}
