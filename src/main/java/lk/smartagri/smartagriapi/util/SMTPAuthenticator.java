package lk.smartagri.smartagriapi.util;

import org.springframework.stereotype.Component;

import javax.mail.PasswordAuthentication;


@Component
public class SMTPAuthenticator extends javax.mail.Authenticator{

    private final String senderEmailId="pdilminvirtusa@gmail.com";
    // TODO: 5/25/2022  please make sure turn on google account less secure app access
    private final String senderPassword="NSHack285$";//put your gmail password here

    public PasswordAuthentication getPasswordAuthentication() {
        System.out.println(senderEmailId);
        return new PasswordAuthentication(senderEmailId,
                senderPassword);
    }

}