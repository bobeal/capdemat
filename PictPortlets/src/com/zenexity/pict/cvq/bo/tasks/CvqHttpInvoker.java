package com.zenexity.pict.cvq.bo.tasks;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.remoting.httpinvoker.SimpleHttpInvokerRequestExecutor;

public class CvqHttpInvoker extends SimpleHttpInvokerRequestExecutor {

    private static final Log log = LogFactory.getLog(CvqHttpInvoker.class);

    private String serviceUrl;

    protected void prepareConnection(HttpURLConnection con, int contentLength)
        throws IOException {
        super.prepareConnection(con, contentLength);

        try {
            String serviceName = serviceUrl.substring(serviceUrl.indexOf("http://") + "http://".length());
            ObjectName objectName = new ObjectName("Cas:name=tickets");
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String ticket = (String) server.invoke(objectName, "getProxyTicket",
                                                   new String[]{serviceName},
                                                   new String[]{"java.lang.String"});

            log.debug("prepareConnection() Got ticket : " + ticket);
            con.setRequestProperty("ticket", ticket);
        } catch (Exception e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
}
