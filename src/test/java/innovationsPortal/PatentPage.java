package innovationsPortal;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatentPage {

	WebDriver driver;
	WebDriverWait wait;
	Action action;
	Actions action1;
	
	@FindBy(xpath = "//*[@id=\"keyword\"]")
	WebElement projectNameInputBox;
	
	@FindBy(xpath = "//*[@id=\"suggestionTable\"]/tbody/tr[1]/td[2]")
	WebElement projectList1;
	
	@FindBy(xpath = "//*[@id=\"1059\"]")
	WebElement titleField;	
	
	@FindBy(xpath = "//*[@id=\"multipleautocomplete\"]/div[1]/div[2]")
	WebElement investerNameField;
	
	@FindBy(xpath = "//*[@id=\"multipleautocomplete\"]/div[2]/ul/li[1]")
	WebElement investerNameList1;
		
	@FindBy(xpath="//*[@id=\"1073\"]")
	WebElement patentTypeDropdown;	
	
	@FindBy(xpath="//*[@id=\"1061\"]")
	WebElement patentNumberField;
		
	@FindBy(xpath="//*[@id=\"1074\"]")
	WebElement filingNumberField;
		
	@FindBy(xpath="//*[@id=\"1076\"]")
	WebElement isFilingApprovedField;
		
	@FindBy(xpath="//*[@id=\"1078\"]")
	WebElement filingGeographyField;
	
	
	@FindBy(xpath="//*[@id=\"dulead\"]")
	WebElement legalAttorneyNameField;
	
	@FindBy(xpath="//*[@id='innovationDetails']/div[2]/div[1]/div/div[8]/div/div/div[1]/div/div[2]/ul/li[1]")
	WebElement legalAttorneyNameList1;
	
	@FindBy(xpath="//*[@id=\"innovationDetails\"]/div[3]/div/button[1]")
	WebElement saveBtn;
	
	
	public PatentPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	// enter and select Project Name

	public void enterProjectName(String projectName) throws InterruptedException {

		projectNameInputBox.sendKeys(projectName);
		Thread.sleep(5000);
		projectList1.click();

	}
	

	
	// Enter Patent title
	public void enterPatentTitle(String pTitle) {

		titleField.sendKeys(pTitle);

	}	
	
	// Enter Investor Name
	public void enterInvestorName(String iName) throws InterruptedException {

		investerNameField.sendKeys(iName);
		Thread.sleep(5000);
		investerNameList1.click();
		
		
		
		

	}	
	
	
	// Choose patent type

	public void choosePatentType(String pType) {

		Select selectPT = new Select(patentTypeDropdown);
		selectPT.selectByVisibleText(pType);

	}
	
	
	// Enter patent number 
	public void enterPatentNumber(String pNumber) {
		
		patentNumberField.sendKeys(pNumber);

	}	
	
	// Enter filing number 
	public void enterFilingNumber(String fNumber) {

		filingNumberField.sendKeys(fNumber);

	}	
	
	
	// Choose if filing is approved or not YES Or NO

	public void chooseFilingApproved(String fApproved) {

		Select selectPT = new Select(isFilingApprovedField);
		selectPT.selectByVisibleText(fApproved);

	}
	
	// Enter filing Geography 
	public void enterFilingGeography(String fGeography) {

		filingGeographyField.sendKeys(fGeography);

	}	
	
	// Enter legal Attorney  
	public void enterLegalAttorney(String lAttorney) throws InterruptedException {

		legalAttorneyNameField.sendKeys(lAttorney);
		Thread.sleep(5000);
		legalAttorneyNameList1.click();

	}	
	
		
	// click on save to save the request
	public void clickSave() {

		saveBtn.click();

	}	
}
