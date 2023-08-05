package Helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Entity.ArticleStock;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = {"articleDesignation","articleUtilisationLibre","articleControleQualite",
			"articleBloque","articleEnRetour","articleEnTransit","ConsommationJournaliére "};
	static String SHEET = "Feuil1";

	public static boolean hasExcelFormat(Part file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<ArticleStock> excelToArticleStocks(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<ArticleStock> articleStocks = new ArrayList<ArticleStock>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				ArticleStock articleStock = new ArticleStock();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {


					case 0:

						articleStock.setArticleDesignation(currentCell.getStringCellValue());
						break;

					case 1:

						articleStock.setArticleUtilisationLibre((int) currentCell.getNumericCellValue());
						break;

					case 2:

						articleStock.setArticleControleQualite((int) currentCell.getNumericCellValue());
						break;
					case 3:

						articleStock.setArticleStockNonLibre((int) currentCell.getNumericCellValue());
						break;

					case 4:

						articleStock.setArticleBloque((int) currentCell.getNumericCellValue());
						break;
					case 5:

						articleStock.setArticleEnRetour((int) currentCell.getNumericCellValue());
						break;	

					case 6:

						articleStock.setArticleEnTransit((int) currentCell.getNumericCellValue());
						break;

					default:
						break;

					case 7:
						articleStock.setConsommationJournaliere((int) currentCell.getNumericCellValue());
						break;
					}

					cellIdx++;
				}

				articleStocks.add(articleStock);
			}

			workbook.close();

			return articleStocks;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}

	}
	public static byte[] articleStocksToExcel(List<ArticleStock> articleStocks) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (ArticleStock articleStock : articleStocks) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(articleStock.getArticleDesignation());
				row.createCell(1).setCellValue(articleStock.getArticleUtilisationLibre());
				row.createCell(2).setCellValue(articleStock.getArticleControleQualite());
				row.createCell(3).setCellValue(articleStock.getArticleStockNonLibre());
				row.createCell(4).setCellValue(articleStock.getArticleBloque());
				row.createCell(5).setCellValue(articleStock.getArticleEnRetour());
				row.createCell(6).setCellValue(articleStock.getArticleEnTransit());
				row.createCell(7).setCellValue(articleStock.getConsommationJournaliere());

			}

			workbook.write(out);
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}
}