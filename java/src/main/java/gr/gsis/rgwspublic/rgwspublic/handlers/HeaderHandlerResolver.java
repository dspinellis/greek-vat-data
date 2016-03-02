package gr.gsis.rgwspublic.rgwspublic.handlers;

/*
#
# Request details for a VAT from the GSIS SOAP web service
#
# Copyright 2016 Anastasios Zouzias
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#
*/

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