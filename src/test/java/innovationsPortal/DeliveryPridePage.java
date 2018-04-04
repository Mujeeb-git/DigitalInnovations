package innovationsPortal;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryPridePage {

	WebDriver driver;
	WebDriverWait wait;
	Action action;

	@FindBy(xpath = "//*[@id='auto-search-table']/input")
	WebElement projectNameInputBox;

	@FindBy(xpath = "//*[@id=\"suggestionTable\"]/tbody/tr[1]/td[1]")
	WebElement projectList1;

	@FindBy(xpath = "//*[@id=\"37\"]")
	WebElement prideTypeDropDown;

	@FindBy(xpath = "//*[@id=\"innovationDetails\"]/div[2]/div[1]/div/div[2]/div/div/div[1]/button")
	WebElement prideOutcomeBtn;

	@FindBy(xpath = "//*[@id=\"innovationDetails\"]/div[2]/div[1]/div/div[2]/div/div/div[1]/ul/li[4]/a/label/input")
	WebElement innovationPrideOutCome;

	@FindBy(xpath = "//*[@id=\"30\"]")
	WebElement confidentialityDropDown;

	//@FindBy(xpath = "//*[@class='submitbtn browseBtn pull-left']")
	@FindBy(xpath="//*[@id=\"no-more-tables\"]/table/tbody/tr/td[1]/div/div/div/div[1]/div[1]/button")
	WebElement chooseFileBtn;

	
	@FindBy(xpath = "//*[@id=\"no-more-tables\"]/table/tbody/tr/td[1]/div/div/div/button")
	WebElement uploadBtn;
	
	@FindBy(xpath = "//*[@class='submitbtn btn']")
	WebElement saveBtn;
	
	
	public DeliveryPridePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// enter and select Project Name

	public void enterProjectName(String projectName) throws Exception {

		projectNameInputBox.sendKeys(projectName);
		Thread.sleep(5000);
		projectList1.click();

	}

	// Choose pride Type from the drop down list

	public void choosePrideType(String prideType) throws Exception {

		Select selectPrideType = new Select(prideTypeDropDown);
		selectPrideType.selectByVisibleText(prideType);

	}

	// Choose pride outcome as innovation
	public void choosePrideOutcome() throws Exception {

		prideOutcomeBtn.click();
		innovationPrideOutCome.click();

	}

	// Choose confidentiality from the drop down list

	public void chooseConfidentiality(String confidentialityType) throws Exception {

		Select selectPrideType = new Select(confidentialityDropDown);
		selectPrideType.selectByVisibleText(confidentialityType);

	}

	// Choose confidentiality from the drop down list

	public void chooseFile(String fileSrc) throws Exception {
		
		/*int sizeX = driver.findElements(By.xpath("//*[@class='submitbtn browseBtn pull-left']")).size();
		WebElement chooseFileBtn = driver.findElements(By.xpath("//*[@class='submitbtn browseBtn pull-left']")).get(sizeX-1);
		
		wait = new WebDriverWait(driver, 60); //30s timeout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='submitbtn browseBtn pull-left']")));
		*/
		Actions builder = new Actions(driver);
		builder.moveToElement(chooseFileBtn).click();
	    builder.perform();	 
				
		StringSelection ss = new StringSelection(fileSrc);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Thread.sleep(1000);
	    //imitate mouse events like ENTER, CTRL+C, CTRL+V
	    Robot robot = new Robot();
	    
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
			

	}
	
	//upload the file
	
	public void uploadFile() throws Exception {

		uploadBtn.click();

	}
	
	//save the innovation request
	
		public void saveRequest() throws Exception {

			saveBtn.click();

		}

}