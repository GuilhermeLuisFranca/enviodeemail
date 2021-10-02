package br.com.enviando_mail_TESTE;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import br.com.enviando_mail.ObjetoEnviaEmail;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@org.junit.Test
	public void testeEmail() throws Exception {

		try {
			
			for(int i = 0; i < 3; i++) {//ira enviar o email 3 vezes
			
			StringBuilder stringBuilderTextoEmail = new StringBuilder();
			
			//conteudo em html, dica, faca o documento em html no vscode copie-o coloque aspas dentro do append e cole que ira fazer a formatacao automaticamente
			stringBuilderTextoEmail.append("<h1 style=\"font-size: 60px; color: blue;\">I GOT A GUN</h1>\r\n"
					+ "    <br>\r\n"
					+ "    <a target=\"_blank\" href=\"http://weavesilk.com/\" style=\"text-decoration: none; font-size: 40px; color: rgb(2, 87, 87);\">LOL</a>\r\n"
					+ "    <br>\r\n"
					+ "    <p style=\"font-size: 10px; color: black; text-align: center;\">Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Sed porttitor lectus nibh. Proin eget tortor risus. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Sed porttitor lectus nibh. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Nulla quis lorem ut libero malesuada feugiat. Nulla porttitor accumsan tincidunt. Sed porttitor lectus nibh. Curabitur aliquet quam id dui posuere blandit. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Proin eget tortor risus. Pellentesque in ipsum id orci porta dapibus. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi.\r\n"
					+ "\r\n"
					+ "        Donec rutrum congue leo eget malesuada. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Pellentesque in ipsum id orci porta dapibus. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in ipsum id orci porta dapibus. Curabitur aliquet quam id dui posuere blandit. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Cras ultricies ligula sed magna dictum porta. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Donec sollicitudin molestie malesuada. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Nulla porttitor accumsan tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n"
					+ "        \r\n"
					+ "        Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Sed porttitor lectus nibh. Proin eget tortor risus. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo eget malesuada. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Proin eget tortor risus. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Proin eget tortor risus. Sed porttitor lectus nibh. Donec sollicitudin molestie malesuada. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Nulla quis lorem ut libero malesuada feugiat. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Proin eget tortor risus. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi.\r\n"
					+ "        \r\n"
					+ "        Vivamus suscipit tortor eget felis porttitor volutpat. Nulla quis lorem ut libero malesuada feugiat. Cras ultricies ligula sed magna dictum porta. Curabitur aliquet quam id dui posuere blandit. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Vivamus suscipit tortor eget felis porttitor volutpat. Donec sollicitudin molestie malesuada. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Donec sollicitudin molestie malesuada. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Nulla porttitor accumsan tincidunt. Pellentesque in ipsum id orci porta dapibus. Donec rutrum congue leo eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.\r\n"
					+ "        \r\n"
					+ "        Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Curabitur aliquet quam id dui posuere blandit. Vivamus suscipit tortor eget felis porttitor volutpat. Donec sollicitudin molestie malesuada. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Nulla quis lorem ut libero malesuada feugiat. Curabitur aliquet quam id dui posuere blandit. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Nulla porttitor accumsan tincidunt. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Nulla quis lorem ut libero malesuada feugiat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Nulla porttitor accumsan tincidunt. Pellentesque in ipsum id orci porta dapibus. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Nulla porttitor accumsan tincidunt.</p>\r\n"
					+ "" );
			
			//informacoes
			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("emailquerecebeaqui",//destinatario
					"seu nome",//nome remetente
					"Teste com JavaMail",//assunto do email
					stringBuilderTextoEmail.toString() + i);//texto do email
			
			enviaEmail.enviarEmailAnexo(true);//uso de html
			
			}
			////////////////////abaixo forma normal sem html, acima forma com html\\\\\\\\\\\\\\\\\\\\
			
			/*
			//informacoes
			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("elefantedapesada@gmail.com",//destinatario
					"Guilherme Luis",//nome remetente
					"Teste com JavaMail",//assunto do email
					"Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");//texto do email
			
			enviaEmail.enviarEmail(false);//nao uso de html
			*/
			
			/*Caso E-Mail n seja enviado coloque tempo de espera, (apenas para testes)
			 * Thread.sleep(5000);//5 SEGUNDOS
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
















/* / */