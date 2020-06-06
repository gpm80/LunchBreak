package ru.hakaton.rutech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.hakaton.rutech.model.Attachment;
import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.model.User;

/**
 * Сервис сообщений чата
 */
public class MessageService {

    private static MessageService instance;
    private static List<Message> defaultMessage;

    private final TreeMap<Room, List<Message>> roomMessageMap;

    private MessageService() {
        roomMessageMap = new TreeMap<>();
    }

    /**
     * Мапа с сообщеиями по комнатам.
     */

    public static MessageService get() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    public List<Message> getDefaultMessage(Room room) {
        defaultMessage = new ArrayList<>();
        defaultMessage.add(new Message(new User(), "Всем привет)))", null));
        defaultMessage.add(new Message(new User(), "Как дела, друзья??", null));
        defaultMessage.add(new Message(new User(), "ОГОНЬ, хакатон отличный!!", null));
        defaultMessage.add(new Message(new User(), "ВСЕМ УДАЧИ!!", null));
        roomMessageMap.put(room, defaultMessage);
        return roomMessageMap.get(room);
    }

    public Message send(Room room, Message message) {
        //TODO добавить сообщение в мапу ключ комната значение список сообщений есть ли такая комната
        if(room == null) {
            List<Message> list = new ArrayList<>();
            list.add(message);
            roomMessageMap.put(new Room(), list);
        } else  {
            List<Message> list = new ArrayList<>();
            list.add(message);
            roomMessageMap.put(room, list);
        }

        for(int i = 0; i < 3; i++) {
            List<Message> list = new ArrayList<>();
            list.add(new Message());
            roomMessageMap.put(room, list);
        }
        return message;
    }

    public List<Message> getAll(Room room) {
        //todo вернуть все сообщения в комнате из мапы
        roomMessageMap.get(room);
        if(roomMessageMap.get(room) == null) {
            return roomMessageMap.put(room, new ArrayList<Message>());
        }
        return roomMessageMap.get(room);
    }
}
