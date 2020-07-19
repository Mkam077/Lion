package ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import Entity.ArticleStock;
import Helper.ExcelHelper;
import Service.ExcelServiceInterface;
import Utils.ResponseMessage;

@Named
@SessionScoped
public class ExcelControllerMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    
	ExcelServiceInterface excelService = (ExcelServiceInterface) context.getBean("excelService");
	
	private Part file;
	
	
	  public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public ResponseEntity<ResponseMessage> uploadFile() {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	    	  excelService.save(file);

	        message = "Uploaded the file successfully: " + file.getName();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getName() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }

	  @GetMapping("/articleStocks")
	  public ResponseEntity<List<ArticleStock>> getAllArticleStocks() {
	    try {
	      List<ArticleStock> articleStocks = excelService.getAllArticleStocks();

	      if (articleStocks.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(articleStocks , HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("attachment/articleStocks.xlsx")
	  public ResponseEntity<Resource> getFiles() {
	    String filename = "articleStocks.xlsx";
	    InputStreamResource file = new InputStreamResource(excelService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
}
