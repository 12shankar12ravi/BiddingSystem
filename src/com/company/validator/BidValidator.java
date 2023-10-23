package com.company.validator;

public class BidValidator {

    public static boolean validateBid(int lowestBidAmount , int highestBidAmount , int bidAmount){
        return bidAmount <= highestBidAmount && bidAmount >= lowestBidAmount;
    }
}
