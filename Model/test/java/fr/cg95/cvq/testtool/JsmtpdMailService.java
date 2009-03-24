package fr.cg95.cvq.testtool;

import java.io.IOException;

import org.jsmtpd.utils.junit.SmtpServer;

public class JsmtpdMailService {

    private int port;
    private SmtpServer server;
    
    public void init() throws IOException {
        server = new SmtpServer();
        server.start(port);
    }

    public void destroy() {
        server.stop();
    }
    
    public void setPort(int port) {
        this.port = port;
    }

    public SmtpServer getServer() {
        return server;
    }

}
