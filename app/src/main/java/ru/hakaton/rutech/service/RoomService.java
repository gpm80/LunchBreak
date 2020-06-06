package ru.hakaton.rutech.service;

import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Сервис комнат
 */
public class RoomService {

    private static RoomService instance;
    private static List<Room> defaultRooms;

    {
        defaultRooms = new ArrayList<>();
        defaultRooms.add(new Room().initTest("Обо Всем для Всех", "обсуждаем повестку дня", Room.Type.DEFAULT));
        defaultRooms.add(new Room().initTest("Пошли мы в баню", "парилка с огоньком", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Знакомства", "узнаЁм друг друга", Room.Type.USER));
    }

    public static RoomService get() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    public List<Room> getAll(User user) {
        //todo
        return new ArrayList<>(defaultRooms);
    }

    public Room create(User user, String title, String descr) {
        // todo
        Room r = new Room();
        r.setUid(UUID.randomUUID().toString());
        r.setType(Room.Type.DEFAULT);
        r.setTitle(title);
        r.setDescription(descr);
        return r;
    }

    /**
     * Возвращает комнату по ID
     *
     * @param user    пользователь
     * @param uidRoom id комнаты
     * @return
     */
    public Room getRoomById(User user, String uidRoom) {
        List<Room> allRoom = getAll(user);
        int i = allRoom.indexOf(new Room(uidRoom));
        if (i < 0) {
            return null;
        }
        return allRoom.get(i);
    }
}
