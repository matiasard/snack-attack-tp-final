/**
 * 
 */
package ar.edu.unju.fi.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import ar.edu.unju.fi.entity.Product;
import java.util.Base64;

/**
 * @author Enzo Sandoval
 *
 */
public class ProductPDFExporter {

	private List<Product> listProducts;

	public ProductPDFExporter(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Code", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Image", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Category", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) throws BadElementException, IOException {
		for (Product product : listProducts) {
			table.addCell(String.valueOf(product.getId()));
			table.addCell(product.getName());
			if (product.getImage() != null) {
				byte[] decodedBytes = Base64.getDecoder().decode(product.getImage());
				Image body = Image.getInstance(decodedBytes);
				table.addCell(body);
			} else {
				table.addCell("");
			}
			table.addCell(String.valueOf(" $ " + product.getMSRP()));
			table.addCell(product.getProductLine().getProductLine());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Products", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 2.0f, 2.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}

}
