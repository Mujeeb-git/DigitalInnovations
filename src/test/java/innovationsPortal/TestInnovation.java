package innovationsPortal;

import java.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import innovationsPortal.ExcelHelp;

public class TestInnovation {

	ExcelHelp objExcelFile;
	String filePath, filePath2, decryptedPassword, encryptedPassword,userName,dateStr;
	int noOfRequests;
	WebDriver driver;
	WebDriverWait wait;
	InnovationHomePage objInnovationHomePage;
	DeliveryPridePage objDeliveryPridePage;
	clientCoInnovationPage objclientCoInnovationPage;
	InnovationContestPage objInnovationsContestPage;
	PatentPage objPatentPage;
	LoginPage objLoginPage;
	Utility objUtility;

	@BeforeClass
	public void setUp() throws Exception {

		// Create an object of Excel class
		objExcelFile = new ExcelHelp();

		// Prepare the path of excel file
		//filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ExportExcel.xlsx";
		filePath2 = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\Delivery Pride_Artifact.pdf";

		System.setProperty("webdriver.chrome.driver", "C:\\Mujeeb\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://digitalss.test.accenture.com/innovation/main.html#/");
		Thread.sleep(20000);
		
		//UserCreds
		userName = "mujeeb.mohammed";
		encryptedPassword = "TmV3bGlmZUA3";
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);
		
		wait = new WebDriverWait(driver, 120);
		//Login Page
		objLoginPage = new LoginPage(driver);
		objLoginPage.userName.sendKeys(userName);
		objLoginPage.password.sendKeys(decryptedPassword);
		objLoginPage.submit.click();
		Thread.sleep(10000);
		objLoginPage.confirmYourIdentity();
		
		 // 30s timeout
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"bodyController\"][@class='delivery-sales-automation ng-scope']")));
		Thread.sleep(10000);
		driver.navigate().to("https://digitalss.test.accenture.com/innovation/main.html#/");
		Thread.sleep(10000);
		objUtility= new Utility();
		Reporter.log("Entering into the test execution",true);
	}

	
	//Raise 'Delivery Pride' request
	@Test(priority = 0)
	public void testDeliveryPride() throws Exception {

		// Call read file method of the class to read data
		// objExcelFile = new ExcelHelp(driver);
		// noOfRequests = objExcelFile.readExcel(filePath, "Sheet1", 1, 1);
		//noOfRequests = 1;
		//for(int i=0;i<noOfRequests;i++) {
		// Innovations home page
		objInnovationHomePage = new InnovationHomePage(driver);
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
		objInnovationHomePage.deliveryPrideBtn.click();
				
		Thread.sleep(10000);

		// Delivery Pride Page
		objDeliveryPridePage = new DeliveryPridePage(driver);

		objDeliveryPridePage.enterProjectName("Presto");

		objDeliveryPridePage.choosePrideType("Credential Video");

		objDeliveryPridePage.choosePrideOutcome();

		objDeliveryPridePage.chooseConfidentiality("Internal Use");

		Thread.sleep(10000);
		//Reporter.log("The file path for filePath2 is :" + filePath2, true);
		objDeliveryPridePage.chooseFile(filePath2);

		Thread.sleep(2000);

		objDeliveryPridePage.uploadBtn.click();
		Thread.sleep(20000);
		objUtility.screenshot(driver);
		objDeliveryPridePage.saveBtn.click();
		Thread.sleep(10000);
		objUtility.screenshot(driver);
		//Reporter.log("Executed testDeliveryPride for "+(i+1)+" times",true);
		//driver.get("https://digitalss.test.accenture.com/innovation/main.html#/");
		
		//Thread.sleep(5000);
		//}
	}

	
	//Raise 'client Co-Innovation' request
	@Test(priority = 1)
	public void testClientCoInnovation() throws Exception {

		//noOfRequests = 50;

		//for (int i = 0; i < 50; i++) {
			// Innovations home page
			objInnovationHomePage = new InnovationHomePage(driver);

			objInnovationHomePage.clientCoInnovationBtn.click();
			Thread.sleep(5000);

			// Client innovationsPage
			objclientCoInnovationPage = new clientCoInnovationPage(driver);

			objclientCoInnovationPage.enterProjectName("Presto");

			objclientCoInnovationPage.chooseIdeaSource("Workshop with client");

			objclientCoInnovationPage.chooseWorkShopType("For the Client");

			objclientCoInnovationPage.enterWorkShopDate("03/01/2018");

			objclientCoInnovationPage.chooseStatus("Idea Implemented");

			objclientCoInnovationPage.enterClientMembers("John, Smith");

			objclientCoInnovationPage.enterTopicOfDiscussion("TopicOfdiscussionName");

			objclientCoInnovationPage.enterIdeasGenerated("Ideas generated names");

			objclientCoInnovationPage.enterOutcome("OutcomeOfInnovation");

			objclientCoInnovationPage.enterIdeaTitle("Title of the Idea");

			objclientCoInnovationPage.selectIdeaOwner("sujay.kumar");

			objclientCoInnovationPage.enterNoOfIdeas("1");

			objclientCoInnovationPage.eligibleForCoiinovation("Yes");

			objclientCoInnovationPage.enterActivePursuit("Active pursuit");

			objclientCoInnovationPage.innovationWSclient("Yes");

			objclientCoInnovationPage.clientEndorsement("Yes");

			objclientCoInnovationPage.clientTestimony("Yes");
			
			objUtility.screenshot(driver);
			
			objclientCoInnovationPage.clickSave();

			Thread.sleep(10000);
			objUtility.screenshot(driver);
			//Reporter.log("Executed testClientCoInnovation for "+(i+1)+" times",true);
			//driver.get("https://digitalss.test.accenture.com/innovation/main.html#/");
			
			//Thread.sleep(5000);
		//}
	}

	
	//Raise 'Innovation Contest' request
	@Test(priority=2)
	public void testInnovationContest() throws Exception {

		//noOfRequests = 50;

		//for (int i = 0; i < noOfRequests; i++) {
			// Innovations home page
			objInnovationHomePage = new InnovationHomePage(driver);
			Thread.sleep(10000);
			objInnovationHomePage.innovationContestBtn.click();
			Thread.sleep(10000);

			// Innovation Contest Page

			objInnovationsContestPage = new InnovationContestPage(driver);

			objInnovationsContestPage.enterProjectName("Presto");

			objInnovationsContestPage.chooseContestType("Digi Shark");

			objInnovationsContestPage.enterTopic("Topic of the Innovation Contest");

			objInnovationsContestPage.enterNoOfIdeas("3");

			objInnovationsContestPage.enterNoOfParticipants("2");

			objInnovationsContestPage.enterNoOfIdeasFinalRound("2");

			objInnovationsContestPage.enterNoOfWinningIdeas("1");

			objInnovationsContestPage.enterNoOfPatentsFiled("1");

			objInnovationsContestPage.enterNoOfPatentsGranted("1");
			
			objUtility.screenshot(driver);
			
			objInnovationsContestPage.clickSave();

			Thread.sleep(10000);
			objUtility.screenshot(driver);
			//Reporter.log("Executed testInnovationContest for "+(i+1)+" times",true);
			//driver.get("https://digitalss.test.accenture.com/innovation/main.html#/");
			
			//Thread.sleep(5000);
		//}

	}

	
	//Raise 'Patent' request
	@Test(priority=3)
	public void testPatent() throws Exception {
 		
			
		//noOfRequests=50;

		//for (int i = 0; i < noOfRequests; i++) {
			// Innovations home page
			objInnovationHomePage = new InnovationHomePage(driver);
			Thread.sleep(10000);
			objInnovationHomePage.patentBtn.click();
			Thread.sleep(10000);
			
			//Generate String for current date
			objUtility = new Utility();
			dateStr = objUtility.dateString2();

			// Patent Page
			objPatentPage = new PatentPage(driver);

			objPatentPage.enterProjectName("Presto");

			objPatentPage.enterPatentTitle("Title of the Patent");

			objPatentPage.enterInvestorName("sujaykumar");

			objPatentPage.choosePatentType("Filed");
			
			objPatentPage.enterPatentNumber("PN"+dateStr);

			objPatentPage.enterFilingNumber("FN"+dateStr);

			objPatentPage.chooseFilingApproved("Yes");

			objPatentPage.enterFilingGeography("Asia-Pacific");

			objPatentPage.enterLegalAttorney("asgar");
			
			objUtility.screenshot(driver);
			
			objPatentPage.clickSave();

			Thread.sleep(10000);
			objUtility.screenshot(driver);
			//Reporter.log("Executed testPatent for "+(i+1)+" times",true);
			//driver.get("https://digitalss.test.accenture.com/innovation/main.html#/");
			
			//Thread.sleep(5000);
			
		//}

	}
	
	@Test
	public void testDesignerApproval() throws Exception {
		objInnovationHomePage = new InnovationHomePage(driver);
		objInnovationHomePage.selectAndEditDPRequest();
	}
	
	
	
	
	//@AfterClass
	public void afterExecution() throws Exception {
		
		objUtility.sendTestResults();
	}

}
