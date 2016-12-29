package com.example.billing;

import com.example.messaging.MessagingServer;

import java.util.Arrays;

public class BillingApp {
    public static void main(String[] args) {
        String toAddress = args[0];
        String amount = args[1];
        String bccAddress = args[2];
        String subject = "Your bill is due!";

        SmtpMessage msg = new SmtpMessage();
        msg.setToAddresses(Arrays.asList(toAddress));
        msg.setBccAddresses(Arrays.asList(bccAddress));
        msg.setSubject(subject);
        msg.setMessageBody("Your bill for " + amount + " is due!");
        MessagingServer.send(msg);
    }
}
