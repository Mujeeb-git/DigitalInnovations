package innovationsPortal;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InnovationContestPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Action action;

	@FindBy(xpath = "//*[@id=\"keyword\"]")
	WebElement projectNameInputBox;
	
	@FindBy(xpath = "//*[@id=\"suggestionTable\"]/tbody/tr[1]/td[1]")
	WebElement projectList1;	
	
	@FindBy(xpath = "//*[@id=\"2\"]")
	WebElement contestTypeDropDown;
	
	@FindBy(xpath="//*[@id=\"5\"]")
	WebElement topicField;	
	
	@FindBy(xpath="//*[@id=\"7\"]")
	WebElement noOfIdeasField;
	
	@FindBy(xpath="//*[@id=\"48\"]")
	WebElement noOfParticipantsField;
	
	@FindBy(xpath="//*[@id=\"49\"]")
	WebElement noOfIdeasFinalRoundField;
	
	@FindBy(xpath="//*[@id=\"50\"]")
	WebElement noOfWinningIdeasField;
	
	@FindBy(xpath="//*[@id=\"51\"]")
	WebElement noOfPatentsFiledField;
	
	@FindBy(xpath="//*[@id=\"52\"]")
	WebElement noOfPatentsGrantedField;
	
	@FindBy(xpath="//*[@id=\"innovationDetails\"]/div[4]/div/button[1]")
	WebElement saveBtn;
	
	
	public InnovationContestPage(WebDriver driver) {

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
	
	// Choose contest type

	public void chooseContestType(String ideaType) {

		Select selectCT = new Select(contestTypeDropDown);
		selectCT.selectByVisibleText(ideaType);

	}
	
	// Enter topic
	public void enterTopic(String wsDate) {

		topicField.sendKeys(wsDate);

	}	
	
	// Enter number of ideas
	public void enterNoOfIdeas(String wsDate) {

		noOfIdeasField.sendKeys(wsDate);

	}	
	
	// Enter number of Participants
	public void enterNoOfParticipants(String wsDate) {

		noOfParticipantsField.sendKeys(wsDate);

	}	
	
	// Enter number of ideas reached final round
	public void enterNoOfIdeasFinalRound(String wsDate) {

		noOfIdeasFinalRoundField.sendKeys(wsDate);

	}	
	
	// Enter number of winning ideas
	public void enterNoOfWinningIdeas(String wsDate) {

		noOfWinningIdeasField.sendKeys(wsDate);

	}	
	
	// Enter number of patents filed
	public void enterNoOfPatentsFiled(String wsDate) {

		noOfPatentsFiledField.sendKeys(wsDate);

	}	
	
	// Enter number of patents Granted
	public void enterNoOfPatentsGranted(String wsDate) {

		noOfPatentsGrantedField.sendKeys(wsDate);

	}	
	
	// click on save to save the request
	public void clickSave() {

		saveBtn.click();

	}	
	
	
	
	
	
	
	
	
	

}
