package com.wehavescience.wiremock.sample.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@XmlRootElement
public class User {
    private int id;
    private String username;
    private int age;
    private String occupation;

    public User(int id, String username, int age, String occupation) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.occupation = occupation;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
