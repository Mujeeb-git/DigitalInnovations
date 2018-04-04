package innovationsPortal;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class Utility {
	String d,dateMonth;
	public String dateString() {
		//Date to String
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		d = dateFormat.format(date);
		//Reporter.log("The current date is "+d,true);
		return d;
			
	}
	public String dateString2() {
		//Date to String
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		d = dateFormat.format(date);
		//Reporter.log("The current date is "+d,true);
		return d;
			
	}
	public void screenshot(WebDriver driver) {
	//get current date time in string format
	d = dateString();
	dateMonth = d.substring(5, 10);
	// Take screenshot and store as a file format
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	 // now copy the  screenshot to desired location using copyFile //method
	FileUtils.copyFile(src, new File("C:\\Mujeeb\\Screenshots\\"+dateMonth+"\\Screenshot_"+d+".png"));
	}
	 
	catch (IOException e)
	 {
	  System.out.println(e.getMessage());
	 
	 }
}
	
	
	//Send test output results
	
	public void sendTestResults() throws Exception

	{
	 String path="C:\\Users\\mujeeb.mohammed\\eclipse-workspace\\Innovation\\test-output";

	String[] to={"mujeeb.mohammed@accenture.com","md.mujeeb007@gmail.com"};
	 String[] cc={};
	 String[] bcc={};

	Utility.sendMail("md.mujeeb007@gmail.com",
	 "Jasmin@7",
	 "smtp.gmail.com",
	 "465",
	 "true",
	 "true",
	 true,
	 "javax.net.ssl.SSLSocketFactory",
	 "false",
	 to,
	 cc,
	 bcc,
	 "Automation Test Results",
	 "Hi Automation Lead,"+"\n"+"Please find the attached Test Results report",
	 path,
	 "index.html");
	 }
	
	public static boolean sendMail(String userName,
			 String passWord,
			 String host,
			 String port,
			 String starttls,
			 String auth,
			 boolean debug,
			 String socketFactoryClass,
			 String fallback,
			 String[] to,
			 String[] cc,
			 String[] bcc,
			 String subject,
			 String text,
			 String attachmentPath,
			 String attachmentName){

			//Object Instantiation of a properties file.
			 Properties props = new Properties();

			props.put("mail.smtp.user", userName);

			props.put("mail.smtp.host", host);

			if(!"".equals(port)){
			 props.put("mail.smtp.port", port);
			 }

			if(!"".equals(starttls)){
			// props.put("mail.smtp.starttls.enable",starttls);
			 props.put("mail.smtp.auth", auth);
			 }

			if(debug){

			props.put("mail.smtp.debug", "true");

			}else{

			props.put("mail.smtp.debug", "false");

			}

			if(!"".equals(port)){
			 props.put("mail.smtp.socketFactory.port", port);
			 }
			 if(!"".equals(socketFactoryClass)){
			 props.put("mail.smtp.socketFactory.class",socketFactoryClass);
			 }
			 if(!"".equals(fallback)){
			 props.put("mail.smtp.socketFactory.fallback", fallback);
			 }

			try{

			Session session = Session.getDefaultInstance(props, null);

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setText(text);

			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			 MimeBodyPart messageBodyPart = new MimeBodyPart();
			 DataSource source = new FileDataSource(attachmentPath);
			 messageBodyPart.setDataHandler(new DataHandler(source));
			 messageBodyPart.setFileName(attachmentName);
			 multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			 msg.setFrom(new InternetAddress(userName));

			for(int i=0;i<to.length;i++){
			 msg.addRecipient(Message.RecipientType.TO, new
			 InternetAddress(to[i]));
			 }

			for(int i=0;i<cc.length;i++){
			 msg.addRecipient(Message.RecipientType.CC, new
			 InternetAddress(cc[i]));
			 }

			for(int i=0;i<bcc.length;i++){
			 msg.addRecipient(Message.RecipientType.BCC, new
			 InternetAddress(bcc[i]));
			 }

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

			} catch (Exception mex){
			 mex.printStackTrace();
			 return false;
			 }
			 }

}
