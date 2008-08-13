package fr.cg95.cvq.bo;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

public class TestTicket {

	public TestTicket() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new TestTicket().createTicket(null);
		} catch (Exception e) {
			// RCLCQ Auto-generated catch block
			e.printStackTrace();
		}
	}

	private File createTicket(HttpServletRequest request) throws Exception {
//		File pdf = StartupServlet.getTempContextFile(request.getSession(), "tmp", ".pdf");
		File pdf = new File("test/test.pdf");
		
		double ptscm = 72/2.54;
		
		float width = (float)(7 * ptscm);
		float height = (float)(1.2 * ptscm);
		
		Rectangle pageSize = new Rectangle(width,height);
		Document ticket = new Document(pageSize,0,0,0,0);
		PdfWriter.getInstance(ticket,new FileOutputStream(pdf));
		ticket.open();
		
		Paragraph p = new Paragraph();
		
		Font font = p.font();
		font.setSize(10);
		
		Chunk lastName = new Chunk("DUPONT", font);
		Chunk firstName = new Chunk("Pghjierre", font);
		
		p.add(lastName);
		p.add(Chunk.NEWLINE);
		p.add(firstName);

		ticket.add(p);
		ticket.close();
		return pdf;
	}
}
