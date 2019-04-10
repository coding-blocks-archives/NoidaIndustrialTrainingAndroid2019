package com.codingblocks.heterogeneousrecyclerview;

public class WhatsappMessage {

    private String message, time;
    private MessageType typeOfMessage;

    public WhatsappMessage(String message, String time, MessageType typeOfMessage) {
        this.message = message;
        this.time = time;
        this.typeOfMessage = typeOfMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public MessageType getTypeOfMessage() {
        return typeOfMessage;
    }
}
