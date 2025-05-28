package com.ciranet.myworkqueue.communitymanagement.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class CommonLotsAppraisalPage extends BasePage {

	public CommonLotsAppraisalPage(WebDriver driver) {
		super(driver);
	}

	Random random = new Random();

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@title='Column Chooser']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooser;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-file-excel']")
	WebElement exportToExcel;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-file-csv']")
	WebElement exportToCSV;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),' Common Lots Appraisal ')]")
	WebElement commonLotsApprisalSideNav;

	@FindBy(xpath = "//h2[contains(text(),'Common Lots Appraisal')]")
	WebElement pageTitle;

	@FindBy(xpath = "//div[contains(text(),'Column Chooser')]")
	WebElement lblColumnChooser;

	@FindBy(xpath = "//span[normalize-space()='Add New Common Lot']")
	WebElement addNewCommonLotButton;

	@FindBy(xpath = "//input[contains(@id,'phase')]")
	WebElement phaseDropdown;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content']")
	WebElement phaseDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container'])[12]")
	WebElement sectionDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[2]")
	WebElement sectionDropdownValue;

	@FindBy(xpath = "//input[@name='block']")
	WebElement blockTextbox;

	@FindBy(xpath = "//input[@name='lotNumber']")
	WebElement lotNumberTextbox;

	@FindBy(xpath = "//input[@name='streetNumber']")
	WebElement streetNumber;

	@FindBy(xpath = "//input[contains(@id,'streetName')]")
	WebElement streetNameDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[3]")
	WebElement streetNameDropdownValue;

	@FindBy(xpath = "//input[contains(@id,'city')]")
	WebElement cityTextbox;

	@FindBy(xpath = "//input[contains(@id,'state')]")
	WebElement stateDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[20]")
	WebElement stateDropdownValue;

	@FindBy(xpath = "//input[@name='zip']")
	WebElement zipTextbox;

	@FindBy(xpath = "//input[contains(@id,'county')]")
	WebElement countryTextbox;

	@FindBy(xpath = "//input[contains(@id,'parcelNumber')]")
	WebElement parcleNuberTextbox;

	@FindBy(xpath = "//input[contains(@id,'improvedValue')]")
	WebElement improvedValue;

	@FindBy(xpath = "//input[contains(@id,'totalAcreage')]")
	WebElement totalAverage;

	@FindBy(xpath = "//input[contains(@id,'commonAreaTypeId')]")
	WebElement commonAreaType;

	@FindBy(xpath = "//div[contains(text(),'Landscaped Circle')]")
	WebElement commonAreaTypeValue;

	@FindBy(xpath = "//span[@class='dx-button-text'][contains(.,'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement addSuccessMessage;

	@FindBy(xpath = "//textarea[contains(@id,'commonAreaDescription')]")
	WebElement lotDescription;

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement commonLotDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement commonLotsRow;

	@FindBy(xpath = "//span[contains(.,'Edit Common Lot')]")
	WebElement editCommonLot;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-toast-success dx-toast-content dx-resizable']")
	WebElement editSuccessMessage;

	// For Add New Appraiser

	@FindBy(xpath = "//span[contains(.,'Add New Appraiser')]")
	WebElement addNewAppraiser;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[11]")
	WebElement appraiserName;

	@FindBy(xpath = "//div//input[contains(@id,'websiteUrl')]")
	WebElement websiteUrl;

	@FindBy(xpath = "//input[contains(@id,'telephone')]")
	WebElement telephone;

	@FindBy(xpath = "//input[contains(@id,'protestDate')]")
	WebElement protestDate;

	@FindBy(xpath = "//span[contains(.,'Cancel')]")
	WebElement cancelAppraiser;

// Declaration for + Common Lot Appraisal
	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[5]")
	WebElement selectAppraiserDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[2]")
	WebElement appraiserRow;

	@FindBy(xpath = "//span[contains(.,'Edit Appraiser')]")
	WebElement editAppraisalButton;

	@FindBy(xpath = "//div[contains(text(),'Edit Appraiser')]")
	WebElement editAppriserPopup;

	@FindBy(css = ".dx-button-success .dx-button-text")
	WebElement saveAppriserButton;

	@FindBy(xpath="(//i[@class='dx-icon far fa-times-circle'])[1]")
	WebElement commonLotsRecordSeen;
	
	Navigation navigationSearch = new Navigation(driver);

	// method declaration
	public String navigate() {
		try {
			LoggerManager.info("Navigating to the Common Lots Appraisal Page.");

			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),' Common Lots Appraisal ')]"),
					" Common Lots Appraisal ");

			scrollToElement(commonLotsApprisalSideNav);
			clickElementJS(commonLotsApprisalSideNav);

			String strPageTitle = pageTitle.getText();

			LoggerManager.info("Successfully navigated to Common Lots Appraisal Page. Retrieved text: " + strPageTitle);
			return strPageTitle;

		} catch (Exception e) {
			LoggerManager.error("An error occurred while navigating to the Common Lots Appraisal Page." + e);
			return null;
		}
	}

	public boolean toolBarFullScreen() {
		try {
			LoggerManager.info("Loader icon is no longer visible.");

			clickElementJS(fullScreenIcon);
			LoggerManager.info("Clicked on the fullscreen icon.");

			// Check if the normal screen icon is displayed
			if (isElementDisplayed(normalScreenIcon)) {
				LoggerManager.info("Normal screen icon is displayed. Reverting to normal mode.");

				clickElementJS(normalScreenIcon);
				LoggerManager.info("Successfully reverted to normal mode.");
				return true;
			} else {
				LoggerManager.warn("Normal screen icon is not displayed. Fullscreen toggle may have failed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the toolbar fullscreen toggle: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean columnChooserClick() {
		try {
			LoggerManager.info("Initiating Column Chooser click action.");

			LoggerManager.info("Clicking on 'Column Chooser'.");

			clickElement(columnChooser);

			boolean isColumnChooser = lblColumnChooser.getText().equals("Column Chooser");
			LoggerManager.info("Page Title validation: " + (isColumnChooser ? "Passed" : "Failed"));

			waitForElementToBeClickable(closeColChooser);

			clickElement(closeColChooser);

			LoggerManager.info("Column Chooser action completed successfully.");
			return isColumnChooser;
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the Column Chooser click action." + e);
			return false;
		}
	}

	public boolean verifyExportToExcel() {
		try {
			LoggerManager.info("Checking if the 'Excel' button is enabled.");

			waitForElementToBeVisible(exportToExcel);

			waitForElementToBeClickable(exportToExcel);

			if (isElementEnabled(exportToExcel)) {
				LoggerManager.info("'Excel' button is enabled. Proceeding with click action.");

				clickElementJS(exportToExcel);

				LoggerManager.info("'Excel' export button clicked successfully.");
				return true;
			} else {
				LoggerManager.warn("'Excel' button is not enabled.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while clicking the 'Excel' button." + e);
			return false;
		}
	}

	public boolean verifyExportToCSV() {
		try {
			LoggerManager.info("Checking if the 'Export to CSV' button is enabled.");

			waitForInvisibility(loaderIcon);

			if (isElementEnabled(exportToCSV)) {
				LoggerManager.info("'Export to CSV' button is enabled. Proceeding with click action.");
				clickElement(exportToCSV);

				LoggerManager.info("'Export to CSV' operation completed successfully.");
				return true;
			} else {
				LoggerManager.warn("'Export to CSV' button is not enabled.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while performing 'Export to CSV' operation." + e);
			return false;
		}
	}

	public boolean verifyAddNewCommonLotEntry() {

		try {
			LoggerManager.info("Checking Add New Common Lot Entry.");

			waitForElementToBeClickable(addNewCommonLotButton);

			if (isElementEnabled(addNewCommonLotButton)) {
				LoggerManager.info("'Add New Common Lot' button is enable.");
				clickElementJS(addNewCommonLotButton);

				waitForElementToBeClickable(phaseDropdown);
				clickElement(phaseDropdown);
				waitForElementToBeVisible(phaseDropdownValue);
				scrollToElement(phaseDropdownValue);
				clickElement(phaseDropdownValue);

				clickElement(sectionDropdown);
				scrollToElement(sectionDropdownValue);

				waitForElementToBeVisible(sectionDropdownValue);
				clickElement(sectionDropdownValue);

				enterText(blockTextbox, "Test block" + random.nextInt(100));
				enterText(lotNumberTextbox, "test Lot" + random.nextInt(100));

				enterText(streetNumber, "1" + random.nextInt(100));

				clickElement(streetNameDropdown);
				waitForElementToBeVisible(streetNameDropdownValue);
				clickElement(streetNameDropdownValue);

				enterText(cityTextbox, "City" + random.nextInt(1000));

				clickElement(stateDropdown);
				waitForElementToBeVisible(stateDropdownValue);
				clickElement(stateDropdownValue);

				enterText(zipTextbox, "00501");

				enterText(countryTextbox, "USA");
				enterText(parcleNuberTextbox, String.valueOf(random.nextInt(100)));
				enterText(improvedValue, "21");
				enterText(totalAverage, "2");

				clickElement(commonAreaType);
				waitForElementToBeVisible(commonAreaTypeValue);
				clickElement(commonAreaTypeValue);

				scrollToElement(lotDescription);
				clickElement(lotDescription);
				enterText(lotDescription, "Lot details");

				waitForElementToBeClickable(saveButton);

				clickElement(saveButton);

				LoggerManager.info("'Add New Common Lot' operation completed successfully.");

				waitForElementToBeVisible(addSuccessMessage);

				return isElementDisplayed(addSuccessMessage);
			} else {
				LoggerManager.info("'Add New Common Lot' button is not enabled.");
				return false;
			}
		} catch (Exception e) {

			LoggerManager.error("An error occurred while performing 'Add New Common Lot' operation." + e);
			return false;
		}
	}

	//
	private void getCommonLotRecord() {
		try {
			waitForElementToBeVisible(commonLotDropdown);

			waitForElementToBeClickable(commonLotDropdown);
			scrollToElement(commonLotDropdown);
			clickElement(commonLotDropdown);

			scrollToElement(commonLotsRow);
			waitForElementToBeClickable(commonLotsRow);
			clickElement(commonLotsRow);
		} catch (Exception e) {
			LoggerManager.info("Error while getting Common record entry");
		}
	}

	public static String createRandomName(int length) {
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random random = new Random();
	    StringBuilder userName = new StringBuilder();

	    try {
	        if (length <= 0) {
	            LoggerManager.error("Invalid length provided for random name generation: " + length);
	            throw new IllegalArgumentException("Length must be greater than 0");
	        }

	        // Generate the first character as uppercase
	        userName.append(alphabet.charAt(random.nextInt(alphabet.length())));

	        // Generate the rest of the characters as lowercase
	        for (int i = 1; i < length; i++) {
	        	userName.append(Character.toLowerCase(alphabet.charAt(random.nextInt(alphabet.length()))));
	        }

	        LoggerManager.info("Random name generated successfully: " + userName.toString());
	    } catch (IllegalArgumentException e) {
	        LoggerManager.error("Error generating random name due to invalid input: " + e.getMessage());
	        throw e; // Re-throwing to let the calling code handle it if needed
	    } catch (Exception e) {
	        LoggerManager.error("Unexpected error during random name generation: " + e.getMessage());
	        throw e;
	    }

	    return userName.toString();
	}

	private void getCommonLotAppraiserRecord() {
		try {
			waitForElementToBeVisible(selectAppraiserDropdown);
			waitForElementToBeClickable(selectAppraiserDropdown);
			scrollToElement(selectAppraiserDropdown);
			clickElement(selectAppraiserDropdown);

			scrollToElement(appraiserRow);
			waitForElementToBeClickable(appraiserRow);
			clickElementJS(appraiserRow);
		} catch (Exception e) {
			LoggerManager.info("Error while getting Appraiser record");
		}
	}

	public boolean verifyEditCommonLotEntry() {
		try {
			LoggerManager.info("Checking Edit Common Lot Entry.");

			getCommonLotRecord();

			waitForElementToBeClickable(editCommonLot);
			if (isElementEnabled(editCommonLot)) {
				LoggerManager.info("'Edit Common Lot' button is enable.");
				clickElementJS(editCommonLot);
				
				waitForInvisibility(loaderIcon);

				clickElementJS(saveButton);

				waitForElementToBeVisible(editSuccessMessage);
				return isElementDisplayed(editSuccessMessage);
			} else {
				LoggerManager.info("Error in Edit Common Lot process.");
				return false;
			}
		} catch (Exception e) {

			LoggerManager.error("An error occurred while performing 'Edit Common Lot' operation." + e);
			return false;
		}
	}

	public boolean addNewAppraiserEntry() {
		try {
			LoggerManager.info("Checking Add New Appraiser Entry.");

			
			waitForElementToBeClickable(addNewAppraiser);

			if (isElementEnabled(addNewAppraiser)) {
				

				LoggerManager.info("'Add New Appraiser' button is enable.");
				clickElementJS(addNewAppraiser);

				waitForInvisibility(loaderIcon);
				
				 clickElement(appraiserName);
				appraiserName.sendKeys(createRandomName(10));
				
				waitForElementToBeClickable(websiteUrl);
				
				clickElementJS(websiteUrl);
				enterText(websiteUrl, "http://www.test" + createRandomName(4).toLowerCase() + ".com");

				clickElement(telephone);
				telephone.sendKeys("0123456789");

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String currentDate = LocalDate.now().format(formatter);
				enterText(protestDate, currentDate);

				waitForElementToBeClickable(saveButton);
				
				waitForInvisibility(loaderIcon);

				clickElement(saveButton);

				waitForElementToBeVisible(addSuccessMessage);

				return isElementDisplayed(addSuccessMessage);
			} else {
				LoggerManager.info("Error in Add New Appraiser process.");
				return false;
			}
		} catch (Exception e) {

			LoggerManager.error("An error occurred while performing 'Add New Appraiser' operation." + e);
			return false;
		}
	}

	public boolean editCommonLotAppraiserEntry() {
		try {
			LoggerManager.info("Checking Edit Common Lot Appraiser Entry.");

			
			if (!isElementDisplayed(commonLotsRecordSeen)) 
				{ 
					getCommonLotRecord();
				}

			getCommonLotAppraiserRecord();

			waitForElementToBeClickable(editAppraisalButton);

			if (isElementEnabled(editAppraisalButton)) {

				LoggerManager.info("'Edit Common Lot Appraisal' button is enable.");
				clickElement(editAppraisalButton);
				
				waitForElementToBeVisible(editAppriserPopup);
				return isElementDisplayed(editAppriserPopup);

			} else {
				LoggerManager.info("Error in Edit Common Lot Appraisal entry.");
				return false;
			}
		} catch (Exception e) {

			LoggerManager.error("An error occurred while performing 'Edit Common Lot Appraisal' entry." + e);
			return false;
		}
	}

}
