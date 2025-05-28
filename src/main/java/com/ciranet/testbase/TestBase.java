package com.ciranet.testbase;

import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

// for Extent Reports
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ciranet.basepage.BasePage;
import com.ciranet.constants.Constants;
import com.ciranet.loginpage.pages.LoginPage;
import com.ciranet.testlisteners.LoginListener;
import com.ciranet.utilities.CommonUtilities;
import com.ciranet.utilities.EnvironmentConfig;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;
import com.ciranet.utilities.XMLCredentialsReader;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

@Listeners(LoginListener.class)

public class TestBase {
	public static WebDriver driver;
	LoginPage loginPageStart = createPage(LoginPage.class);
	// For Extent Report and used in TestListener.java class
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	protected String usertype;
	protected String username;
	protected String password;

	DesiredCapabilities dc = new DesiredCapabilities();

	protected XMLCredentialsReader.userCredentials credentials;
	
	String setWindowSize="--window-size=1920,1080";
	String setAutomationExtension = "useAutomationExtension";

// Perform login here if you want to do it only once before any test method
	@Parameters({ "usertype", "username" })
	@BeforeSuite(alwaysRun = true)
	public void loginSetup(String usertype, String username) throws Exception {

	    this.usertype = usertype;
	    this.username = username;

	    try {
	        if (Constants.BROWSER_TYPE.equalsIgnoreCase("Chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            configureChromeOptions(options);
	            driver = new ChromeDriver(options);
	            LoggerManager.debug("------- Chrome browser loaded -------");
	        } else if (Constants.BROWSER_TYPE.equalsIgnoreCase("FireFox")) {
	            FirefoxOptions options = new FirefoxOptions();
	            configureFirefoxOptions(options);
	            driver = new FirefoxDriver(options);
	            LoggerManager.debug("------- FireFox browser loaded -------");
	        } else if (Constants.BROWSER_TYPE.equalsIgnoreCase("Edge")) {
	            EdgeOptions options = new EdgeOptions();
	            configureEdgeOptions(options);
	            driver = new EdgeDriver(options);
	            LoggerManager.debug("------- Edge browser loaded -------");
	        } else if (Constants.BROWSER_TYPE.equalsIgnoreCase("Safari")) {
	            driver = new SafariDriver();
	            LoggerManager.debug("------- Safari browser loaded -------");
	        } else {
	            ChromeOptions options = new ChromeOptions();
	            configureChromeOptions(options);
	            driver = new ChromeDriver(options);
	            LoggerManager.debug("------- Chrome browser loaded as default -------");
	        }

	        if (driver != null) {
	            driver.manage().deleteAllCookies();
	            driver.manage().window().maximize();
	            driver.get(EnvironmentConfig.environmentSetup().get("APPLICATIONURL"));
	            LoggerManager.debug(
	                    "------- Application URL set to: " + EnvironmentConfig.environmentSetup().get("APPLICATIONURL"));
	            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
	            LoggerManager.debug("------- Page load timeout is set to: " + Constants.PAGE_LOAD_TIMEOUT);
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	            LoggerManager.debug("------- Implicit Wait time is set to: " + Constants.IMPLICIT_WAIT);
	        }

	        // Handle login if required
	        if (requiresLogin()) {
	            loginIfNeeded();
	        }

	    } catch (Exception e) {
	        LoggerManager.error("+++++++++ Exception in loginSetup() +++++++++ " + e.getMessage());
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	            LoggerManager.debug("------- Browser closed and set to NULL -------");
	        }
	        throw e; // Re-throw the exception to allow it to be handled by calling code if needed
	    }
	}

	// Chrome configuration
	private void configureChromeOptions(ChromeOptions options) {
	    if (!Constants.GUI_MODE) {
	        options.addArguments("--headless=new"); //For new Chrome version
	        options.addArguments(setWindowSize);
	    }
	    options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
	    options.setExperimentalOption(setAutomationExtension, false);
	}

	// Firefox configuration
	private void configureFirefoxOptions(FirefoxOptions options) {
	    if (!Constants.GUI_MODE) {
	        options.addArguments("--headless");
	        options.addArguments(setWindowSize);
	    }
	    options.addPreference("dom.webdriver.enabled", false);
	    options.addPreference(setAutomationExtension, false);
	}

	// Edge configuration
	private void configureEdgeOptions(EdgeOptions options) {
	    if (!Constants.GUI_MODE) {
	        options.addArguments("--headless=new"); // For new Edge version
	        options.addArguments(setWindowSize);
	    }
	    options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
	    options.setExperimentalOption(setAutomationExtension, false);
	}
	
	
	@BeforeSuite(alwaysRun = true)
	public WebDriver setupExtentReports() throws UnknownHostException {
		// For Storing Extent Report location in String
		String extentReportLocation;
		String strExtentReport = "";
		
		// Code For the Extent Reports
		htmlReporter = new ExtentSparkReporter(EnvironmentConfig.environmentSetup().get("REPORT_LOCATION")
				+ "AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName : ", InetAddress.getLocalHost().getHostName());
		extent.setSystemInfo("ProjectName : ", "Cira Automation Test Automation");
		extent.setSystemInfo("Test Environment: ", System.getProperty("env").toUpperCase());
		extent.setSystemInfo("Operating System : ", System.getProperty("os.name"));
		extent.setSystemInfo("QA Name : ", System.getProperty("user.name"));

		// To set Report properties
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Cira Test Automation Report");
		htmlReporter.config().setReportName("Cira Automation Test Execution Report ");
		htmlReporter.config().setEncoding("utf-8");

		strExtentReport = EnvironmentConfig.environmentSetup().get("REPORT_LOCATION");
		strExtentReport = strExtentReport.substring(1, strExtentReport.length());
		strExtentReport = strExtentReport.replaceAll("\\/", "//");
		extentReportLocation = System.getProperty("user.dir") + strExtentReport + "AutomationExtentReport_"
				+ CommonUtilities.getCurrentDateTime() + ".html";
		extentReportLocation = extentReportLocation.replaceAll("\\//", "\\\\");
		extentReportLocation = extentReportLocation.replaceAll("\\\\", "\\\\\\\\");

		return driver;
	}

	@BeforeMethod
	public void setUp(Method method) {
		// Initialize ExtentTest for the current test method
		test = extent.createTest(method.getName());
	}

	// This is a Common Method to set the Extent Report for Each Test Case.
	public static void setExtentReportSettings(String strCreateTest, String strAssignCategory, String strCreateNode,
			String statusInfo) {
		TestBase.test = TestBase.extent.createTest(strCreateTest);// "Home Page Test"
		TestBase.test.assignCategory(strAssignCategory); // "Test Type"
		TestBase.test = TestBase.test.createNode(strCreateNode); //
		TestBase.test.log(Status.INFO, statusInfo); // "Verifying Home Page"
	}

	// This module is used to capture a screenshot
	public static String captureScreenshot(WebDriver driver, String screenShotName) throws Exception {
		Screenshot screenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE); 
		String destination = System.getProperty("user.dir") + "/" + "ScreenShot/" + screenShotName + "_" + dateName
				+ ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		ImageIO.write(screenShot.getImage(), "PNG", new File(destination));
		return destination;
	}

	// Data provider is used to get the user credentials
	@DataProvider(name = "userProvider")
	public Object[][] credentialsUserProvider() throws Exception {
		try {
			credentials = XMLCredentialsReader.findUserByUsername(this.username);
			return new Object[][] { { credentials } };

		} catch (Exception e) {
			LoggerManager.error("Error: " + e.getMessage());
			if (driver != null) {
				driver.quit();
			}
			throw new RuntimeException("User does not exist: " + this.username + ". Stopping the test.");
		}
	}

	// Method to create page objects
	protected <T extends BasePage> T createPage(Class<T> pageClass) {
		try {
			// Use reflection to create a new instance of the page class
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (Exception e) {
			throw new RuntimeException("Page object creation failed", e);
		}
	}

	// Method is used to do perform login method
	public void performLogin() throws Exception {
		credentials = getCredentials(); // Method to fetch credentials
		loginPageStart = new LoginPage(driver);
		loginPageStart.verifyLogin(credentials.getUsername(), credentials.getPassword());
	}

	// Utility method to fetch credentials, could be overridden or customized
	protected XMLCredentialsReader.userCredentials getCredentials() throws Exception {
		return (XMLCredentialsReader.userCredentials) credentialsUserProvider()[0][0];
	}

	private boolean requiresLogin() {
		// Check if the current test class or any method is annotated with
		// @RequiresLogin
		Class<?> testClass = this.getClass();

		// Check at the class level
		if (testClass.isAnnotationPresent(RequiresLogin.class)) {
			return true;
		}

		// Check at the method level
		for (Method method : testClass.getMethods()) {
			if (method.isAnnotationPresent(RequiresLogin.class)) {
				return true;
			}
		}

		return false;
	}

	public void loginIfNeeded() throws Exception {
		if (!isUserLoggedIn()) {
			performLogin();
		}
	}

	public boolean isUserLoggedIn() {
	    // Check if the driver is not null
	    if (driver == null) {
	        return false; // Return false if driver is not initialized
	    }

	    try {
	        // Used the JavascriptExecutor to determine if the element exists
	        Boolean isUserPanelPresent = (Boolean) ((JavascriptExecutor) driver)
	                .executeScript("return document.querySelector('div.cc-user-panel-name') !== null;");
	        return Boolean.TRUE.equals(isUserPanelPresent); 
	    } catch (Exception e) {
	        // Log the exception if needed
	        return false;
	    }
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		LoggerManager.info("----- Quitting browser -----");

		if (driver != null) {
			driver.quit();
		}
		LoggerManager.debug("------- Browser quit successfully -------");

		// This will generate the Extent Report
		extent.flush();
	}
}
