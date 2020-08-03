package Service;

import java.util.List;

import javax.servlet.http.Part;

import Entity.ArticleStock;

public interface ExcelServiceInterface {


	void save(Part file);
	List<ArticleStock> getAllArticleStocks();

	byte[] load();

}
