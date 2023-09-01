package com.assessment.model;

import java.util.Objects;

public class Fruit {
    String name;
    String color;
    String shape;
    int days;

    public Fruit(String name, String color, String shape, int days) {
        this.name = name;
        this.color = color;
        this.shape = shape;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }

    public int getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return days == fruit.days && Objects.equals(name, fruit.name) && Objects.equals(color, fruit.color) && Objects.equals(shape, fruit.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, shape, days);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                ", days=" + days +
                '}';
    }
}
