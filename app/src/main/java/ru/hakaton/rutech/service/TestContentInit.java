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
    private List<List<String>> dialogs;

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
        dialogs = new ArrayList<>();
        dialogs.add(Arrays.asList("Всем привет)))","Как дела, друзья??","ОГОНЬ, хакатон отличный!!","ВСЕМ УДАЧИ!!"));
        dialogs.add(Arrays.asList("Светит солнце, как приятно)))","Что нового, друзья???","Лучший хактон!!","Умейте прощать)"));
        dialogs.add(Arrays.asList("Расскажим о себе, я Леша, я пока никто)","Я Саша, четкий прогрммист","Я Света, дизайнер от бога!!","А я Фёдор, я очень крутой хакатонщик:)"));
        dialogs.add(Arrays.asList("Расскажите о конференции)))","Стоит ли на нее идти?","Конференция - ОГОНЬ!!","ВСЕМ УДАЧИ!!"));
        dialogs.add(Arrays.asList("Всем мира, как дела?)","Мы победили хакатон...!!!","А что вы за команда?","it-lab"));
    }
    public List<User> getUserList() {
        return userList;
    }

    public List<Message> getRandomMessages() {
        List<Message> list = new ArrayList<>();
        Random random = new Random();
        List<String> dialog = dialogs.get(random.nextInt(dialogs.size()));
        for (String mess: dialog){
            list.add(createMessage(mess));
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
