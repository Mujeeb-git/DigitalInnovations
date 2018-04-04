package innovationsPortal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class InnovationHomePage {

	
	WebDriver driver;
	int noOfDPRequest;
	
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Delivery Pride')]")
	WebElement deliveryPrideBtn;
	
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Client Co-Innovation')]")
	WebElement clientCoInnovationBtn;
		
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Innovation Contest')]")
	WebElement innovationContestBtn;
	
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Patent')]")
	WebElement patentBtn;
	
	@FindBy(xpath = "*//div/div[3]/div/div[2]/ul/li[2]/a")
	WebElement innovationsTab;
	
	@FindBy(xpath = "*//div/div[3]/div/div[2]/ul/li[3]/a")
	WebElement pendingApprovalsTab;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[1]/div[1]")
	WebElement expandDeliveryPride;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[3]/div[1]/div[1]")
	WebElement expandDeliveryPride2;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[3]/div[2]/div/div[1]")
	WebElement expandDeliveryPride3;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]")
	WebElement expandDeliveryPride4;
	
	@FindBys(@FindBy(xpath="//*[@id=\"projectListTable\"]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div"))
	List<WebElement> deliveryPrideRequestList;

	
	
	
	
	//@FindBy(xpath = requestXpath)
	//WebElement editDPRequestBtn;
	
	public void selectAndEditDPRequest() throws Exception {
		
		expandDeliveryPride.click();
		Thread.sleep(1000);
		expandDeliveryPride2.click();
		Thread.sleep(1000);
		expandDeliveryPride3.click();
		Thread.sleep(1000);
		expandDeliveryPride4.click();
		Thread.sleep(5000);
		noOfDPRequest = deliveryPrideRequestList.size()-1;
		String requestXpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div["+noOfDPRequest+"]/div[5]/span";
		Reporter.log("The number of Delivery Pride requests is: "+(noOfDPRequest+1),true);
		driver.findElement(By.xpath(requestXpath)).click();
			
	}
	
		
	

	public InnovationHomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	
}