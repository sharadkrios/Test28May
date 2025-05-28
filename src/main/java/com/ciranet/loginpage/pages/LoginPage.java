package com.ciranet.loginpage.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.EnvironmentConfig;
import com.ciranet.utilities.LoggerManager;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='login-portal-header']")
	private WebElement lblManagementBoardPortal;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement txtUsername;

	@FindBy(xpath = "//input[contains(@type,'password')]")
	private WebElement txtPassword;

	@FindBy(xpath = "//dx-button[@aria-label='Log in']//div[@class='dx-button-content']")
	private WebElement btnSignIn;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement msgInvalidCredentials;

	@FindBy(xpath = "//div[@class='dx-overlay dx-widget dx-visibility-change-handler dx-toast']")
	private WebElement msgTxtLoginError;

	@FindBy(xpath = "//i[contains(@class,'dx-icon fas fa-eye')]")
	private WebElement showEyeIconPassword;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-eye-slash']")
	private WebElement hideEyeIconPassword;

	@FindBy(xpath = "(//input[@role='textbox'])[2]")
	private WebElement getPassword;

	@FindBy(xpath = "//dx-button[@aria-label='Forgot Password']//div[@class='dx-button-content']")
	private WebElement btnForgotPassword;

	@FindBy(xpath = "//a[@class='choose-portal-hyperlink']")
	private WebElement linkChooseDiffPortal;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement txtUserNameOnFP;

	@FindBy(xpath = "//div[@id='rc-anchor-container']")
	private WebElement captchaContainer;

	@FindBy(xpath = "//div[@class='reset-button-content']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//dx-button[@aria-label='Back to Login']//div[@class='dx-button-content']")
	private WebElement btnBackToLogin;

	// This method is used to verify Visibility of Login Page Components
	public boolean visibilityOfLoginPageComponents() {
		try {
	        // Wait for the username field to be visible
	        waitForElementToBeVisible(txtUsername);
	        LoggerManager.info("============  Verifying Visibility Of Login Page Components ============");

	        // Check visibility of all login page components
	        boolean allComponentsVisible = lblManagementBoardPortal.isDisplayed() &&
	                                       txtUsername.isDisplayed() &&
	                                       txtPassword.isDisplayed() &&
	                                       btnSignIn.isDisplayed() &&
	                                       btnForgotPassword.isDisplayed() &&
	                                       linkChooseDiffPortal.isDisplayed();

	        // Log the result of the visibility check
	        if (allComponentsVisible) {
	            LoggerManager.info("============  Login Page verified ============");
	            return true;
	        } else {
	            LoggerManager.info("============  Login Page verification failed ============");
	            return false;
	        }
	    } catch (NoSuchElementException e) {
	        // Handle specific case where an element is not found
	        LoggerManager.error("+++++++++ Element not found during visibility check +++++++++ " + e.getMessage());
	        return false;
	    } catch (StaleElementReferenceException e) {
	        // Handle case where the element is not attached to the DOM
	        LoggerManager.error("+++++++++ Stale element reference during visibility check +++++++++ " + e.getMessage());
	        return false;
	    } catch (Exception e) {
	        // Catch any other exceptions and log them
	        LoggerManager.error("+++++++++ Unexpected error during visibility check +++++++++ " + e.getMessage());
	        return false;
	    }
	}


	// This method check the Valid userName and Valid password
	public boolean verifyLogin(String userName, String password) {
		LoggerManager.info("======== into verifyLogin() ========");
		try {
			enterText(txtUsername, userName);
			LoggerManager.info("======== Username: " + userName + " ========");

			enterText(txtPassword, password);
			LoggerManager.info("======== Password: " + password + " ========");
			
			clickElement(btnSignIn);
			
			return waitForLoginSuccess();

		} catch (Exception e) {
			LoggerManager.error("+++++++++ Exception in verifyLogin() +++++++++ " + e.getMessage());
			throw e;
		}
	}

	// This method is used - KeyPress event after Password is entered
	public boolean verifyLoginWithEnterKeyPress(String userName, String password) {
		LoggerManager.info("======== into verifyLoginEnterKeyPress() ========");
		try {
			enterText(txtUsername, userName);
			LoggerManager.info("======== Username: " + userName + " ========");

			enterText(txtPassword, password);
			LoggerManager.info("======== Password: " + password + " ========");

			txtPassword.sendKeys(Keys.ENTER);

			return waitForLoginSuccess();

		} catch (Exception e) {
			LoggerManager.error("+++++++++ Exception in verifyLoginEnterKeyPress() +++++++++ " + e.getMessage());
			throw e;
		}
	}

	// Method is used for checking Browser's Back
	public boolean clickBrowserBack(String userName, String password) {
	    LoggerManager.info("======== into clickBrowserBackTest() ========");
	    boolean isLoginSuccessful = false; // Variable to track login status

	    try {
	        // Enter username and log the action
	        enterText(txtUsername, userName);
	        LoggerManager.info("======== Username: " + userName + " ========");

	        // Enter password and log the action
	        enterText(txtPassword, password);
	        LoggerManager.info("======== Password: " + password + " ========");

	        // Click the sign-in button
	        clickElement(btnSignIn);
	        
	        // Wait for the loading indicator to become invisible
	        waitForInvisibility(driver.findElement(By.xpath("//*[contains(@class, 'dx-loadindicator-icon')]")));

	        // Check if the login menu icon is displayed
	        if (driver.findElement(By.xpath("//i[@class='dx-icon dx-icon-menu']")).isDisplayed()) {
	            LoggerManager.info("======== Login Success ========");
	            driver.navigate().back(); // Navigate back if login is successful
	            LoggerManager.info("======== End clickBrowserBackTest() ========");
	            isLoginSuccessful = true; // Set login status to true
	        } else {
	            LoggerManager.debug("======== Login Unsuccessful ========");
	        }

	    } catch (NoSuchElementException e) {
	        // Handle case where an expected element is not found
	        LoggerManager.error("+++++++++ Expected element not found +++++++++ " + e.getMessage());
	    } catch (TimeoutException e) {
	        // Handle timeout exceptions
	        LoggerManager.error("+++++++++ Operation timed out +++++++++ " + e.getMessage());
	    } catch (Exception e) {
	        // Handle any other unexpected exceptions
	        LoggerManager.error("+++++++++ Exception in clickBrowserBackTest() +++++++++ " + e.getMessage());
	    }
	    
	    return isLoginSuccessful; // Return the login status
	}

// VerifyLogin and VerifyEnterKey uses this code
	private boolean waitForLoginSuccess() {
	    try {
	        // Wait for the loading indicator to become invisible
	    	waitForInvisibility(driver.findElement(By.xpath("//*[contains(@class, 'dx-loadindicator-icon')]")));

	        // Check if the login menu is displayed
	        if (driver.findElement(By.xpath("//i[@class='dx-icon dx-icon-menu']")).isDisplayed()) {
	            LoggerManager.info("======== Login Success ========");
	            LoggerManager.info("======== End of waitForLoginSuccess() ========");
	            return true;
	        } else {
	            LoggerManager.debug("======== Login Unsuccessful ========");
	            return false;
	        }
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Login menu element not found +++++++++ " + e.getMessage());
	        return false;
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected error in waitForLoginSuccess() +++++++++ " + e.getMessage());
	        return false;
	    }
	}
	
	// This method retrieves the border color of a WebElement using JavaScript
	public String getUsernameBorderColor() {
	    String borderColor = null; // Variable to store the border color

	    try {
	        // Click the sign-in button
	        clickElement(btnSignIn);

	        // JavaScript to get the border color of the username input field
	        String script = "return window.getComputedStyle(arguments[0]).getPropertyValue('border-color');";

	        // Execute the script and retrieve the border color
	        borderColor = (String) ((JavascriptExecutor) driver).executeScript(script,
	                driver.findElement(By.xpath("//input[@type='text']")));
	        
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Element not found for getting border color +++++++++ " + e.getMessage());
	    } catch (WebDriverException e) {
	        LoggerManager.error("+++++++++ WebDriver Exception occurred while executing JavaScript +++++++++ " + e.getMessage());
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected exception in getUsernameBorderColor() +++++++++ " + e.getMessage());
	    }

	    return borderColor; // Return the border color or null if an exception occurred
	}

	// Method checks invalid Login
	public boolean invalidLogin(String username, String password) {
	    LoggerManager.info("======== Into invalidLogin() ========");
	    boolean isLoginFailed = false; // Variable to track the login failure status

	    try {
	        // Enter username and log the action
	        enterText(txtUsername, username);
	        LoggerManager.info("======== Username: " + username + " ========");

	        // Enter password and log the action
	        enterText(txtPassword, password);
	        LoggerManager.info("======== Password: " + password + " ========");

	        // Check if the sign-in button is enabled and click it
	        if (btnSignIn.isEnabled()) {
	            clickElement(btnSignIn);
	        } else {
	            LoggerManager.debug("======== Button is disabled ========");
	            return false; // Return false if the button is disabled
	        }

	    } catch (NoSuchElementException e) {
	        // Handle case where an expected element is not found
	        LoggerManager.error("+++++++++ Element not found in invalidLogin() +++++++++ " + e.getMessage());
	        return false; // Return false if elements are not found

	    } catch (StaleElementReferenceException e) {
	        // Handle case where an element is stale
	        LoggerManager.error("+++++++++ Stale element reference in invalidLogin() +++++++++ " + e.getMessage());
	        return false; // Return false if a stale element reference occurs

	    } catch (Exception e) {
	        // Handle any other unexpected exceptions
	        LoggerManager.error("+++++++++ Exception in invalidLogin() +++++++++ " + e.getMessage());
	        return false; // Return false for unexpected exceptions
	    }

	    // Check if the login was unsuccessful by verifying the URL and message
	    try {
	        if (!driver.getCurrentUrl().endsWith("/home") && msgInvalidCredentials.isDisplayed()) {
	            LoggerManager.info("======== invalidLogin() Fail ========");
	            isLoginFailed = true; // Mark login as failed
	        } else {
	            LoggerManager.info("======== invalidLogin() Pass ========");
	        }

	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Invalid credentials message not found in invalidLogin() +++++++++ " + e.getMessage());
	        isLoginFailed = true; // Mark login as failed if the message element is not found

	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected exception in invalidLogin() after button click +++++++++ " + e.getMessage());
	        isLoginFailed = true; // Mark login as failed for any unexpected exceptions
	    }

	    return !isLoginFailed; // Return the inverse of isLoginFailed
	}

	// Method checks Visibility of Components of Forgot password page
	public boolean visibilityOfForgotPasswordPageComponents() {
	    LoggerManager.info("============ Into visibilityOfForgotPasswordPageComponents() ============");
	    
	    try {
	        // Click on the "Forgot Password" button
	        clickElement(btnForgotPassword);
	        LoggerManager.info("Clicked on Forgot Password button.");

	        // Wait for the username field to be visible
	        waitForElementToBeVisible(txtUserNameOnFP);

	        LoggerManager.info("============ Verifying Visibility Of Forgot Password Page Components ============");

	        // Check visibility of the components
	        boolean allComponentsVisible = txtUserNameOnFP.isDisplayed() &&
	                                       // captchaContainer.isDisplayed() && // Uncomment if needed
	                                       btnSubmit.isDisplayed() &&
	                                       btnBackToLogin.isDisplayed();

	        // Log the result of visibility check
	        if (allComponentsVisible) {
	            LoggerManager.info("============ Forgot Password Page verified ============");
	            return true;
	        } else {
	            LoggerManager.info("============ Forgot Password Page verification failed ============");
	            return false;
	        }
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Element not found in visibilityOfForgotPasswordPageComponents() +++++++++ " + e.getMessage());
	        return false; // Return false if any expected element is not found
	    } catch (TimeoutException e) {
	        LoggerManager.error("+++++++++ Timeout while waiting for an element in visibilityOfForgotPasswordPageComponents() +++++++++ " + e.getMessage());
	        return false; // Return false if waiting for an element times out
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected exception in visibilityOfForgotPasswordPageComponents() +++++++++ " + e.getMessage());
	        return false; // Return false for any unexpected exceptions
	    }
	}


	public boolean verifyShowPassword(String username, String password) {
	    LoggerManager.info("======== View Password() ========");
	    
	    try {
	        // Enter the username
	        enterText(txtUsername, username);
	        LoggerManager.info("======== Username: " + username + " ========");

	        // Enter the password
	        enterText(txtPassword, password);
	        LoggerManager.info("======== Password: " + password + " ========");

	        // Click on the show password icon
	        clickElement(showEyeIconPassword);
	        LoggerManager.info("Clicked on show password icon.");

	        // Check if the password field is displayed
	        if (isElementDisplayed(getPassword)) {
	            clickElement(hideEyeIconPassword); // Click to hide the password
	            LoggerManager.info("Password is visible and now hidden.");
	            return true; // Return true if the password is shown successfully
	        } else {
	            LoggerManager.debug("======== Password is not displayed. ========");
	            return false; // Return false if the password is not displayed
	        }
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Element not found in verifyShowPassword() +++++++++ " + e.getMessage());
	        return false; // Return false if an expected element is not found
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected exception in verifyShowPassword() +++++++++ " + e.getMessage());
	        return false; // Return false for any unexpected exceptions
	    }
	}
	
	public String verifyDifferentPortalLink() {
	    LoggerManager.info("======== Verify Different Link() ========");

	    try {
	        // Check if the different portal link is displayed
	        if (isElementDisplayed(linkChooseDiffPortal)) {
	            LoggerManager.info("Link is displayed, clicking on it.");
	            clickElement(linkChooseDiffPortal); // Click on the link to choose a different portal
	        } else {
	            LoggerManager.debug("======== Link is not displayed ========");
	        }
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Link element not found in verifyDifferentPortalLink() +++++++++ " + e.getMessage());
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected exception in verifyDifferentPortalLink() +++++++++ " + e.getMessage());
	    }

	    // Return the current page URL
	    String currentPageURL = getCurrentPageURL();
	    LoggerManager.info("Current Page URL: " + currentPageURL);
	    return currentPageURL;
	}

	public String verifyForgotPasswordPage() {
	    LoggerManager.info("======== Verify Forgot Password Link() ========");
	    
	    try {
	        // Check if the Forgot Password button is displayed
	        if (isElementDisplayed(btnForgotPassword)) {
	            LoggerManager.info("Forgot Password button is displayed, clicking it.");
	            clickElement(btnForgotPassword); // Click the Forgot Password button
	            waitForElementToBeVisible(btnBackToLogin); // Wait for the Back to Login button to be visible
	            LoggerManager.info("Successfully navigated to Forgot Password page.");
	        } else {
	            LoggerManager.debug("======== Forgot Password Link is not displayed ========");
	        }
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Forgot Password button element not found in verifyForgotPasswordPage() +++++++++ " + e.getMessage());
	    } catch (TimeoutException e) {
	        LoggerManager.error("+++++++++ Timeout while waiting for elements in verifyForgotPasswordPage() +++++++++ " + e.getMessage());
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Unexpected exception in verifyForgotPasswordPage() +++++++++ " + e.getMessage());
	    }

	    // Return the current page URL
	    String currentPageURL = getCurrentPageURL();
	    LoggerManager.info("Current Page URL: " + currentPageURL);
	    return currentPageURL;
	}

	// Method checks the Simultaneous login on Same browser
	public boolean verifySimultaneousLoginOnSameBrowser(String userName, String password) {
	    LoggerManager.info("======== into verifySimultaneousLoginOnSameBrowser() ========");

	    try {
	        // Enter the username
	        enterText(txtUsername, userName);
	        LoggerManager.info("======== Username: " + userName + " ========");

	        // Enter the password
	        enterText(txtPassword, password);
	        LoggerManager.info("======== Password: " + password + " ========");

	        // Click the Sign In button
	        clickElement(btnSignIn);

	        // Wait for the loading indicator to become invisible
	        waitForInvisibility(driver.findElement(By.xpath("dx-loadindicator-icon")));
	    } catch (NoSuchElementException e) {
	        LoggerManager.error("+++++++++ Element not found in verifySimultaneousLoginOnSameBrowser() +++++++++ " + e.getMessage());
	        return false; // Return false if any element is not found
	    } catch (TimeoutException e) {
	        LoggerManager.error("+++++++++ Timeout while waiting for elements in verifySimultaneousLoginOnSameBrowser() +++++++++ " + e.getMessage());
	        return false; // Return false if there's a timeout
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Exception in verifySimultaneousLoginOnSameBrowser() +++++++++ " + e.getMessage());
	        return false; // Catch any other exceptions
	    }

	    // Check if the current URL ends with "home" to determine login success
	    if (driver.getCurrentUrl().endsWith("home")) {
	        LoggerManager.info("======== Login Success ========");
	        LoggerManager.info("======== End verifySimultaneousLoginOnSameBrowser() ========");
	        return true; // Login was successful
	    } else {
	        LoggerManager.debug("======== Login Unsuccessful ========");
	        return false; // Login was unsuccessful
	    }
	}

	// Method is used to check the application of Different Browsers
	public boolean verifyLoginDiffUsersOnDifferentBrowsers(String userName, String password) {
	    LoggerManager.info("======== into verifyLoginDiffUsersOnDifferentBrowsers() ========");

	    // First login attempt using the existing driver
	    try {
	        enterText(txtUsername, userName);
	        LoggerManager.info("======== Username: " + userName + " ========");

	        enterText(txtPassword, password);
	        LoggerManager.info("======== Password: " + password + " ========");

	        clickElement(btnSignIn);
	        
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Exception in verifyLoginDiffUsersOnDifferentBrowsers() +++++++++ " + e.getMessage());
	        return false; // Return false if any exception occurs
	    }

	    // Initialize a new FirefoxDriver for a different browser session
	    FirefoxDriver ffDriver = new FirefoxDriver();
	    String applicationURL = EnvironmentConfig.environmentSetup().get("APPLICATIONURL");

	    try {
	        // Navigate to the application URL
	        ffDriver.get(applicationURL);
	        ffDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	        LoggerManager.debug("------- Page load timeout is set to: 40");

	        ffDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        LoggerManager.debug("------- Implicit Wait time is set to: 20");

	        // Enter login credentials for the different browser
	        enterText(txtUsername, userName);
	        enterText(txtPassword, password);
	        clickElement(btnSignIn);

	        // Wait for the expected URL after login
	        String expectedUrl = EnvironmentConfig.environmentSetup().get("APPLICATIONURL") + "/home";
	        waitForUrlToBe(ffDriver, expectedUrl); // Ensure this is called with the new driver

	        // Check if the expected URL matches the actual URL
	        String actualUrl = ffDriver.getCurrentUrl();
	        if (expectedUrl.equals(actualUrl)) {
	            LoggerManager.info("======== Login on different browser Success ========");
	            LoggerManager.info("======== End verifyLoginDiffUsersOnDifferentBrowsers() ========");
	            assertEquals(expectedUrl, actualUrl);
	            return true; // Return true if login was successful
	        } else {
	            LoggerManager.debug("======== verifyLoginDiffUsersOnDifferentBrowsers Unsuccessful ========");
	            return false; // Return false if login was unsuccessful
	        }
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Exception during different browser operations +++++++++ " + e.getMessage());
	        return false; // Handle any exceptions that arise in this section
	    } finally {
	        // Ensure the driver quits whether an exception occurred or not
	        if (ffDriver != null) {
	            ffDriver.quit();
	        }
	    }
	}

	public boolean userLogout() {
	    LoggerManager.info("======== Attempting user logout ========");

	    // Create a WebDriverWait instance
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    try {
	        // Wait for user panel to be visible
	        WebElement userPanel = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cc-user-panel-name']"))
	        );

	        // Click on the user panel using JavaScript to handle potential click issues
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", userPanel);
	        LoggerManager.info("======== User panel clicked ========");

	        // Wait for the logout button to be visible and click on it
	        WebElement logoutButton = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Logout')]"))
	        );
	        logoutButton.click();
	        LoggerManager.info("======== Logout button clicked ========");

	        LoggerManager.info("======== Logout successful ========");
	        return true; // Logout was successful

	    } catch (TimeoutException e) {
	        LoggerManager.error("+++++++++ TimeoutException in userLogout() +++++++++ " + e.getMessage());
	        return false; // Return false if the timeout occurs
	    } catch (ElementNotInteractableException e) {
	        LoggerManager.error("+++++++++ ElementNotInteractableException in userLogout() +++++++++ " + e.getMessage());
	        return false; // Return false if an element is not interactable
	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Exception in userLogout() +++++++++ " + e.getMessage());
	        return false; // Catch any other unexpected exceptions
	    }
	}

}
