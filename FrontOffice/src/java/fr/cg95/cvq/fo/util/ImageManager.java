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
package fr.cg95.cvq.fo.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

/**
 * @author Laurent MARQUEZ
 */
public class ImageManager implements Constants {
	private static Logger _logger = Logger.getLogger(ImageManager.class);

	private static ImageManager _imageManager = null;

	private HashMap _suffixMap = new HashMap();

	public static ImageManager getInstance() {
		_logger.debug("getInstance()");
		if (_imageManager == null) {
			_imageManager = new ImageManager();
		}
		return _imageManager;
	}

	private ImageManager() {
		_logger.debug("ImageManager()");
		_suffixMap.put(UPLOAD_FILE_JPG_FORMAT, ImageHandler.JPG_FORMAT);
		_suffixMap.put(UPLOAD_FILE_JPEG_FORMAT, ImageHandler.JPG_FORMAT);
		_suffixMap.put(UPLOAD_FILE_BMP_FORMAT, ImageHandler.BMP_FORMAT);
		_suffixMap.put(UPLOAD_FILE_TIFF_FORMAT, ImageHandler.TIFF_FORMAT);
		_suffixMap.put(UPLOAD_FILE_PNG_FORMAT, ImageHandler.PNG_FORMAT);
		_logger.debug("schema file format putted in the map");
	}

	public String createTemporaryImageFile(byte[] pData, String pFileFormat,
			String pAbsolutePath, String pSuffix, String pContextPath)
			throws IOException, Exception {

		_logger.debug("createTemporaryImageFile()");
		
		String path = pAbsolutePath + File.separator + TEMPORARY_DIRECTORY
				+ pSuffix;
		_logger.debug("path:" + path);
		File tempFile = File.createTempFile("image", "tmp", new File(path));
		_logger.debug("temp file created, absolute path: "
				+ tempFile.getAbsolutePath());
		BufferedImage bufferedImage = ImageHandler.readImageFromBytes(pData);

		if (null != bufferedImage) {
			ImageHandler.writeImage(bufferedImage, pFileFormat, tempFile);
			String pathOfBufferedImage = pContextPath + "/"
					+ TEMPORARY_DIRECTORY + pSuffix + "/" + tempFile.getName();
			_logger.debug("pathOfBufferedImage :" + pathOfBufferedImage);
			return pathOfBufferedImage;
		}
		String exceptionMessage = "bufferedImage is null for file format: "
				+ pFileFormat;
		_logger.debug("exception :" + exceptionMessage);
		throw new Exception(exceptionMessage);
	}

	public String findFileFormat(FormFile pFormFile) throws Exception {

		_logger.debug("findFileFormat()");
		//         // get the name of the form file
		String fileName = pFormFile.getFileName();
		_logger.debug("name of the form file:" + fileName);
		//         // get the prefix
		String pattern = "[.]";
		String[] fields = fileName.split(pattern);

		String suffix = fields[1];

		String fileFormat = (String) _suffixMap.get(suffix.toLowerCase());
		if (null != fileFormat) {
			_logger.debug("file format:" + fileFormat);
			return fileFormat;
		}
		String exceptionMessage = "Bad File Format!";
		_logger.debug("exception :" + exceptionMessage);
		throw new Exception(exceptionMessage);

	}

}