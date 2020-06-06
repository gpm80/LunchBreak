package ru.hakaton.rutech.model;

/**
 * Пользователь
 */
public class User {

    private String uid;
    private String name;
    private String about;
    private Attachment avatar;

    /**
     * Тип пользователя
     */
    public enum Type {
        /**
         * Организатор
         */
        ORGANIZER,
        /**
         * Слушатель
         */
        LISTENER,
        /**
         * Спикер
         */
        SPEAKER
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Attachment getAvatar() {
        return avatar;
    }

    public void setAvatar(Attachment avatar) {
        this.avatar = avatar;
    }
}
