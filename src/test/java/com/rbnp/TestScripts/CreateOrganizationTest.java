package com.rbnp.TestScripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rbnp.GenericLibarary.BaseClass;
import com.rbnp.ObjectRepository.CreateOrganizationPageElements;
import com.rbnp.ObjectRepository.HomePageElements;
import com.rbnp.ObjectRepository.OrganizationInfoPageElements;
import com.rbnp.ObjectRepository.OrganizationPageElements;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganozation() throws EncryptedDocumentException, IOException
	{
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		OrganizationPageElements op = PageFactory.initElements(driver, OrganizationPageElements.class);
		CreateOrganizationPageElements cop = PageFactory.initElements(driver, CreateOrganizationPageElements.class);
		OrganizationInfoPageElements oip = PageFactory.initElements(driver, OrganizationInfoPageElements.class);
		
		hp.getOrganizations().click();
		op.getCreateOrganization().click();
		String orgName = data.getDataFromExcel("CreateOrganization", 2, 1);
		
		Random r = new Random();
		int num = r.nextInt(9999);
		orgName = orgName+num;
		cop.getOrganizationNameTb().sendKeys(orgName);
		cop.getSaveBtn().click();
		
		String successMsg = oip.getSuccessMsg().getText();
		Assert.assertTrue(successMsg.contains(data.getDataFromExcel("CreateOrganization", 2, 2)));
		
	}
}
