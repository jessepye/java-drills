package com.example.claims;

import com.example.messaging.Message;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class SmsMessage implements Message {
    public List<String> toAddresses;
    public String messageBody;

    @Override
    public List<String> getToAddresses() {
        return toAddresses;
    }

    @Override
    public void setToAddresses(List<String> toAddresses) {
        this.toAddresses = toAddresses;
    }

    @Override
    public String getMessageBody() {
        return messageBody;
    }

    @Override
    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getSubject() {
        throw new NotImplementedException();
    }

}
