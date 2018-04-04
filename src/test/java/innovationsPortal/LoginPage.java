package innovationsPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	

	@FindBy(xpath = "//*[@id=\"userNameInput\"]")
	WebElement userName;

	@FindBy(xpath = "//*[@id=\"passwordInput\"]")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"submitButton\"]")
	WebElement submit;

	@FindBy(xpath = "//*[@id=\"vipOoblink\"]")
	WebElement securityCodeLink;

	@FindBy(xpath = "//*[@id=\"vipOobOptions\"]/label[2]")
	WebElement smsText;

	@FindBy(xpath = "//*[@id=\"vipSend\"]")
	WebElement sendBtn;

	@FindBy(xpath = "//*[@id=\"otpInput\"]")
	WebElement enterSecurityCodeField;

	@FindBy(xpath = "//*[@id=\"vipSubmitOTP\"]")
	WebElement continueBtn;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void confirmYourIdentity() throws Exception {

				// generate and send security code to mobile
			
			Thread.sleep(10000);
			securityCodeLink.click();
				Thread.sleep(1000);
				smsText.click();
				sendBtn.click();
				Thread.sleep(1000);
				/*
				// enter security code from the SMS
				// Pop-up to enter the security code
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.promptResponse=prompt('Please enter the security code')");
				// switch to alert
				Alert alert = driver.switchTo().alert();

				// sleep to allow user to input text
				Thread.sleep(30000);

				String securityCode = (String) js.executeScript("return window.promptResponse");
				alert.accept();
				Thread.sleep(1000);
				Reporter.log("You have entered the security code : "+securityCode,true);
				enterSecurityCodeField.sendKeys(securityCode);

				continueBtn.click();*/

				
	}

}
