package com.company.dao;

import com.company.entity.Buyer;
import com.company.entity.Seller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private Map<String, Buyer> buyers;
    private Map<String, Seller> sellers;

    public UserRepository(){
        this.buyers = new ConcurrentHashMap<>();;
        this.sellers = new ConcurrentHashMap<>();;
    }

    public Buyer getBuyer(String buyerName){
        if(buyers.containsKey(buyerName)){
            return buyers.get(buyerName);
        }
        throw new RuntimeException("Buyer not present");
    }

    public void addBuyer(Buyer buyer){
        buyers.put(buyer.getName(),buyer);
    }

    public Buyer getSeller(String sellerName){
        if(buyers.containsKey(sellerName)){
            return buyers.get(sellerName);
        }
        throw new RuntimeException("Seller not present");
    }

    public void addSeller(Seller seller){
        sellers.put(seller.getName(),seller);
    }
}
