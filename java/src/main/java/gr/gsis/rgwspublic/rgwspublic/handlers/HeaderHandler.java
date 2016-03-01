package gr.gsis.rgwspublic.rgwspublic.handlers;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Soap Header handler to ingest username / password
 *
 * Inspired from http://www.javadb.com/using-a-message-handler-to-alter-the-soap-header-in-a-web-service-client/
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    private String userName, pwd;

    public HeaderHandler(String username, String password){
        this.userName = username;
        this.pwd = password;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
            try {

                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.addHeader();

                SOAPElement security =
                        header.addChildElement("Security", "ns1", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

                SOAPElement usernameToken =
                        security.addChildElement("UsernameToken", "ns1");
                usernameToken.addAttribute(new QName("xmlns:ns1"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

                SOAPElement username =
                        usernameToken.addChildElement("Username", "ns1");
                username.addTextNode(userName);

                SOAPElement password =
                        usernameToken.addChildElement("Password", "ns1");
                password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                password.addTextNode(pwd);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // Put you response handler here
        }
        return outboundProperty;
    }

    public Set<QName> getHeaders() {
        // throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    public boolean handleFault(SOAPMessageContext context) {
        // throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    public void close(MessageContext context) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}