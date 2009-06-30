package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import java.io.ByteArrayInputStream;

import org.apache.commons.codec.binary.Base64;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;

/**
 * @author jsb@zenexity.fr
 *
 */
public class EdemandeUploader extends JSch {

    private final class MyUserInfo implements UserInfo {
        private String passphrase;
        private MyUserInfo() {}
        private MyUserInfo(String passphrase) { this.passphrase = passphrase; }
        public String getPassphrase() { return passphrase; }
        public String getPassword() { return null; }
        public boolean promptPassphrase(String message) { return false; }
        public boolean promptPassword(String message) { return false; }
        public boolean promptYesNo(String message) { return false; }
        public void showMessage(String message) {}
    }

    private Session session;
    private String basedir;
    private String username;
    private String hostname;
    private int port;
    private MyUserInfo ui;

    private EdemandeUploader(){}

    public EdemandeUploader(String username, String hostname, int port, byte[] prvkey, String passphrase, String basedir, byte[] hostkey)
        throws JSchException {
        super();
        this.getHostKeyRepository().add(new HostKey(hostname, Base64.decodeBase64(hostkey)), null);
        addIdentity(username, prvkey, null, passphrase.getBytes());
        this.username = username;
        this.hostname = hostname;
        this.port = port;
        this.ui = new MyUserInfo(passphrase);
        this.basedir = basedir;
        if (!this.basedir.endsWith("/")) this.basedir += "/";
    }

    public String upload(String filename, byte[] data)
        throws JSchException, SftpException {
        session = getSession(username, hostname, port);
        session.setUserInfo(ui);
        session.connect();
        ChannelSftp sftp = (ChannelSftp)session.openChannel("sftp");
        sftp.connect();
        sftp.put(new ByteArrayInputStream(data), basedir + filename);
        sftp.disconnect();
        session.disconnect();
        return basedir + filename;
    }
}
