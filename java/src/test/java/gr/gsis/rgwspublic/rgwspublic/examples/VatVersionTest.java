package gr.gsis.rgwspublic.rgwspublic.examples;

import gr.gsis.rgwspublic.rgwspublic.RgWsPublic_Service;
import junit.framework.Assert;
import org.junit.Test;


/**
 *
 */
public class VatVersionTest {

    @Test
    public void testVersion(){
        RgWsPublic_Service webService = new RgWsPublic_Service();
        String output = webService.getRgWsPublicPort().rgWsPublicVersionInfo();

        Assert.assertTrue("Copyright must contain string 'Copyright'", output.contains("Copyright"));
        Assert.assertTrue("Version must contain string 'Version'", output.contains("Version"));
    }
}