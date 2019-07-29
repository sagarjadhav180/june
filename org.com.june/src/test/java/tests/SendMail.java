package tests;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	
	
	
	public static void execute(String reportFileName, int[] test_status_count) throws Exception

	{
	String pie_chart_link = Util.createpiechart(test_status_count[0],test_status_count[1], test_status_count[2]);
	String[] to={"sagar.j@moentek.com"};
	String[] cc={"sagar.jadhav180@gmail.com"};
	String[] bcc={""};

	String build_status = test_status_count[1] > 0? "<h1 style='color:red;font-family:sans-serif'> BUILD FAILURE </h1>" : "<h1 style='color:blue;font-family:sans-serif'> BUILD SUCCESS </h1>";
	String writer = "<!DOCTYPE html> <html> <head></head> <body> <p style='color:black;font-size:13px;font-family:sans-serif'>Hi All,<br><br> This is automated mail from QA Team. <br> Please find the attachment for the log result.</p>" + build_status + "<span style='color:black;font-size:13px;font-family:sans-serif'><b>Project:</b> CONVIRZA FOR ADVERTISERS</span><br> <span style='color:black;font-size:13px;font-family:sans-serif'><b>Date of build: </b>"+ new java.util.Date() +"</span><br> <b><span style='color:black;font-size:13px;font-family:sans-serif'> Number of Test Cases Failed: </span></b>" + test_status_count[1] + "<br> <b><span style='color:black;font-size:13px;font-family:sans-serif'> Number of Test Cases Passed: </span></b>" + test_status_count[0] + "<br> <b><span style='color:black;font-size:13px;font-family:sans-serif'> Number of Test Cases Skipped: </span></b>"+ test_status_count[2]+ "<br><br><br> <img src ="+ pie_chart_link +"/> <br/><br/> <b style='font-size:13.5px;font-family:open sans-serif;padding-left:5px'>Thanks,</b><br/> <b style='font-size:13.5px;font-family:open sans-serif;padding-left:5px'>QA Team</b><br/></body> </html>";
	sendMail("sagartest180@gmail.com",
	"sagar@123",
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
	"CFA API Automation Result",
	writer,
	"D:/Selenium/org.com.june/Extent.html",
	reportFileName
	);
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
	String attachmentName
	){

	//Object Instantiation of a properties file.
	Properties props = new Properties();

	props.put("mail.smtp.user", userName);

	props.put("mail.smtp.host", host);

	if(!"".equals(port)){
	props.put("mail.smtp.port", port);
	}

	if(!"".equals(starttls)){
	props.put("mail.smtp.starttls.enable",starttls);
	props.put("mail.smtp.auth", auth);
	}

	
	try{
		Session session = Session.getDefaultInstance(props, null);

		session.setDebug(debug);

		MimeMessage msg = new MimeMessage(session);
				
		
	
	
	
	
	
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

	


	msg.setText(text.toString(),"text/html");
	msg.setSubject(subject);

	Multipart mp = new MimeMultipart();
	MimeBodyPart messageBodyPart = new MimeBodyPart();
	messageBodyPart.setContent(text.toString(), "text/html");
	MimeBodyPart messageBodyPart1 = new MimeBodyPart();
	DataSource source = new FileDataSource(attachmentPath);
	messageBodyPart1.setDataHandler(new DataHandler(source));
	messageBodyPart1.setFileName(attachmentName);
	mp.addBodyPart(messageBodyPart);
	mp.addBodyPart(messageBodyPart1);
	msg.setContent(mp);
	msg.setFrom(new InternetAddress(userName));

	for(int i=0;i<to.length;i++){
	msg.addRecipient(Message.RecipientType.TO, new
	InternetAddress(to[i]));
	}

	for(int i=0;i<cc.length;i++){
	msg.addRecipient(Message.RecipientType.CC, new
	InternetAddress(cc[i]));
	}

	//for(int i=0;i<bcc.length;i++){
	//msg.addRecipient(Message.RecipientType.BCC, new
	//InternetAddress(bcc[i]));
	//}

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
	