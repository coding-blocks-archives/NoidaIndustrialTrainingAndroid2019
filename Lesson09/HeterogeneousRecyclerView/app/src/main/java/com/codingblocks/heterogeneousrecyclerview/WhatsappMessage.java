package com.codingblocks.heterogeneousrecyclerview;

public class WhatsappMessage {

    private String message, time;
    private Boolean isRead, isDelivered;
    private MessageType typeOfMessage;

    public WhatsappMessage(String message, String time, Boolean isRead, Boolean isDelivered, MessageType typeOfMessage) {
        this.message = message;
        this.time = time;
        this.isRead = isRead;
        this.isDelivered = isDelivered;
        this.typeOfMessage = typeOfMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public Boolean getRead() {
        return isRead;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public MessageType getTypeOfMessage() {
        return typeOfMessage;
    }
}
