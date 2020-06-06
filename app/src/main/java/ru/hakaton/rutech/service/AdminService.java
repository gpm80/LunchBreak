package ru.hakaton.rutech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.Room;

public class AdminService {

    private static AdminService vipKey;
    /**
     * Мапа с сообщеиями по комнатам.
     */
    private final TreeMap<Room, List<Message>> adminRoomMessageMap;

    private AdminService() {
        adminRoomMessageMap = new TreeMap<>();
    }

    public static AdminService get() {
        if (vipKey == null) {
            vipKey = new AdminService();
        }
        return vipKey;
    }

    public Message send(Room room, Message message) {
        //TODO добавить сообщение в мапу ключ комната значение список сообщений есть ли такая комната
        if(room == null) {
            List<Message> list = new ArrayList<>();
            list.add(message);
            adminRoomMessageMap.put(new Room(), list);
        } else  {
            List<Message> list = new ArrayList<>();
            list.add(message);
            adminRoomMessageMap.put(room, list);
        }

        for(int i = 0; i < 3; i++) {
            List<Message> list = new ArrayList<>();
            list.add(new Message());
            adminRoomMessageMap.put(room, list);
        }
        return message;
    }

    public List<Message> getAll(Room room) {
        //todo вернуть все сообщения в комнате из мапы
        adminRoomMessageMap.get(room);
        if(adminRoomMessageMap.get(room) == null) {
            return adminRoomMessageMap.put(room, new ArrayList<Message>());
        }
        return adminRoomMessageMap.get(room);
    }
}
