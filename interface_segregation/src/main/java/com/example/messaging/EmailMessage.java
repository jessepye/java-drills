package com.example.messaging;

import java.util.List;

public interface EmailMessage extends Message {
    public String getSubject();

    public void setSubject(String subject);

    public List<String> getBccAddresses();

    public void setBccAddresses(List<String> bccAddresses);

}
