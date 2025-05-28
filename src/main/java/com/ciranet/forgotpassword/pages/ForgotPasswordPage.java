package com.ciranet.forgotpassword.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//dx-button[@aria-label='Forgot Password']//div[@class='dx-button-content']")
	WebElement buttonForgotPassword;
	
	@FindBy(xpath = "//div[@class='dx-button-content'][contains(.,'Back to Login')]")
	WebElement backToLoginButton;
	
	public boolean navigate() {
	    try {
	        LoggerManager.info("============  Verifying if the Forgot Password button is enabled  ============");
	        
	        if (!isElementEnabled(buttonForgotPassword)) {
	            LoggerManager.warn("Forgot Password button is not enabled.");
	            return false;
	        }
	        
	        LoggerManager.info("Forgot Password button is enabled. Clicking on the button.");
	        waitForElementToBeClickable(buttonForgotPassword);
	        clickElement(buttonForgotPassword);
	        
	        String forgotPasswordPageURL = driver.getCurrentUrl();
	        LoggerManager.info("Current URL after clicking Forgot Password: " + forgotPasswordPageURL);
	        
	        waitForUrlToBe(driver, forgotPasswordPageURL);
	        waitForElementToBeVisible(backToLoginButton);
	        
	        LoggerManager.info("Successfully navigated to the Forgot Password page.");
	        
	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("An error occurred while verifying the Forgot Password functionality: " + e.getMessage() +  e);
	        return false; 
	    }
	}
	
	public boolean navigateBackToLoginPage() {
	    try {
	        LoggerManager.info("============  Verifying if the Back To Login button is enabled  ============");
	        
	        if (!isElementEnabled(backToLoginButton)) {
	            LoggerManager.warn("Back To Login button is not enabled.");
	            return false;
	        }
	        
	        LoggerManager.info("Back To Login button is enabled. Clicking on the button.");
	        waitForElementToBeClickable(backToLoginButton);
	        clickElement(backToLoginButton);
	        
	        String loginPageURL = driver.getCurrentUrl();
	        LoggerManager.info("Current URL after clicking Forgot Password: " + loginPageURL);
	        
	        waitForUrlToBe(driver, loginPageURL);
	        waitForElementToBeVisible(buttonForgotPassword);
	        
	        LoggerManager.info("Successfully navigated to the Login page.");
	        
	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("An error occurred while verifying the Back To Login Page functionality: " + e.getMessage() +  e);
	        return false; 
	    }
	}
	
	


}
