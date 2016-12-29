package com.example.billing;

import com.example.messaging.MessagingServer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class BillingAppTest {
    @Test
    public void testTheApp() {
        int oldCount = MessagingServer.getMsgCount();
        BillingApp.main(new String[] {"bob@example.com", "$100", "billing@example.com"});
        int newCount = MessagingServer.getMsgCount();
        Assert.assertTrue("One message was sent", newCount == oldCount + 1);
    }
}
