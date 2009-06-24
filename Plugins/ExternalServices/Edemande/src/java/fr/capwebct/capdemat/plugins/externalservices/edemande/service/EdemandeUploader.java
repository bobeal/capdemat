package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import java.io.ByteArrayInputStream;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
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

    private EdemandeUploader(){}

    public EdemandeUploader(String username, String hostname, int port, byte[] prvkey, String passphrase, String basedir)
        throws Exception {
        super();
        addIdentity(username, prvkey, null, new byte[0]);
        session = getSession(username, hostname, port);
        session.setUserInfo(new MyUserInfo(passphrase));
        this.basedir = basedir;
        if (!basedir.endsWith("/")) basedir += "/";
    }

    public String upload(String filename, byte[] data) throws Exception {
        session.connect();
        ChannelSftp sftp = (ChannelSftp)session.openChannel("sftp");
        sftp.connect();
        sftp.put(new ByteArrayInputStream(data), basedir + filename);
        sftp.disconnect();
        session.disconnect();
        return basedir + filename;
    }
}
