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

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class ImageHandler {
	private static Logger _logger = Logger.getLogger(ImageHandler.class);

	public static String JPG_FORMAT = "jpg";
	
	public static String BMP_FORMAT = "bmp";

	public static String PNG_FORMAT = "png";

	public static String GIF_FORMAT = "gif";

	public static String TIFF_FORMAT = "tiff";

	/**
	 * Read a BufferedImage from a file. Works for jpg, jpeg, bmp, png, tiff and gif
	 * formats.
	 * 
	 * @param pFile :
	 *            the file to read.
	 * @return the BufferedImage.
	 * @throws IOException
	 */
	public static BufferedImage readImageFromFile(File pFile)
			throws IOException {
		_logger.debug("readImageFromFile()");
		return ImageIO.read(pFile);
	}

	/**
	 * Read a BufferedImage from a byte array.
	 * 
	 * @param pBytes :
	 *            the byte array to read.
	 * @return the BufferedImage.
	 * @throws IOException
	 */
	public static BufferedImage readImageFromBytes(byte[] pBytes)
			throws IOException {
		_logger.debug("readImageFromBytes()");
		return ImageIO.read(new ByteArrayInputStream(pBytes));
	}

	/**
	 * Write a BufferedImage into a file. Works for jpg, jpeg, bmp, png, tiff formats.
	 * Doesn't work for gif format.
	 * 
	 * @param pBufferedImage :
	 *            the image to write.
	 * @param pFormat :
	 *            the format to write.
	 * @param pFile :
	 *            the file to write into.
	 * @throws IOException
	 */
	public static void writeImage(BufferedImage pBufferedImage, String pFormat,
			File pFile) throws IOException {
		_logger.debug("writeImage()");
		ImageIO.write(pBufferedImage, pFormat, pFile);
	}

	/**
	 * Convert a BufferedImage into a byte array. Works for jpg, jpeg, bmp, png, tiff
	 * formats. Doesn't work for gif format.
	 * 
	 * @param pBufferedImage :
	 *            the image to convert.
	 * @param pFormat :
	 *            the format to convert.
	 * @return a byte array.
	 * @throws IOException
	 */
	public static byte[] getBytesForImage(BufferedImage pBufferedImage,
			String pFormat) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		_logger.debug("getBytesForImage()");
		ImageIO.write(pBufferedImage, pFormat, stream);

		return stream.toByteArray();
	}

	/**
	 * @param pBufferedImage :
	 *            the image.
	 * @return the image dimension.
	 */
	public static Dimension getImageSize(BufferedImage pBufferedImage) {
		_logger.debug("getImageSize()");
		Dimension size = new Dimension();

		size.width = pBufferedImage.getWidth();
		size.height = pBufferedImage.getHeight();

		return size;
	}

	/**
	 * Resize a BufferedImage.
	 * 
	 * @param pBufferedImage :
	 *            the imageto resize.
	 * @param pWidth :
	 *            the new width.
	 * @param pHeight :
	 *            the new height.
	 * @return a new BufferedImage with the requested size.
	 */
	public static BufferedImage resizeImage(BufferedImage pBufferedImage,
			double pWidth, double pHeight) {
		_logger.debug("resizeImage()");
		double scaleX = pWidth / (double) pBufferedImage.getWidth();
		double scaleY = pHeight / (double) pBufferedImage.getHeight();

		AffineTransform transform = AffineTransform.getScaleInstance(scaleX,
				scaleY);
		AffineTransformOp op = new AffineTransformOp(transform,
				AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		return op.filter(pBufferedImage, null);
	}

	/**
	 * @param pFile
	 *            file to write into
	 * @param pFormat
	 *            file extension
	 * @param pBytes
	 *            byte array to write
	 * @throws IOException
	 */
	public static Dimension createFileFromBytes(File pFile, String pFormat,
			byte[] pBytes) throws IOException {
		_logger.debug("createFileFromBytes()");
		// build image
		BufferedImage image = ImageHandler.readImageFromBytes(pBytes);

		// build file
		ImageHandler.writeImage(image, pFormat, pFile);

		return getImageSize(image);
	}

	/**
	 * Create an image file from a byte array with the specified width and
	 * height.
	 * 
	 * @param pFile :
	 *            file to write into
	 * @param pFormat
	 *            file extension
	 * @param pBytes :
	 *            byte array to write
	 * @param pWidth
	 *            image width.
	 * @param pHeight
	 *            image height.
	 * @return picture file dimension.
	 * @throws IOException
	 */
	public static void createFileFromBytesWithSize(File pFile, String pFormat,
			byte[] pBytes, int pWidth, int pHeight) throws IOException {
		_logger.debug("createFileFromBytesWithSize()");
		// build image
		BufferedImage image = ImageHandler.readImageFromBytes(pBytes);

		// resize image
		image = ImageHandler.resizeImage(image, pWidth, pHeight);

		// build file
		ImageHandler.writeImage(image, pFormat, pFile);
	}

	/**
	 * Create an image file from a byte array. Check width and height of the
	 * image. Resize to pMaxWidth and pMaxHeight if necessary.
	 * 
	 * @param pFile :
	 *            file to write into.
	 * @param pFormat
	 *            file extension
	 * @param pBytes :
	 *            byte array to write.
	 * @param pMaxWidth
	 *            maximum width.
	 * @param pMaxHeight
	 *            maximum height.
	 * @return picture file dimension.
	 * @throws IOException
	 */
	public static Dimension createFileFromBytesCheckSize(File pFile,
			String pFormat, byte[] pBytes, int pMaxWidth, int pMaxHeight)
			throws IOException {
		_logger.debug("createFileFromBytesCheckSize()");
		// build image
		BufferedImage image = ImageHandler.readImageFromBytes(pBytes);

		// test dimension and resize if necessary
		boolean tooWidth = false;
		boolean tooHeight = false;

		int width = image.getWidth();
		int height = image.getHeight();

		if (image.getWidth() > pMaxWidth) {
			tooWidth = true;
			width = pMaxWidth;
		}

		if (image.getHeight() > pMaxHeight) {
			tooWidth = true;
			height = pMaxHeight;
		}

		if (tooWidth || tooHeight) {
			image = ImageHandler.resizeImage(image, width, height);
		}

		// build file
		ImageHandler.writeImage(image, pFormat, pFile);

		return new Dimension(width, height);
	}

}