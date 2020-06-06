package ru.hakaton.rutech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.Room;

public class VIPService {

    private static VIPService vipKey;
    /**
     * Мапа с сообщеиями по комнатам.
     */
    private final TreeMap<Room, List<Message>> vipRoomMessageMap;

    private VIPService() {
        vipRoomMessageMap = new TreeMap<>();
    }

    public static VIPService get() {
        if (vipKey == null) {
            vipKey = new VIPService();
        }
        return vipKey;
    }

    public Message send(Room room, Message message) {
        //TODO добавить сообщение в мапу ключ комната значение список сообщений есть ли такая комната
        if(room == null) {
            List<Message> list = new ArrayList<>();
            list.add(message);
            vipRoomMessageMap.put(new Room(), list);
        } else  {
            List<Message> list = new ArrayList<>();
            list.add(message);
            vipRoomMessageMap.put(room, list);
        }

        for(int i = 0; i < 3; i++) {
            List<Message> list = new ArrayList<>();
            list.add(new Message());
            vipRoomMessageMap.put(room, list);
        }
        return message;
    }

    public List<Message> getAll(Room room) {
        //todo вернуть все сообщения в комнате из мапы
        vipRoomMessageMap.get(room);
        if(vipRoomMessageMap.get(room) == null) {
            return vipRoomMessageMap.put(room, new ArrayList<Message>());
        }
        return vipRoomMessageMap.get(room);
    }
}
