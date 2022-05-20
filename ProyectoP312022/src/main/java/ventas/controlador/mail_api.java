

package ventas.controlador;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Pablo
 */
public class mail_api {
     String host = "smtp.gmail.com";
    String sender = "G3Progra@gmail.com";
    String password = "la misma de siempre7";
    public void SendMailAPI(String to, String subject, String msg, String nombrec) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(msg);
 message.setContent(
              "    <section style=\"border:solid 4px rgb(246, 57, 0); margin-left: 20%; margin-right: 20%; border-top:0; margin-bottom: 0;\">\n" +
"            <div style=\"background-color: rgb(237, 121, 121);\">\n" +
"                <h1 style=\"text-shadow: 3px 5px 5px rgb(7, 6, 1); font-family: 'comic sans MS'; color: white; margin-bottom: 0; background-color: rgb(235, 78, 78); text-align: center; height: 50px; padding-top: 15px; margin-left: 20%; margin-right: 20%;\"> Orden de Compra</h1>\n" +
"            </div>\n" +
"            <div style=\"background-color: rgba(237, 121, 121, 0.4);\">\n" +
"\n" +
"\n" +
"            <h2 style=\" color: rgb(139, 18, 57); margin: 0;\">Estimado(a) Cliente: "+nombrec+"</h2>\n" +
"            <p style=\"font-size: 20px; font-family: 'comic sans MS';    \">Esperamos que vuelva pronto, es un gusto atenderle</p>\n" +
"            <p style=\"font-size: 20px; font-family: 'comic sans MS';\">Gracias por escogernos como tu opcion</p>\n" +
"            <p style=\"font-size: 20px; font-family: 'comic sans MS'; margin-bottom: 0;\">Saludos Cordiales: <span style=\"font-weight: bold; font-size: 20px;\">GrupoG3</span></p>\n" +
"        </div>\n" +
"        </section>",
             "text/html");
            Transport.send(message);
            System.out.println("Message Sent");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
