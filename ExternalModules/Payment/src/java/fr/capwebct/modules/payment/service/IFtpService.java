package fr.capwebct.modules.payment.service;

public interface IFtpService {

    boolean uploadData(byte[] data, String filename);
    
    byte[] getData(String filename);
    
    void renameFile(String origFilename, String destFilename);
}
