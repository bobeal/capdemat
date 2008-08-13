package fr.capwebct.modules.payment.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.capwebct.modules.payment.service.IFtpService;

public class FtpService implements IFtpService {

    private static Log log = LogFactory.getLog(FtpService.class);
    
    private String ftpHost = "127.0.0.1";
    private int ftpPort = 21;
    private String ftpUsername;
    private String ftpPassword;
    private static int BLOCK_SIZE = 4096;

    private Socket connectionSocket;
    private PrintStream outputStream;
    private BufferedReader inputStream;
    private boolean loggedIn = false;

    
    public void uploadData(byte[] data, String filename) {
        log.debug("uploadData() uploading data to " + filename);
        try {
            connect();
            login();
            
            String command = "stor " + filename;

            ByteArrayInputStream baos = new ByteArrayInputStream(data);
            boolean success = executeDataCommand(command, baos);
            log.debug("uploadData() result is " + success);
            
            disconnect();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    /**
     * Connects to the given FTP host on the given port.
     */
    public boolean connect()
        throws UnknownHostException, IOException {
        
        connectionSocket = new Socket(ftpHost, ftpPort);
        outputStream = new PrintStream(connectionSocket.getOutputStream());
        inputStream = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        if (!isPositiveCompleteResponse(getServerReply())){
            disconnect();
            return false;
        }

        return true;
    }


    /**
     * Disconnects from the host to which we are currently connected.
     */
    public void disconnect()
    {
        if (outputStream != null) {
            try {
                if (loggedIn) { logout(); };
                outputStream.close();
                inputStream.close();
                connectionSocket.close();
            } catch (IOException e) {}

            outputStream = null;
            inputStream = null;
            connectionSocket = null;
        }
    }


    /**
     * Wrapper for the commands user [username] and pass
     * [password].
     */
    public boolean login() throws IOException {
        int response = executeCommand("user " + ftpUsername);
        if (!isPositiveIntermediateResponse(response)) return false;
        response = executeCommand("pass " + ftpPassword);
        loggedIn = isPositiveCompleteResponse(response);
        return loggedIn;
    }


    /**
     * Added by Julian: Logout before you disconnect (this is good form).
     */
    public boolean logout() throws IOException {
        int response = executeCommand("quit");
        loggedIn = !isPositiveCompleteResponse(response);
        return !loggedIn;
    }

    /**
     * Executes the given FTP command on our current connection, returning the
     * three digit response code from the server.  This method only works for
     * commands that do not require an additional data port.
     */
    public int executeCommand(String command) throws IOException {
        outputStream.println(command);
        return getServerReply();
    }

    /**
     * Executes the given ftpd command on the server and writes the results
     * returned on the data port to the given OutputStream, returning true
     * if the server indicates that the operation was successful.
     */
    public boolean executeDataCommand(String command, InputStream in)
        throws IOException {
        
        // Open a data socket on this computer
        ServerSocket serverSocket = new ServerSocket(0);
        if (!setupDataPort(command, serverSocket)) return false;
        Socket clientSocket = serverSocket.accept();

        // Transfer the data
        OutputStream out = clientSocket.getOutputStream();
        transferData(in, out);

        // Clean up the data structures
        in.close();
        clientSocket.close();
        serverSocket.close();

        return isPositiveCompleteResponse(getServerReply());    
    }

    /** 
     * Gets server reply code from the control port after an ftp command has
     * been executed.  It knows the last line of the response because it begins
     * with a 3 digit number and a space, (a dash instead of a space would be a
     * continuation).
     */
    private int getServerReply() throws IOException {
        return Integer.parseInt(getFullServerReply().substring(0, 3));
    }

    /** 
     * Gets server reply string from the control port after an ftp command has
     * been executed.  This consists only of the last line of the response,
     * and only the part after the response code.
     */
    private String getFullServerReply() throws IOException {
        String reply;

        do {
            reply = inputStream.readLine();
            log.debug(reply);
        } while (!(Character.isDigit(reply.charAt(0)) && 
                  Character.isDigit(reply.charAt(1)) &&
                  Character.isDigit(reply.charAt(2)) &&
                  reply.charAt(3) == ' '));

        return reply;
    }

    /**
     * True if the given response code is in the 300-399 range.
     */
    private boolean isPositiveIntermediateResponse(int response) {
        return (response >= 300 && response < 400);
    }

    /**
     * True if the given response code is in the 100-199 range.
     */
    private boolean isPositivePreliminaryResponse(int response)
    {
        return (response >= 100 && response < 200);
    }

    /**
     * True if the given response code is in the 200-299 range.
     */
    private boolean isPositiveCompleteResponse(int response) {
        return (response >= 200 && response < 300);
    }

    /**
     * Executes the given ftpd command on the server and writes the results
     * returned on the data port to the given FilterOutputStream, returning true
     * if the server indicates that the operation was successful.
     */
    private boolean setupDataPort(String command, ServerSocket serverSocket)
        throws IOException
    {
        // Send our local data port to the server
        if (!openPort(serverSocket)) return false;

        // Set binary type transfer
        outputStream.println("type i");
        if (!isPositiveCompleteResponse(getServerReply())) {
            log.debug("Could not set transfer type");
            return false;
        }

        // Send the command
        outputStream.println(command);

        return isPositivePreliminaryResponse(getServerReply());
    }

    /**
     * Transfers the data from the given input stream to the given output
     * stream until we reach the end of the stream.
     */
    private void transferData(InputStream in, OutputStream out)
        throws IOException {
        
        byte b[] = new byte[BLOCK_SIZE];
        int amount;

        // Read the data into the file
        while ((amount = in.read(b)) > 0) {
            out.write(b, 0, amount);
        }
    }

    /**
     * Get IP address and port number from serverSocket and send them via the
     * port command to the ftp server, returning true if we get a
     * valid response from the server, returning true if the server indicates
     * that the operation was successful.
     */
    private boolean openPort(ServerSocket serverSocket)
        throws IOException
    {                        
        int localport = serverSocket.getLocalPort();

        // get local ip address
//        InetAddress inetaddress = serverSocket.getInetAddress();
        InetAddress localip;
        try {
            localip = InetAddress.getLocalHost();
        } catch(UnknownHostException e) {
            log.debug("Can't get local host");
            return false;
        }

        // get ip address in high byte order
        byte[] addrbytes = localip.getAddress();

        // tell server what port we are listening on
        short addrshorts[] = new short[4];

        // problem:  bytes greater than 127 are printed as negative numbers
        for(int i = 0; i <= 3; i++) {
            addrshorts[i] = addrbytes[i];
            if (addrshorts[i] < 0)
                addrshorts[i] += 256;
        }

        outputStream.println("port " + addrshorts[0] + "," + addrshorts[1] +
                             "," + addrshorts[2] + "," + addrshorts[3] + "," +
                             ((localport & 0xff00) >> 8) + "," +
                             (localport & 0x00ff));

        return isPositiveCompleteResponse(getServerReply());
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername;
    }
}
