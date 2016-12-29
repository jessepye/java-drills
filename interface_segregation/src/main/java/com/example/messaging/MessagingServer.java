package com.example.messaging;

public class MessagingServer {

    private static int msgCount = 0;

    public static boolean send(Message msg) {
        for (String address : msg.getToAddresses()) {
            System.out.println("Sent " + msg.getMessageBody() + " to " + address);
            msgCount++;
        }
        return true;
    }

    public static int getMsgCount() {
        return msgCount;
    }
}
