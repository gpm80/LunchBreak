package ru.hakaton.rutech.service;

import org.apache.commons.lang3.StringUtils;
import ru.hakaton.rutech.model.User;

import java.util.Random;
import java.util.UUID;

/**
 * Сервис пользователей
 */
public class UserService {

    private static UserService instance;
    private User current;

    private UserService() {
    }

    /**
     * Получить сервис
     *
     * @return
     */
    public static UserService get() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    /**
     * Регистрация пользователя
     *
     * @param name   имя (ник)
     * @param invite токен приглашения
     * @return
     * @throws IllegalArgumentException
     */
    public User register(String name, String invite) throws IllegalArgumentException {
        if (!check(invite)) {
            throw new IllegalArgumentException("Недопустимый инвайт");
        }
        User user = new User();
        user.setName(name);
        user.setUid(UUID.randomUUID().toString());
        return user;
    }

    /**
     * Проверка инвайта
     *
     * @param invite
     * @return
     */
    private boolean check(String invite) {
        // TODO Проверка инвайта и присвоение типа пользака
        if (StringUtils.isBlank(invite)) {
            return false;
        }
        return true;
    }

    public User current() {
        if (current == null) {
            // TODO Переделать на извлечение из ПЗУ
            current = new User();
            current.setUid(UUID.randomUUID().toString());
            current.setName("Ты");
            current.setType(User.Type.values()[
                    new Random().nextInt(User.Type.values().length)]);
        }
        return current;
    }
}
