package gr.gsis.rgwspublic.rgwspublic.examples;

import gr.gsis.rgwspublic.rgwspublic.*;
import gr.gsis.rgwspublic.rgwspublic.handlers.HeaderHandlerResolver;
import javax.xml.ws.Holder;
import java.math.BigDecimal;

/**
 * VAT details
 */
public class VatDetails {

    public static void main(String[] args) throws Exception {

        if (args.length != 4){
            System.err.println("Usage: mvn exec:java -Pvat_details \"username password requester-VAT query-VAT\"");
            return;
        }

        String userName = args[0],password = args[1], vatBy = args[2], vatFor = args[3];

        // SOAP web service
        RgWsPublic_Service webService = new RgWsPublic_Service();

        // Setup the head handler to inject the username/password
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver(userName, password);
        webService.setHandlerResolver(handlerResolver);

        // Inject VAT by and from parameters
        RgWsPublicInputRtUser user = new RgWsPublicInputRtUser();
        user.setAfmCalledBy(vatBy);
        user.setAfmCalledFor(vatFor);

        // Setup all other input parameters to empty
        RgWsPublicBasicRtUser basicUser = new RgWsPublicBasicRtUser();
        Holder<RgWsPublicBasicRtUser> rgWsPublicBasicRtOut = new Holder<RgWsPublicBasicRtUser>(basicUser);
        RgWsPublicFirmActRtUserArray array = new RgWsPublicFirmActRtUserArray();
        Holder<RgWsPublicFirmActRtUserArray> arrayOfRgWsPublicFirmActRtOut = new Holder<RgWsPublicFirmActRtUserArray>(array);
        BigDecimal value = new BigDecimal(0);
        Holder<BigDecimal> pCallSeqIdOut = new Holder<BigDecimal>(value);
        GenWsErrorRtUser genUser = new GenWsErrorRtUser();
        Holder<GenWsErrorRtUser> pErrorRecOut = new Holder<GenWsErrorRtUser>(genUser);

        webService.getRgWsPublicPort().rgWsPublicAfmMethod(user,rgWsPublicBasicRtOut, arrayOfRgWsPublicFirmActRtOut, pCallSeqIdOut, pErrorRecOut);

        System.out.println("A.F.M : " + rgWsPublicBasicRtOut.value.getAfm());
        System.out.println("Title : " + rgWsPublicBasicRtOut.value.getCommerTitle());
        System.out.println("Onomasia : " + rgWsPublicBasicRtOut.value.getOnomasia());
        System.out.println("Registration date : " + rgWsPublicBasicRtOut.value.getRegistDate());
        System.out.println("Activate flag? : " + rgWsPublicBasicRtOut.value.getDeactivationFlag());
        System.out.println("Activate? : " + rgWsPublicBasicRtOut.value.getDeactivationFlagDescr());
        System.out.println("D.O.Y. : " + rgWsPublicBasicRtOut.value.getDoy());
        System.out.println("D.O.Y. Description : " + rgWsPublicBasicRtOut.value.getDoyDescr());
        System.out.println("Postal Address : " + rgWsPublicBasicRtOut.value.getPostalAddress());
    }
}
