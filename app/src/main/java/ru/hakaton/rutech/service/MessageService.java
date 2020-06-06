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
    private static List<List<Message>> defaultListMessage;

    private final TreeMap<Room, List<Message>> roomMessageMap;

    public MessageService() {
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

    public static List<List<Message>> getDefaultListMessage() {
        defaultListMessage.add(getDefaultMessageFirst());
        defaultListMessage.add(getDefaultMessageSecond());
        defaultListMessage.add(getDefaultMessageThird());
        defaultListMessage.add(getDefaultMessageFourth());
        defaultListMessage.add(getDefaultMessageFifth());
        return defaultListMessage;
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
