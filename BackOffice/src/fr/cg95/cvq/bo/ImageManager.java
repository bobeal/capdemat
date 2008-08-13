/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cg95.cvq.bo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.struts.upload.FormFile;


/**
 * BusinessManager
 */
public class ImageManager {

	// image size
	public static final Integer UPLOAD_FILE_SIZE = new Integer(1048576);

	public static String UPLOAD_FILE_JPG_FORMAT = "jpg";
    
	public static String UPLOAD_FILE_JPEG_FORMAT = "jpeg";

	public static String UPLOAD_FILE_BMP_FORMAT = "bmp";

	public static String UPLOAD_FILE_PNG_FORMAT = "png";

	public static String UPLOAD_FILE_GIF_FORMAT = "gif";

	public static String UPLOAD_FILE_TIFF_FORMAT = "tiff";
    
    private static ImageManager _imageManager = null;

    private static HashMap _suffixMap = new HashMap();

    public ImageManager() {
        super();
        if (_imageManager == null) {
            _imageManager = this;

            _suffixMap.put(UPLOAD_FILE_JPG_FORMAT, ImageHandler.JPG_FORMAT);
            _suffixMap.put(UPLOAD_FILE_JPEG_FORMAT, ImageHandler.JPG_FORMAT);
            _suffixMap.put(UPLOAD_FILE_BMP_FORMAT, ImageHandler.BMP_FORMAT);
            _suffixMap.put(UPLOAD_FILE_TIFF_FORMAT, ImageHandler.TIFF_FORMAT);
            _suffixMap.put(UPLOAD_FILE_PNG_FORMAT, ImageHandler.PNG_FORMAT);
        }
    }


    public static String createTemporaryImageFile(byte[] pData, String pFileFormat)
            throws IOException, Exception {
        File tempFile = File.createTempFile("image", "tmp");

        BufferedImage bufferedImage = ImageHandler.readImageFromBytes(pData);

        ImageHandler.writeImage(bufferedImage, pFileFormat,
                tempFile);

        return tempFile.getAbsolutePath();
    }

    public static String findFileFormat(FormFile pFormFile) throws Exception {

        // get the name of the form file
        String fileName = pFormFile.getFileName();

        // get the prefix
        String pattern = "[.]";
        String[] fields = fileName.split(pattern);

        String suffix = fields[1];

        String fileFormat = (String) _suffixMap.get(suffix);
        if (null != fileFormat) { return fileFormat; }

        throw new Exception("Bad File Format!");
    }

}