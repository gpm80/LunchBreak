package ru.hakaton.rutech.model;

/**
 * Комната
 */
public class Room implements Comparable<Room> {

    private String uid;
    private String title;
    private String description;
    private Type type;

    @Override
    public int compareTo(Room room) {
        // todo сортировка комнат по признаку, который придумаем (пока по названию)
        if (room == null) {
            return -1;
        }
        return getTitle().compareTo(room.getTitle());
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Тип комнаты
     */
    public enum Type {
        DEFAULT,
        ADMIN,
        USER
    }
}