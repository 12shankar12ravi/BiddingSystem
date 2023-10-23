package com.company.dao;

import com.company.entity.Auction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionRepository {
    private Map<String, Auction> auctions;

    public AuctionRepository(){
        this.auctions = new ConcurrentHashMap<>();
    }

    public Auction getAuction(String auctionName){
        if(auctions.containsKey(auctionName)){
            return auctions.get(auctionName);
        }
        throw new RuntimeException("Auction not present");
    }

    public void addAuction(Auction auction){
        auctions.put(auction.getName(),auction);
    }

    public void removeAuction(String auctionName){
        auctions.remove(auctionName);
    }
}
