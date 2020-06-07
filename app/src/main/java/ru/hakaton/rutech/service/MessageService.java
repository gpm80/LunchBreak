package ru.hakaton.rutech.service;

import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Сервис сообщений чата
 */
public class MessageService {

    private static MessageService instance;
    private static List<Message> defaultMessage;
    private static List<List<Message>> defaultListMessage;
    private static List<List<Message>> allDefaultListMessage;
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

    public static List<List<Message>> getAllDefaultListMessage(int id) {
        allDefaultListMessage = new ArrayList<>();
        switch (id) {
            case 0:
                allDefaultListMessage.add(defaultListMessage.get(0));
                break;
            case 1:
                allDefaultListMessage.add(defaultListMessage.get(1));
                break;
            case 2:
                allDefaultListMessage.add(defaultListMessage.get(2));
                break;
            case 3:
                allDefaultListMessage.add(defaultListMessage.get(3));
                break;
            case 4:
                allDefaultListMessage.add(defaultListMessage.get(4));
                break;
        }
        return allDefaultListMessage;
    }

    public static void setDefaultListMessage() {
        defaultListMessage = new ArrayList<>();
        defaultListMessage.add(getDefaultMessageFirst());
        defaultListMessage.add(getDefaultMessageSecond());
        defaultListMessage.add(getDefaultMessageThird());
        defaultListMessage.add(getDefaultMessageFourth());
        defaultListMessage.add(getDefaultMessageFifth());
    }

    public static List<Message> getDefaultMessageFirst() {
        defaultMessage = new ArrayList<>();
        defaultMessage.add(new Message(new User(), "Всем привет)))", null));
        defaultMessage.add(new Message(new User(), "Как дела, друзья??", null));
        defaultMessage.add(new Message(new User(), "ОГОНЬ, хакатон отличный!!", null));
        defaultMessage.add(new Message(new User(), "ВСЕМ УДАЧИ!!", null));
        return defaultMessage;
    }

    public static List<Message> getDefaultMessageSecond() {
        defaultMessage = new ArrayList<>();
        defaultMessage.add(new Message(new User(), "Светит солнце, как приятно)))", null));
        defaultMessage.add(new Message(new User(), "Что нового, друзья???", null));
        defaultMessage.add(new Message(new User(), "Лучший хактон!!", null));
        defaultMessage.add(new Message(new User(), "Умейте прощать)", null));
        return defaultMessage;
    }

    public static List<Message> getDefaultMessageThird() {
        defaultMessage = new ArrayList<>();
        defaultMessage.add(new Message(new User(), "Расскажим о себе, я Леша, я пока никто)", null));
        defaultMessage.add(new Message(new User(), "Я Саша, четкий прогрммист", null));
        defaultMessage.add(new Message(new User(), "Я Света, дизайнер от бога!!", null));
        defaultMessage.add(new Message(new User(), "А я Фёдор, я очень крутой хакатонщик:)", null));
        return defaultMessage;
    }

    public static List<Message> getDefaultMessageFourth() {
        defaultMessage = new ArrayList<>();
        defaultMessage.add(new Message(new User(), "Расскажите о конференции)))", null));
        defaultMessage.add(new Message(new User(), "Стоит ли на нее идти?", null));
        defaultMessage.add(new Message(new User(), "Конференция - ОГОНЬ!!", null));
        defaultMessage.add(new Message(new User(), "ВСЕМ УДАЧИ!!", null));
        return defaultMessage;
    }

    public static List<Message> getDefaultMessageFifth() {
        defaultMessage = new ArrayList<>();
        defaultMessage.add(new Message(new User(), "Всем мира, как дела?)", null));
        defaultMessage.add(new Message(new User(), "Мы победили хакатон...!!!", null));
        defaultMessage.add(new Message(new User(), "А что вы за команда?", null));
        defaultMessage.add(new Message(new User(), "it-lab", null));
        return defaultMessage;
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
