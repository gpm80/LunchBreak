package ru.hakaton.rutech.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Сообщение
 */
public class Message {

    private User parent;
    private String message;
    private List<Attachment> attachments;

    public Message() {
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Attachment> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}