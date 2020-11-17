package com.rbnp.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rbnp.GenericLibarary.BaseClass;
import com.rbnp.ObjectRepository.CreatedLeadPageElements;
import com.rbnp.ObjectRepository.HomePageElements;
import com.rbnp.ObjectRepository.LeadInFoPageElements;
import com.rbnp.ObjectRepository.LeadPageElements;

public class CreateLeadTest extends BaseClass {

	@Test
	public void createLead() throws EncryptedDocumentException, IOException
	{
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		LeadPageElements lp = PageFactory.initElements(driver, LeadPageElements.class);
		CreatedLeadPageElements clp = PageFactory.initElements(driver, CreatedLeadPageElements.class);
		LeadInFoPageElements lip = PageFactory.initElements(driver, LeadInFoPageElements.class);
		
		hp.getLeads().click();
		lp.getCreatedLead().click();
		clp.getLastNameTb().sendKeys(data.getDataFromExcel("LeadData", 2, 1));
		clp.getCompanyNameTb().sendKeys(data.getDataFromExcel("LeadData", 2, 2));
		clp.getSaveBtn().click();
		
		String actLeadMsg = lip.getSuccessMsg().getText();
		Assert.assertTrue(actLeadMsg.contains(data.getDataFromExcel("LeadData", 2, 3)));
	}
}
