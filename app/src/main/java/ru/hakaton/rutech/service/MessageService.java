package ru.hakaton.rutech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.Room;

/**
 * Сервис сообщений чата
 */
public class MessageService {

    private static MessageService instance;
    /**
     * Мапа с сообщеиями по комнатам.
     */
    private final TreeMap<Room, List<Message>> roomMessageMap;

    private MessageService() {
        roomMessageMap = new TreeMap<>();
    }

    public static MessageService get() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    public Message send(Room room, Message message) {
        List<Message> allMessages = getAll(room);
        allMessages.add(message);
        return message;
    }

    public List<Message> getAll(Room room) {
        List<Message> messages = roomMessageMap.get(room);
        if (messages == null) {
            roomMessageMap.put(room, new ArrayList<Message>());
        }
        return roomMessageMap.get(room);
    }

}
