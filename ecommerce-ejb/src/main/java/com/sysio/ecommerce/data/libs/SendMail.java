package com.sysio.ecommerce.data.libs;

import com.sysio.ecommerce.data.entity.Pedidos;
import com.sysio.ecommerce.data.entity.UsuarioRol;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class SendMail {

    @Resource(lookup = "mailSession")
    private Session mailSession;

    private Properties prop;

    public SendMail() {
        String propFileName = "templates.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop = new Properties();
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception ex) {
        }
    }

    public void sendStatusProducto(Pedidos pedidos) {
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
            InternetAddress[] address = {new InternetAddress(pedidos.getIdUsuario().getUsuario())};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject("Actualizacion de Pedido");
            message.setSentDate(new Date());
            message.setContent(changeVariable(pedidos), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    private String changeVariable(Pedidos pedidos) {
        String body = prop.getProperty("template.actualizacion.estatus");
        body = body.replace("%USUARIO%", pedidos.getIdUsuario().getDatosUsuario().getNombre() + " " + pedidos.getIdUsuario().getDatosUsuario().getApellidoPaterno() + " " + pedidos.getIdUsuario().getDatosUsuario().getApellidoMaterno());
        body = body.replace("%PEDIDO%", String.valueOf(pedidos.getIdPedido()));
        body = body.replace("%STATUS%", pedidos.getIdStatus().getEstatus());
        return body;
    }

    public void sendActivateUser(UsuarioRol user) {
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
            InternetAddress[] address = {new InternetAddress(user.getUsuarios().getUsuario())};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject("Activación de usuario");
            message.setSentDate(new Date());
            message.setContent(changeVariable(user), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    private String changeVariable(UsuarioRol user) {
        String body = prop.getProperty("template.registro.usuario");
        body = body.replace("%CORREO%", user.getUsuarios().getUsuario());
        return body;
    }

}
