package fr.cg95.cvq.aspect.development;

import fr.cg95.cvq.aspect.CapDematAbstractBaseAspect;

import org.apache.log4j.Logger;

public aspect TracingAspect extends CapDematAbstractBaseAspect {

    private static Logger logger = Logger.getRootLogger();
    
    Object around() : serviceCalls() {
        long startTime = System.currentTimeMillis();
        
        Object returnedObject = proceed();
        
        long endTime = System.currentTimeMillis();
        logger.debug("method took " + String.valueOf(endTime - startTime));
        return returnedObject;
    }
}