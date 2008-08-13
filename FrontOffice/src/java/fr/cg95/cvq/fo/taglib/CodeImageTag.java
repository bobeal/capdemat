/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */

package fr.cg95.cvq.fo.taglib;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.dispatcher.StartupServlet;

public class CodeImageTag extends BaseTag {

    private String warpFactor;
    private String color;
	private int imageWidth = 0;
	private int imageHeight = 0;

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

			String code = null;
			try {
				code = (String) RequestUtils.lookup(pageContext, name, property, getScope());
			} catch (Exception e) {
			}

			if (code == null)
				code = generateCode();

			String img = getImageFile(code);
			if (img != null) {
				out.println("<img src=\"" + img + "\" alt=\"\" />");

			}
		} catch (Exception ignored) {
            ignored.printStackTrace();
		}
		return EVAL_PAGE;
	}

	private String getImageFile(String code) {
		try {
			File codeBackground = StartupServlet.getAppFile("img/CodeBackground.jpg");
			File codeSource = StartupServlet.getTempContextFile(pageContext.getSession(), "code", "tmp");
			BufferedImage imageBackground = ImageIO.read(codeBackground);

			imageWidth = imageBackground.getWidth();
			imageHeight = imageBackground.getHeight();

			BufferedImage textImage =
				new BufferedImage(imageWidth, imageHeight, imageBackground.getType());
			Graphics2D g2 = textImage.createGraphics();

			// Create and set font
			Font font = g2.getFont();
			Font newFont = new Font(font.getName(), Font.ITALIC, 32);

			FontMetrics metrics = g2.getFontMetrics(newFont);

			g2.drawImage(imageBackground, null, 0, 0);

			g2.setFont(newFont);

			g2.setColor(Color.CYAN);
			float x1 = 0;
			float y1 = 0;
			int ci1 = getMedian() - 28;
			Color c1 = new Color(ci1, ci1, ci1);

			float x2 = imageWidth;
			float y2 = 0;
			int ci2 = getMedian() + 28;
			Color c2 = new Color(ci2, ci2, ci2);

			GradientPaint gradientPaint = new GradientPaint(x1, y1, c1, x2, y2, c2);
			g2.setPaint(gradientPaint);

            int x = 10;
			int y = imageHeight / 2 + metrics.getDescent();
            
			g2.drawString(code, x, y);

			BufferedImage image = warpImage(textImage, getWarp());

			ImageIO.write(image, "jpeg", codeSource);
			g2.dispose();
			textImage = null;
			return StartupServlet.getFileContextName((HttpServletRequest)pageContext.getRequest(), codeSource);

		} catch (IOException ioe) {
            ioe.printStackTrace();
		}
		return null;
	}

    private Color getColor(String color) {
        try {
            int red = Integer.parseInt(color.substring(1, 3), 16);
            int green = Integer.parseInt(color.substring(3, 5), 16);
            int blue = Integer.parseInt(color.substring(5, 7), 16);

            return new Color(red, green, blue);

        } catch (Exception e) {
            return Color.cyan;
        }
    }
    
    private int getMedian() {
        try {
            return Integer.parseInt(color);

        } catch (Exception e) {
            return 166;
        }
    }
    
	private Point2D initWarp(int warp, int w, int h) {
		// initializes the cubic curve
		CubicCurve2D cc =
			new CubicCurve2D.Float(w * .5f, h * .2f, 0, h * .4f, w, h * .6f, w * .5f, h * .8f);

		// creates an iterator to define the boundary of the flattened curve
		PathIterator pi = cc.getPathIterator(null, 0.1);
		int i = 0;
		float[] coords = new float[6];
		// while pi is iterating the curve, adds points to tmp array
		while (!pi.isDone() && (i < warp)) {
			switch (pi.currentSegment(coords)) {
				case PathIterator.SEG_MOVETO :
				case PathIterator.SEG_LINETO :
					}
			i++;
			pi.next();
		}
		return new Point2D.Float(coords[0], coords[1]);
	}

	/*
	 * Scales the image on the fly to fit inside of the destination drawable 
	 * surface.  Crops the image into quarter pieces, based on the x & y
	 * coordinates scales the cropped images.
	 */
	public void drawWarp(Graphics2D g2, Point2D point, Image image, int w, int h) {
		int x = (int) point.getX();
		int y = (int) point.getY();

        if ((x > (imageWidth / 2) - 5) && (x <= (imageWidth / 2)))
            x = (imageWidth / 2) - 5;
            
        if ((x > (imageWidth / 2)) && (x < (imageWidth / 2) + 5))
            x = (imageWidth / 2) + 5;
                
        if ((y > (imageHeight / 2) - 5) && (y <= (imageHeight / 2)))
            y = (imageHeight / 2) - 5;
            
        if ((y > (imageHeight / 2)) && (y < (imageHeight / 2) + 5))
            y = (imageHeight / 2) + 5;
                
		g2.drawImage(image, 0, 0, x, y, 0, 0, imageWidth / 2, imageHeight / 2, null);
		g2.drawImage(image, x, 0, w, y, imageWidth / 2, 0, imageWidth, imageHeight / 2, null);
		g2.drawImage(image, 0, y, x, h, 0, imageHeight / 2, imageWidth / 2, imageHeight, null);
		g2.drawImage(
			image,
			x,
			y,
			w,
			h,
			imageWidth / 2,
			imageHeight / 2,
			imageWidth,
			imageHeight,
			null);
	}

	private BufferedImage warpImage(BufferedImage image, int warp) {
		BufferedImage warpImage = new BufferedImage(imageWidth, imageHeight, image.getType());

		Point2D point = initWarp(warp, imageWidth, imageHeight);

		Graphics2D g2 = warpImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		drawWarp(g2, point, image, imageWidth, imageHeight);

		g2.dispose();

		return warpImage;
	}

    private String generateCode() {

        Integer idGeneratedByClock = new Integer((int) System.currentTimeMillis());

        int id = Integer.parseInt(idGeneratedByClock.toString());
        String hexa = Integer.toString(id, 16);

        // Only take the last 5 characters
        int pos = (hexa.length() > 5) ? hexa.length() - 5 : 0;
        hexa = hexa.substring(pos);

        return "X" + hexa;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWarpFactor() {
        return warpFactor;
    }

    public void setWarpFactor(String warp) {
        this.warpFactor = warp;
    }

    private int getWarp() {
        if (warpFactor != null)
            try {
                return Integer.parseInt(warpFactor);
            } catch (NumberFormatException nfe) {
            }
        
        int warp = new Long((System.currentTimeMillis() / 1000) % 40).intValue() + 10;
        return warp;

    }

}
