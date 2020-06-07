package ru.hakaton.rutech.service;

import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.User;

import java.util.*;

/**
 * Created by Petr Gusarov
 */
public class TestContentInit {

    private static TestContentInit instance;
    private List<User> userList;
    private List<String> messagesText;

    public static TestContentInit get() {
        if (instance == null) {
            instance = new TestContentInit();
            instance.init();
        }
        return instance;
    }

    private void init() {
        userList = new ArrayList<>();
        userList.add(createUser("Ворон"));
        userList.add(createUser("Катя"));
        userList.add(createUser("Маша"));
        userList.add(createUser("Ваня"));
        userList.add(createUser("Некто"));
        messagesText = Arrays.asList(
                "Привет",
                "Хай",
                "Ок",
                "Как дела? Что будем делать",
                "А кто-нибудь видел Машу",
                "Кто потерял телефон?",
                "Может в бар?",
                "Давайте споем",
                "Вы кто здесь такие все???",
                "Прикольно! Всем приветы!!!",
                "Да будет свет...",
                "Все я устал... Я пошел спать"
        );
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Message> getRandomMessages(int count) {
        List<Message> list = new ArrayList<>();
        Random random = new Random();
        while (count-- > 0) {
            list.add(createMessage(messagesText.get(random.nextInt(messagesText.size()))));
        }
        return list;
    }


    private Message createMessage(String message) {
        Message m = new Message();
        m.setParent(userList.get(new Random().nextInt(userList.size())));
        m.setMessage(message);
        return m;
    }

    private User createUser(String name) {
        User user = new User();
        user.setName(name);
        user.setType(User.Type.values()[new Random().nextInt(User.Type.values().length)]);
        user.setUid(UUID.randomUUID().toString());
        return user;
    }
}
