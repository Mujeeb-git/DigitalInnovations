package innovationsPortal;

import java.awt.Desktop.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clientCoInnovationPage {

	WebDriver driver;
	WebDriverWait wait;
	Action action;

	@FindBy(xpath = "//*[@id=\"keyword\"]")
	WebElement projectNameInputBox;
	
	
	@FindBy(xpath = "//*[@id=\"suggestionTable\"]/tbody/tr[1]/td[1]")
	WebElement projectList1;
	

	@FindBy(xpath = "//*[@id=\"13\"]")
	WebElement ideaSourceDropDown;

	@FindBy(xpath = "//*[@id=\"1067\"]")
	WebElement workshopTypeDropDown;

	@FindBy(xpath = "//*[@id=\"1072\"]")
	WebElement workshopDateField;

	@FindBy(xpath = "//*[@id=\"14\"]")
	WebElement statusDropDown;

	@FindBy(xpath = "//*[@id=\"15\"]")
	WebElement memberFromClientField;

	@FindBy(xpath = "//*[@id=\"16\"]")
	WebElement topicOfDiscussionField;

	@FindBy(xpath = "//*[@id=\"17\"]")
	WebElement ideasGeneratedField;

	@FindBy(xpath = "//*[@id=\"18\"]")
	WebElement outcomeField;

	@FindBy(xpath = "//*[@id=\"19\"]")
	WebElement ideaTitleField;

	@FindBy(xpath = "//*[@id=\"dulead\"]")
	WebElement ideaOwnerField;

	@FindBy(xpath = "//*[@id=\"innovationDetails\"]/div[3]/div[1]/div/div[6]/div/div/div[1]/div/div[2]/ul/li")
	WebElement ideaOwnerListValue;

	@FindBy(xpath = "//*[@id=\"21\"]")
	WebElement noOfIdeasField;

	@FindBy(xpath = "//*[@id=\"1062\"]")
	WebElement eligibleForCoInnovationDropDown;

	@FindBy(xpath = "//*[@id=\"1063\"]")
	WebElement activePursuitsField;

	@FindBy(xpath = "//*[@id=\"1064\"]")
	WebElement innovationWorkshopDropDown;

	@FindBy(xpath = "//*[@id=\"1065\"]")
	WebElement clientEndorsementsDropDown;

	@FindBy(xpath = "//*[@id=\"1066\"]")
	WebElement clientTestimonyDropDown;

	@FindBy(xpath = "//*[@id=\"innovationDetails\"]/div[4]/div/button[1]")
	WebElement saveBtn;

	public clientCoInnovationPage(WebDriver driver) {

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

	// Choose Idea Source Type from the drop down list

	public void chooseIdeaSource(String ideaType) {

		Select selectIdeaSource = new Select(ideaSourceDropDown);
		selectIdeaSource.selectByVisibleText(ideaType);

	}

	// Choose Workshop type
	public void chooseWorkShopType(String wsType) {

		Select selectWorkshopType = new Select(workshopTypeDropDown);
		selectWorkshopType.selectByVisibleText(wsType);

	}

	// Enter Workshop date
	public void enterWorkShopDate(String wsDate) {

		workshopDateField.sendKeys(wsDate);

	}

	// Choose status
	public void chooseStatus(String status) {

		Select selectWorkshopType = new Select(statusDropDown);
		selectWorkshopType.selectByVisibleText(status);

	}

	// enter client members
	public void enterClientMembers(String clientMembers) {

		memberFromClientField.sendKeys(clientMembers);

	}

	// enter topic of discussion
	public void enterTopicOfDiscussion(String topic) {

		topicOfDiscussionField.sendKeys(topic);

	}

	// enter the ideas generated
	public void enterIdeasGenerated(String ideas) {

		ideasGeneratedField.sendKeys(ideas);

	}

	// enter the outcome
	public void enterOutcome(String outcome) {

		outcomeField.sendKeys(outcome);

	}

	// enter the idea title
	public void enterIdeaTitle(String ideaTitle) {

		ideaTitleField.sendKeys(ideaTitle);

	}

	// select the idea owner
	public void selectIdeaOwner(String ideaOwner) throws Exception {

		ideaOwnerField.sendKeys(ideaOwner);
		Thread.sleep(5000);
		ideaOwnerListValue.click();

	}

	// enter number of ideas
	public void enterNoOfIdeas(String totalIdeas) {

		noOfIdeasField.sendKeys(totalIdeas);

	}

	// Choose eligibleForCoinnovation
	public void eligibleForCoiinovation(String eligible) {

		Select selectefci = new Select(eligibleForCoInnovationDropDown);
		selectefci.selectByVisibleText(eligible);

	}

	// enter active pursuits
	public void enterActivePursuit(String activePursuit) {

		activePursuitsField.sendKeys(activePursuit);

	}

	// Choose innovation workshop with client
	public void innovationWSclient(String iwswc) {

		Select selectiwwc = new Select(innovationWorkshopDropDown);
		selectiwwc.selectByVisibleText(iwswc);

	}

	// Choose clientEndorsement
	public void clientEndorsement(String CEndoresments) {

		Select selectce = new Select(clientEndorsementsDropDown);
		selectce.selectByVisibleText(CEndoresments);

	}

	// Choose client willing to provide testimony
	public void clientTestimony(String clientTestimony) {

		Select selectct = new Select(clientTestimonyDropDown);
		selectct.selectByVisibleText(clientTestimony);

	}

	// clickSave
	public void clickSave() {

		saveBtn.click();

	}

}
