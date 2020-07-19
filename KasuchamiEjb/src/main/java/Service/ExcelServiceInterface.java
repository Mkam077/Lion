package Service;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

import Entity.ArticleStock;

public interface ExcelServiceInterface {
	
	
	 void save(Part file);
	 List<ArticleStock> getAllArticleStocks();
	 
	 ByteArrayInputStream load();

}
