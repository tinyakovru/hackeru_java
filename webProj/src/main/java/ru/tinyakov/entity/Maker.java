package ru.tinyakov.entity;

import java.io.Serializable;
import java.util.Objects;

public class Maker implements Serializable {

    private int id;

    private String title;

    public Maker() {    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maker maker = (Maker) o;
        return id == maker.id &&
                title.equals(maker.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
