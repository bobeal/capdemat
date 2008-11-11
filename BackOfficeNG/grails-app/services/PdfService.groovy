import org.xhtmlrenderer.pdf.ITextRenderer

class PdfService {
	
	def byte[] htmlToPdf(data) {
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();

    	ITextRenderer renderer = new ITextRenderer();
    	File file = File.createTempFile("tmp","pdf")
    	file.write(data)
    	renderer.setDocument(file)
    	renderer.layout()
    	renderer.createPDF(baos)
    	return baos.toByteArray()
	}
}