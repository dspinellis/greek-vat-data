package gr.gsis.rgwspublic.rgwspublic.examples;

import gr.gsis.rgwspublic.rgwspublic.RgWsPublic_Service;

/**
 * Example consuming the VAT information
 */
public class VatVersion {

    public static void main(String[] args) throws Exception {
        RgWsPublic_Service webService = new RgWsPublic_Service();
        System.out.println(webService.getRgWsPublicPort().rgWsPublicVersionInfo());
    }
}
