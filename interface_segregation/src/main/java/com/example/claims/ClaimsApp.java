package com.example.claims;

import com.example.messaging.MessagingServer;

import java.util.Arrays;

public class ClaimsApp {
    public static void main(String[] args) {
        String address = args[0];
        String amount = args[1];

        SmsMessage msg = new SmsMessage();
        msg.setToAddresses(Arrays.asList(address));
        msg.setMessageBody("Your claim for " + amount + " has been filed!");
        MessagingServer.send(msg);
    }
}
