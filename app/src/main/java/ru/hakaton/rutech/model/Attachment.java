package ru.hakaton.rutech.model;

/**
 * Вложение
 */
public class Attachment {

    private String url;
    private Type type;

    public enum Type {
        IMAGE,
        VIDEO,
        URL
    }
}