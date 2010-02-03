/*
 * Created on 8 nov. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package fr.capwebct.capdemat.plugins.externalservices.horanet.service;

import java.io.*;

/**
 * This class implements a typed DataSource from
 * 	an InputStream,
 *	a byte array,
 * 	a String,
 *  a File.
 *
 * @author Wouter Cloetens (wcloeten@raleigh.ibm.com)
 */
public class ByteArrayDataSource implements javax.activation.DataSource {
    
    private byte[] data;
    private String type;

    public ByteArrayDataSource(String data, String type) {
        try {
            this.data = data.getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.data = data.getBytes();
        }
        this.type = type;
    }

    public InputStream getInputStream() throws IOException {
        if (data == null)
            throw new IOException("No data.");
        return new ByteArrayInputStream(data);
    }

    public OutputStream getOutputStream() throws IOException {
        throw new IOException("getOutputStream() not supported.");
    }

    public String getContentType() {
        return type;
    }

    public String getName() {
        return "";
    }
}
