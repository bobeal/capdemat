package fr.cg95.cvq.external;

import static org.junit.Assert.fail;

import org.junit.Test;

public class ExternalServiceGeneralTest extends ExternalServiceTestCase {

    @Test
    public void testAuthenticate() {
        boolean authenticated =
            externalService.authenticate(fakeExternalService.getLabel(), "12345678");
        if (!authenticated)
            fail("authentication failed for fake external service");
        authenticated = externalService.authenticate(fakeExternalService.getLabel(), "blop");
        if (authenticated)
            fail("authentication should have failed !");
    }
}
