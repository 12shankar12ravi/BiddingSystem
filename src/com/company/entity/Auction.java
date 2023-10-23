package com.company.entity;

import com.company.entity.strategy.BidWinningStrategy;

import java.util.*;

public class Auction {
    private String name;
    private int lowestBidLimit;
    private int highestBidLimit;
    private Seller seller;
    private BidWinningStrategy bidWinningStrategy;
    private Map<String,Bid> buyerBidMap;

    /**
     *
     * @param name
     * @param lowestBidLimit
     * @param highestBidLimit
     * @param seller
     */
    public Auction(String name, int lowestBidLimit, int highestBidLimit, Seller seller, BidWinningStrategy bidWinningStrategy) {
        this.name = name;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.seller = seller;
        this.bidWinningStrategy = bidWinningStrategy;
        this.buyerBidMap = new HashMap<>();
    }

    public void addBid(Buyer buyer , int bidAmount){
        Bid bid = new Bid(buyer,bidAmount);
        buyerBidMap.put(buyer.getName(),bid);
    }

    public void updateBid(Buyer buyer , int newBidAmount){
        Bid bid = buyerBidMap.get(buyer.getName());
        bid.setBidAmount(newBidAmount);
    }

    public void removeBid(Buyer buyer){
        if(buyer.getInitialAmount() != null){
            buyer.updateInitialAmount(buyer.getInitialAmount() - buyerBidMap.get(buyer.getName()).getBidAmount());
        }
        buyerBidMap.remove(buyer.getName());
    }

    // decide winner
    public Buyer closeAuction(){
        return bidWinningStrategy.getWinner(this);
    }

    public String getName() {
        return name;
    }

    public int getLowestBidLimit() {
        return lowestBidLimit;
    }

    public int getHighestBidLimit() {
        return highestBidLimit;
    }

    public Seller getSeller() {
        return seller;
    }

    public Collection<Bid> getAllBids() {
        return buyerBidMap.values();
    }

    @Override
    public String toString() {
        return "Auction{" +
                "name='" + name + '\'' +
                ", lowestBidLimit=" + lowestBidLimit +
                ", highestBidLimit=" + highestBidLimit +
                ", seller=" + seller +
                '}';
    }
}
