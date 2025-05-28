package com.ciranet.community.information.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class CommunityAssetsPage extends BasePage {

	public CommunityAssetsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Community Assets']")
	WebElement communityAssetsSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[10]")
	WebElement addNewAssetButton;

	@FindBy(xpath = "//div[contains(text(),'Add/Edit Asset')]")
	WebElement addAssetPopupTitle;

	@FindBy(xpath = "(//div[@class='dx-texteditor-container']//div[@class='dx-dropdowneditor-icon'])[4]")
	WebElement assetGroupDropDown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement assetGroupDropDownValue;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[14]")
	WebElement assetNumberTextBox;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[15]")
	WebElement nameTextBox;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[16]")
	WebElement costTextBoxTextBox;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[17]")
	WebElement replacementCostTextBox;

	@FindBy(xpath = "(//input[@role='spinbutton'])[6]")
	WebElement estLifeRemainingTextBox;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[6]")
	WebElement estLifeAsOfDropDown;

	@FindBy(xpath = "(//div[@class ='dx-item dx-list-item'])[15]")
	WebElement estLifeAsOfDropDownValue;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='dx-group-panel-item dx-datagrid-action dx-datagrid-drag-action']")
	WebElement groupDrag;

	@FindBy(xpath = "//div[normalize-space()='Asset #']")
	WebElement groupDrop;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[@class='dx-button-text'][normalize-space()='Action'])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit/View')]")
	WebElement editViewMenu;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandAll;

	@FindBy(xpath = "//div[contains(text(),'Delete')]")
	WebElement deleteMenu;

	@FindBy(xpath = "//div[@aria-label='No']//div[@class='dx-button-content']")
	WebElement noConfirmationPopup;

	@FindBy(xpath = "//div[contains(text(),'Confirmation')]")
	WebElement confirmationPopup;

	@FindBy(xpath = "//tbody/tr[2]/td[11]/div[1]")
	WebElement uploadAssetImageLink;

	@FindBy(xpath = "//div[contains(text(),'Upload Asset Images')]")
	WebElement uploadAssetImagepopupTitle;

	@FindBy(xpath = "//div[contains(text(),'Actions')]")
	WebElement uploadAssetActionButton;

	@FindBy(xpath = "//div[contains(text(),'Add Image')]")
	WebElement addAssetImage;

	@FindBy(xpath = "//div//span[normalize-space()='Browse']")
	WebElement browseButton;

	@FindBy(xpath = "//div//span[normalize-space()='Save']")
	WebElement saveAssetImage;

	@FindBy(xpath = "//div//i[@class='dx-icon dx-icon-close']")
	WebElement closeUploadAsset;

	@FindBy(xpath = "//dx-button[@title='Hide Menu']//i[@class='dx-icon dx-icon-menu']")
	WebElement hamburger;

	QuickSearch quickSearch = new QuickSearch(driver);
	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public boolean navigate(String communityName) {

		LoggerManager.info("Starting community search with keyword: {} " + communityName);
		// Wait for loader icon to disappear
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Loader icon is invisible, proceeding with search.");
		quickSearch.searchCommunity(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);

		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey();
		} catch (AWTException e) {
			LoggerManager.error("Error pressing the Escape key");
		}

		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Community Assets']"),
					"Community Assets");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to 'Community Assets page");
			LoggerManager.info("Scrolling to Community Assets side navigation");
			scrollToElement(communityAssetsSideNav);

			if (isElementDisplayed(communityAssetsSideNav)) {
				LoggerManager.info("Community Assets side navigation is visible, clicking on it");
				clickElementJS(communityAssetsSideNav);
				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the community and accessed Community Assets");

				boolean isPageTitle = pageTitle.getText().equals("Assets");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Community Assets page is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the community search process");
			return false;
		}
	}

	public String addNewAsset() {

		String addPopupTitle = "";

		try {
			clickElement(addNewAssetButton);
			addPopupTitle = addAssetPopupTitle.getText();
			clickElement(assetGroupDropDown);
			clickElementJS(assetGroupDropDownValue);
			clickElementJS(assetNumberTextBox);
			assetNumberTextBox.sendKeys("Pool7777");
			clickElement(nameTextBox);
			nameTextBox.sendKeys("Pool Assets");
			clickElement(costTextBoxTextBox);
			costTextBoxTextBox.sendKeys("100");
			clickElement(replacementCostTextBox);
			replacementCostTextBox.sendKeys("30");
			scrollToElement(estLifeRemainingTextBox);
			clickElement(estLifeRemainingTextBox);
			estLifeRemainingTextBox.sendKeys("1");
			clickElementJS(estLifeAsOfDropDown);
			clickElementJS(estLifeAsOfDropDownValue);
			clickElement(saveButton);
		} catch (Exception e) {
			LoggerManager.error("Error occurred while adding a new asset: " + e.getMessage());
			throw e;
		}
		return addPopupTitle;
	}

	public String editAsset() {
		String editPopupTitle = "";

		try {
			waitForInvisibility(loaderIcon);
			clickElement(resetLayout);
			clickElement(expandAll);
			clickElement(actionButton);
			clickElementJS(editViewMenu);
			waitForInvisibility(loaderIcon);
			editPopupTitle = addAssetPopupTitle.getText();

			if (descriptionTextBox.getAttribute("value").isEmpty()) {
				descriptionTextBox.sendKeys("Edit the test description");
			}
			clickElement(saveButton);

		} catch (Exception e) {
			LoggerManager.error("Error occurred while editing the asset: " + e.getMessage());
			throw e;
		}
		return editPopupTitle;
	}

	public String deleteAsset() {

		String popupConfirmation = "";
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElementJS(deleteMenu);
			popupConfirmation = confirmationPopup.getText();
			waitForInvisibility(loaderIcon);
			clickElement(noConfirmationPopup);
		} catch (Exception e) {
			LoggerManager.error("Error occurred while deleting the asset: " + e.getMessage());
			throw e;
		}
		return popupConfirmation;
	}

	public String uploadAssetImage() {
		String assetImage = "";
		try {
			waitForInvisibility(loaderIcon);
			clickElement(hamburger);
			clickElement(uploadAssetImageLink);
			assetImage = uploadAssetImagepopupTitle.getText();
			waitForInvisibility(loaderIcon);
			Actions actions = new Actions(driver);
			actions.moveToElement(uploadAssetActionButton).perform();
			clickElement(addAssetImage);
			clickElement(browseButton);
			String filePath = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\ciranet\\testdata\\communityAssets.jpg";
			StringSelection s = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			waitForInvisibility(loaderIcon);
			robot.keyPress(KeyEvent.VK_V);
			waitForInvisibility(loaderIcon);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			waitForInvisibility(loaderIcon);
			robot.keyRelease(KeyEvent.VK_V);
			waitForInvisibility(loaderIcon);
			robot.keyPress(KeyEvent.VK_ENTER);
			waitForInvisibility(loaderIcon);
			robot.keyRelease(KeyEvent.VK_ENTER);
			waitForInvisibility(loaderIcon);
			clickElement(saveAssetImage);
			waitForInvisibility(loaderIcon);
			clickElement(closeUploadAsset);

		} catch (Exception e) {
			LoggerManager.error("Error occurred while uploading the asset image: " + e.getMessage());

		}
		return assetImage;
	}
}
