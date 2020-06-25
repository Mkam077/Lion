package Programme;

import Dao.DaoArticleStock;
import Service.ArticleStockService;

public class lanceurtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DaoArticleStock test = new DaoArticleStock();
		ArticleStockService test1 = new ArticleStockService();
		test.calculQteTot();
		//test1.calculQteTot();

	}

}
