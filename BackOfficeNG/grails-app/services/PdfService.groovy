import org.xhtmlrenderer.pdf.ITextRenderer
import fr.cg95.cvq.service.users.ICertificateService

class PdfService {
	
    ICertificateService certificateService

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
    
    def byte[] requestToPdf (request) {
        return certificateService.generate(request)
    }
}
