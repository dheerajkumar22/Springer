package com.Springer.search.Pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SearchPage {
	
	public SearchPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
		
	@FindBy(how = How.XPATH, using = "//ol[@id='results-list']//h2") 
	 private List<WebElement> searchPageResult;
	
	public void verify_query_result(String queryText, String resultText) {
		List<WebElement> allResult = new LinkedList<WebElement>();
	    
	    for(WebElement we : searchPageResult){
	    	System.out.println(we.getText());
	    	Assert.assertTrue("Checking seggested results contains "+queryText, we.getText().toLowerCase().contains(resultText));
	    }
	}

}
