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
        /*defaultRooms.add(new Room().initTest("Обо Всём для Всех",
                "Привет, заходи к нам!" +
                        "\nМы обсуждаем кейсы, спикеров и организаторов." +
                        "\nДелимся впечатлениями и своим настроением." +
                        "\nРассказыаем о себе и о других" +
                        "\nРазговоры обо всем и не о чем" +
                        "\n\nЗаходите будем рады",
                Room.Type.DEFAULT));
        defaultRooms.add(new Room().initTest("Выступление Билла Гейтса", "парилка с огоньком", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Ищем разработчиков Java", "парилка с огоньком", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Пошли ка мы в караоке", "парилка с огоньком", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Кто учавствует в следующей конференции", "парилка с огоньком", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Знакомства", "узнаЁм друг друга", Room.Type.USER));*/
        defaultRooms.add(new Room().initTest("Обо Всём для Всех",
                "34/100",
                Room.Type.DEFAULT));
        defaultRooms.add(new Room().initTest("Выступление Билла Гейтса", "46/100", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Ищем разработчиков Java", "15/100", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Пошли ка мы в караоке", "99/100", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Кто учавствует в следующей конференции", "54/100", Room.Type.ADMIN));
        defaultRooms.add(new Room().initTest("Знакомства", "23/100", Room.Type.USER));
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
