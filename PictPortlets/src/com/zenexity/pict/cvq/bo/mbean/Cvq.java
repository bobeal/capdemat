package com.zenexity.pict.cvq.bo.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exporter.service.bo.IProvisioningService;

public class Cvq implements CvqMBean {

    private IProvisioningService provisioningService;
    private String siteName;

    public Cvq() throws Exception {
        ObjectName objectName = new ObjectName("com.zenexity.pict.cvq:name=portlets");
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        try {
            server.unregisterMBean(objectName);
        } catch (Exception e) {
            // ok
        }
        server.registerMBean(this,objectName);
    }

    public boolean agentExists(String login)
        throws Exception {

        try {
            return provisioningService.agentExists(siteName, login);
        } catch (CvqException ce) {
            // TODO : fail silently or throw an exception ?
            // return false;
            throw new RuntimeException(ce);
        }
    }

    public void setProvisioningService(IProvisioningService provisioningService) {
        this.provisioningService = provisioningService;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
