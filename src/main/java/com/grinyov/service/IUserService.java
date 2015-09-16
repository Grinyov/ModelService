package com.grinyov.service;

/**
 * Created by Grinyov Vitaliy on 15.09.15.
 *
 * Сервис-слой приложения(Содержит интерфейсы, в которых
 * описано ЧТО ДЕЛАТЬ С ДАННЫМИ или, другими словами,
 * бизнес логика приложения . Также содержит практические реализации этих интерфейсов.)
 */

    import com.grinyov.domain.User;

    import java.util.List;

    public interface IUserService {
        List<User> getAll();

        void updateUser(User user);

        void deleteUser(Long id);

        void addUser(User user);
    }

