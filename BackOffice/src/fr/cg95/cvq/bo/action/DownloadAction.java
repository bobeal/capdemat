/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and René le Clercq 
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

package fr.cg95.cvq.bo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.dispatcher.StartupServlet;

/**
 * @author René le CLERCQ
 */
public class DownloadAction extends Action {

	public DownloadAction() {
		super();
	}
////	html file with links to either display or download the .pdf file.
// <a href="pdf.php?pdfile=File-name-here">Download File</a><br>
// <a href="data/File-name-here.pdf">View File</a><br>
//
// /* The following code assumes that the files are located in a folder
// called "data" and all files are .pdf. I havent tested it with files that
// have spaces in the name, so i dont know if it works. But it does work
// fine with files using _ and - in the names. */
//
////	Get the file size of the selected file (for convenience so you know how
////	long you have to wait...
// $len = filesize('data/'.$pdfile.'.pdf');
//
////	Declare File Type...
// header('Content-type: application/pdf');
//
////	Name the file. Cound just call it download.pdf or other using this.
// header('Content-Disposition: attachment; filename="'.$pdfile.'.pdf"');
//
////	declare Files Size here (for the sake pf peoples sanity, please add this
// header('Content-Length: '.$len);
//
////	Path to original file to be read and sent to browser.
// readfile('data/'.$pdfile.'.pdf');
//
//
// /* You could of course modify this to work with other filetypes, or just remove the filetype totally, its up to you.
// Please make sure you leave in the file size bit so people dont go insane
// waiting for a file of undetermined time, tearing their hair out...
// */
//

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
			
		String fileName = request.getParameter("file");
		File download = StartupServlet.getAppFile(fileName);
		int fileSize = (int)download.length();
		
        response.reset();
		response.setContentType("application/xml");
		response.setHeader("Content-Disposition", "attachment; filename=" + download.getName());
		response.setContentLength(fileSize);
		
		byte[] buffer = new byte[fileSize];
		
		InputStream is = new FileInputStream(download);
		is.read(buffer);

        try {
            response.getOutputStream().write(buffer);
        } catch (Exception e) {
            e.getMessage();
        }
		return null;
	}

}
