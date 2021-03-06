package ru.hakaton.rutech.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Комната
 */
public class Room implements Comparable<Room> {

    private String uid;
    private String title;
    private String description;
    private Type type;

    public Room() {
    }

    public Room(String uid) {
        this.uid = uid;
    }

    public Room initTest(String title, String description, Type type) {
        uid = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.type = type;
        return this;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(uid, room.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
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
