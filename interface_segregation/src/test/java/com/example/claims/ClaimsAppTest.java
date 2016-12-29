package com.example.claims;

import com.example.billing.BillingApp;
import com.example.messaging.MessagingServer;
import org.junit.Assert;
import org.junit.Test;

public class ClaimsAppTest {
    @Test
    public void testTheApp() {
        int oldCount = MessagingServer.getMsgCount();
        ClaimsApp.main(new String[] {"800-555-1212", "$100"});
        int newCount = MessagingServer.getMsgCount();
        Assert.assertTrue("One message was sent", newCount == oldCount + 1);
    }
}
