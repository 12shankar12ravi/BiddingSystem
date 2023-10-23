package com.company.service;

import com.company.dao.AuctionRepository;
import com.company.dao.UserRepository;
import com.company.entity.Auction;
import com.company.entity.Buyer;
import com.company.entity.Seller;
import com.company.entity.strategy.HighestUniqueBidWinningStrategy;
import com.company.validator.BidValidator;

public class AuctionService {

    private AuctionRepository auctionRepository;
    private UserRepository userRepository;

    public AuctionService(){
        this.auctionRepository = new AuctionRepository();
        this.userRepository = new UserRepository();
    }

    /**
     *
     * @param auctionName
     * @param lowerLimit
     * @param higherLimit
     * @param sellerName
     */
    public void createAuction(String auctionName , int lowerLimit , int higherLimit , String sellerName){
        Auction auction = new Auction(auctionName,lowerLimit,higherLimit,new Seller(sellerName),
                new HighestUniqueBidWinningStrategy());
        auctionRepository.addAuction(auction);
        System.out.println("Auction created !");
    }


    public void closeAuction(String auctionName){
        Auction auction = auctionRepository.getAuction(auctionName);
        Buyer winner = auction.closeAuction();
        if(winner != null){
            System.out.println(winner);
        }else{
            System.out.println("NO WINNER");
        }
        auctionRepository.removeAuction(auctionName);
    }

    public void createBid(String buyerName , String auctionName , int bidAmount){
        Auction auction = auctionRepository.getAuction(auctionName);
        Buyer buyer = userRepository.getBuyer(buyerName);
        if(!BidValidator.validateBid(auction.getLowestBidLimit(),auction.getHighestBidLimit(),bidAmount)){
            System.out.println("Create Bid Failed , bidAmount is not in range");
            return;
        }
        if(buyer.getInitialAmount()!=null && buyer.getInitialAmount() < bidAmount){
            System.out.println("Create Bid Failed , bidAmount exceeds initialAmount");
            return;
        }
        auction.addBid(buyer,bidAmount);
        System.out.println("bid successfully added");
    }

    public void updateBid(String buyerName , String auctionName , int bidAmount){
        Auction auction = auctionRepository.getAuction(auctionName);
        Buyer buyer = userRepository.getBuyer(buyerName);
        auction.updateBid(buyer,bidAmount);
        System.out.println("bid successfully updated");
    }

    public void removeBid(String buyerName , String auctionName){
        Auction auction = auctionRepository.getAuction(auctionName);
        Buyer buyer = userRepository.getBuyer(buyerName);
        auction.removeBid(buyer);
    }

    public void addBuyer(String name){
        userRepository.addBuyer(new Buyer(name));
        System.out.println("buyer added");
    }

    public void addBuyer(String name , int initialAmount){
        userRepository.addBuyer(new Buyer(name,initialAmount));
        System.out.println("buyer added with amount = "+initialAmount);
    }

    public void addSeller(String name){
        userRepository.addSeller(new Seller(name));
        System.out.println("seller added");
    }
}
