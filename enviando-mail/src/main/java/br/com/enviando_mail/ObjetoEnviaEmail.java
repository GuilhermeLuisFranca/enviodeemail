package br.com.enviando_mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ObjetoEnviaEmail {

	private String userName = "seuemailqueusaraparaenviar";
	private String senha = "suasenhadoemail";

	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	public void enviarEmail(boolean envioHtml) throws Exception {
		
		// olhe as configuracoes smtp do seu email
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust", "*");//authentica seguranca ssl
		properties.put("mail.smtp.auth", "true");// autorizacao
		properties.put("mail.smtp.auth", "true");// autorizacao
		properties.put("mail.smtp.starttls", "true");// authenticacao
		properties.put("mail.smtp.host", "smtp.gmail.com");// servidor gmail google
		properties.put("mail.smtp.port", "465");// porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465");// especifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de conexao ao smtp

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));//quem esta enviando
		message.setRecipients(Message.RecipientType.TO, toUser);//email de destino
		message.setSubject(assuntoEmail);//assunto do email
		
		if(envioHtml) {
			message.setContent(textoEmail, "text/html; charset=UTF-8;");
		} else {
			message.setText(textoEmail);
		}
		
		Transport.send(message);
		
	}
	
	public void enviarEmailAnexo(boolean envioHtml) throws Exception {
		
		// olhe as configuracoes smtp do seu email
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust", "*");//authentica seguranca ssl
		properties.put("mail.smtp.auth", "true");// autorizacao
		properties.put("mail.smtp.auth", "true");// autorizacao
		properties.put("mail.smtp.starttls", "true");// authenticacao
		properties.put("mail.smtp.host", "smtp.gmail.com");// servidor gmail google
		properties.put("mail.smtp.port", "465");// porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465");// especifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de conexao ao smtp

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));//quem esta enviando
		message.setRecipients(Message.RecipientType.TO, toUser);//email de destino
		message.setSubject(assuntoEmail);//assunto do emai
		
		//parte 1 do email que e texto e a descricao do email
		MimeBodyPart corpoEmail = new MimeBodyPart();
		
		if(envioHtml) {
			corpoEmail.setContent(textoEmail, "text/html; charset=UTF-8;");
		} else {
			corpoEmail.setText(textoEmail);
		}
		
		List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
		arquivos.add(simuladorDePDF());
		arquivos.add(simuladorDePDF());
		arquivos.add(simuladorDePDF());
		arquivos.add(simuladorDePDF());
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
		
		int index = 0;
		for(FileInputStream fileInputStream : arquivos) {
			
			//parte 2 do email que sao os anexo em pdf
			MimeBodyPart anexoEmail = new MimeBodyPart();
			
			//onde e passado o simulador de pdf voce passa seu arquivo gravado no banco de dados
			anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream, "application/pdf")));
			anexoEmail.setFileName("anexoemail"+index+".pdf");
			
			
			multipart.addBodyPart(anexoEmail);
		
			index++;
		}
		
		message.setContent(multipart);
		
		Transport.send(message);
		
	}

	/**
	* esse metodo simula o PDF ou qualquer arquivo que possa ser enviado por anexo no email
	* voce pode pegar o arquivo no banco de dados base64, um byte, Stream de arquivos
	* pode estar em um banco de dados uma pasta etc...
	* 
	* retorna um pdf em branco com o texto do paragrafo de exemplo
	*/
	private FileInputStream simuladorDePDF() throws Exception {
		
		Document document = new Document();
		File file = new File("fileanexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("conteudo do pdf anexo com JavaMail, esse texto e do PDF"));
		document.close();
		
		return new FileInputStream(file);
		
		
	}
	
}







/*/*/