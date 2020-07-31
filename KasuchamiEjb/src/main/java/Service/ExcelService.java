package Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.DaoArticleStock;
import Entity.ArticleStock;
import Helper.ExcelHelper;

@Service
public class ExcelService implements ExcelServiceInterface {
	
	@Autowired
	 private  DaoArticleStock daoArticleStock = new DaoArticleStock();

	
	 @Transactional
	  public void save(Part file) {
	    try {
	      List<ArticleStock> articleStocks = ExcelHelper.excelToArticleStocks(file.getInputStream());
	      daoArticleStock.importer(articleStocks);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<ArticleStock> getAllArticleStocks() {
	    return daoArticleStock.exporter();
	  }

	
	
	public byte[] load() {
	    List<ArticleStock> articleStocks = daoArticleStock.exporter();

	    byte[] in = ExcelHelper.articleStocksToExcel(articleStocks);
	    return in;
	  }

}
