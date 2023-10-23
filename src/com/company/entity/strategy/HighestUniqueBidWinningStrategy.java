package com.company.entity.strategy;

import com.company.entity.Auction;
import com.company.entity.Bid;
import com.company.entity.Buyer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HighestUniqueBidWinningStrategy implements BidWinningStrategy{

    @Override
    public Buyer getWinner(Auction auction) {
        Collection<Bid> allBids = auction.getAllBids();
        HashMap<Integer,Integer> uniqueBids = new HashMap<>();
        for(Bid bid: allBids){
            uniqueBids.put(bid.getBidAmount(),uniqueBids.getOrDefault(bid.getBidAmount(),0)+1);
        }
        int highestBid = 0;
        Bid winnerBid = null;
        Buyer winner = null;
        for(Bid bid: allBids){
            int bidAmount = bid.getBidAmount();
            if(uniqueBids.get(bidAmount) == 1 && bidAmount > highestBid){
                highestBid = bidAmount;
                winnerBid = bid;
                winner = bid.getBuyer();
            }
        }
        if(winner!=null && winner.getInitialAmount() != null){
            winner.updateInitialAmount(winner.getInitialAmount() - winnerBid.getBidAmount());
        }
        return winner;
    }
}
