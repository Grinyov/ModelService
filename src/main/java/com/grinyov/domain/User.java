package com.grinyov.domain;

/**
 * Created by Grinyov Vitaliy on 15.09.15.
 *
 * Доменный слой (Здесь находятся POJO-классы,
 * такие как User - это то, ЧЕМ приложение оперирует в бизнес логике).
 * Сущность пользователя с которой мы работаем
 */
public class User {
    private Long id;
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
