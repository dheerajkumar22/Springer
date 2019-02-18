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

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='query']")
	private WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//ul[@id='ui-id-1']/li")
	private List<WebElement> allResult;

	@FindBy(how = How.XPATH, using = "//input[@id='search']")
	private WebElement searchButton;

	public void enter_query(String query) {
		searchBox.sendKeys(query);
	}
	
	public void verify_query_result(String queryText, String resultText) {
//		List<WebElement> allResult = new LinkedList<WebElement>();
	    for(WebElement we : allResult){
	    	System.out.println(we.getText());
	    	Assert.assertTrue("Checking seggested results contains "+queryText, we.getText().toLowerCase().contains(resultText));
	    }
	}
	
	public void click_search_button() {
		searchButton.click();
	}

}
