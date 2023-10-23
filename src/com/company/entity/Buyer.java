package com.company.entity;

public class Buyer extends User{
    private Integer initialAmount;

    public Buyer(String name,int initialAmount) {
        super(name);
    }

    public Buyer(String name){
        super(name);
    }

    public Integer getInitialAmount() {
        return initialAmount;
    }

    public void updateInitialAmount(Integer initialAmount) {
        this.initialAmount = initialAmount;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name=" + this.name +
                ",initialAmount=" + initialAmount +
                '}';
    }
}
