package com.company.entity;

public class Bid {
    private Buyer buyer;
    private int bidAmount;

    public Bid(Buyer buyer, int bidAmount) {
        this.buyer = buyer;
        this.bidAmount = bidAmount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "buyer=" + buyer +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
