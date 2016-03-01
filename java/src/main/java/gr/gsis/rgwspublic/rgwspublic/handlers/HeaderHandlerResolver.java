package gr.gsis.rgwspublic.rgwspublic.handlers;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Soap header handler resolver
 */
public class HeaderHandlerResolver implements HandlerResolver {

    private String userName, password;

    public HeaderHandlerResolver(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlerChain = new ArrayList<Handler>();
        HeaderHandler hh = new HeaderHandler(userName, password);
        handlerChain.add(hh);

        return handlerChain;
    }
}