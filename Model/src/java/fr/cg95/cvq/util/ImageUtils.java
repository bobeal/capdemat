package fr.cg95.cvq.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageUtils {

    public static String getFormatName(byte[] image) throws IOException {
        return bytesToImageReader(image).getFormatName();
    }

    public static int getWidth(byte[] image) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(image)).getWidth();
    }

    public static int getHeight(byte[] image) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(image)).getHeight();
    }

    private static ImageReader bytesToImageReader(byte[] data) throws IOException {
        ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(data));
        Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
        if (!iter.hasNext())
            throw new IOException();
        ImageReader reader = (ImageReader)iter.next();
        iis.close();
        return reader;
    }

}
