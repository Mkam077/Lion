package Factory;

import Entity.ArticleStock;
import IFactory.IFactory;

public class ArticleStockFactory  implements IFactory<ArticleStock>{

	
	
	
	@Override
	public ArticleStock creer() {
		// TODO Auto-generated method stub
		return new  ArticleStock();
		// il me retourne un articlestockentity a cause des ()
	}

}
