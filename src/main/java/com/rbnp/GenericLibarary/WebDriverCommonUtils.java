package com.rbnp.GenericLibarary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverCommonUtils {
	
	String mainBrowserSessionId;

	public void waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectItemsFromList(WebElement element, String itemToBeSelected)
	{
		Select s = new Select(element);
		s.selectByVisibleText(itemToBeSelected);
	}
	
	public void checkmultipleList(WebElement element)
	{
		Select s = new Select(element);
		s.isMultiple();
	}
	
	public void keepMouseOnElement(WebElement element)
	{
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	
	public void moveObjectAtRequiredPlace(WebElement source, WebElement target)
	{
		Actions act = new Actions(BaseClass.driver);
				act.dragAndDrop(source, target).perform();
	}
	
	public void acceptAlert()
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	
	public void validateAlertMsg(String expectedAlertMsg)
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		
		String actualAlertMsg = alt.getText();
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);
		System.out.println("Alert validation Pass......");
	}
	
	public void rejectAlert()
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void switchToNewWindow()
	{
		mainBrowserSessionId=BaseClass.driver.getWindowHandle();
		Set<String> allid = BaseClass.driver.getWindowHandles();
		
		for(String Id : allid)
		{
			if(!Id.equals(mainBrowserSessionId))
			{
				BaseClass.driver.switchTo().window(Id);
			}
		}
	}
	
	public void switchToMainWindow()
	{
		BaseClass.driver.switchTo().window(mainBrowserSessionId);
	}
	
	public void switchToRequiredFrame(WebElement element)
	{
		BaseClass.driver.switchTo().frame(element);
	}
	
	public void switchToDefaultScreen()
	{
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void fileUploadToApplication(String filePath) throws AWTException
	{
		StringSelection path = new StringSelection(filePath);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Clipboard clp = tool.getSystemClipboard();
		clp.setContents(path, null);
		
		//Paste the path
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		// Click on Enter
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
