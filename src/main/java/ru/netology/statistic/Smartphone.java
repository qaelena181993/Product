package ru.netology.statistic;

public class Smartphone extends Product {
    private String name;
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, price);
        this.name = name;
        this.producer = producer;
    }


    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
