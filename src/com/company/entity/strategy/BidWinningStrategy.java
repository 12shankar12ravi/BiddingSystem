package com.company.entity.strategy;

import com.company.entity.Auction;
import com.company.entity.Buyer;

public interface BidWinningStrategy {
    Buyer getWinner(Auction auction);
}
