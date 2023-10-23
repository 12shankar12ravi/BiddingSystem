package com.company;

import com.company.service.AuctionService;


public class Main {

    private static AuctionService auctionService = new AuctionService();

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * Test Case 1
     * ● ADD_BUYER(“buyer1”)
     * ● ADD_BUYER(“buyer2”)
     * ● ADD_BUYER(“buyer3”)
     * ● ADD_SELLER(“seller1”)
     * ● CREATE_AUCTION(“A1”, “10”, “50”,  “seller1”)
     * ● CREATE_BID(“buyer1”, “A1”, “17”)
     * ● CREATE_BID(“buyer2”, “A1”, “15”)
     * ● UPDATE_BID(“buyer2”, “A1”, “19”)
     * ● CREATE_BID(“buyer3”, “A1”, “19”)
     * ● CLOSE_AUCTION(“A1”) // Should give Buyer1 as winner
     */
    private static void test1(){
        auctionService.addBuyer("buyer1");
        auctionService.addBuyer("buyer2");
        auctionService.addBuyer("buyer3");
        auctionService.addSeller("seller1");
        auctionService.createAuction("A1",10,50,"seller1");
        auctionService.createBid("buyer1","A1",17);
        auctionService.createBid("buyer2","A1",15);
        auctionService.updateBid("buyer2","A1",19);
        auctionService.createBid("buyer3","A1",19);
        auctionService.closeAuction("A1");
        // 17 , 19 , 19
    }

    /**
     *  * Test Case 2
     *  * ● ADD_SELLER(“seller2”)
     *  * ● CREATE_AUCTION(“A2”, “5”, “20”, “seller2”)
     *  * ● CREATE_BID(“buyer3”, ”A2”, 25) //This should fail as highest bid limit is 20 for A2
     *  * ● CREATE_BID(“buyer2, ”A2”, 5)
     *  * ● WITHDRAW_BID(“buyer2”, “A2”)
     *  * ● CLOSE_AUCTION(“A2”) // No winner
     */
    private static void test2(){
        auctionService.addSeller("seller2");
        auctionService.createAuction("A2",5,20,"seller2");
        auctionService.createBid("buyer3","A2",25);
        auctionService.createBid("buyer2","A2",5);
        auctionService.removeBid("buyer2","A2");
        auctionService.closeAuction("A2");
    }

    /**
     * * Test Case 3 (With budget constraint)
     *  * ● ADD_BUYER(“buyer1”, 20)
     *  * ● ADD_BUYER(“buyer2”, 20)
     *  * ● ADD_BUYER(“buyer3”, 20)
     *  * ● ADD_SELLER(“seller1”)
     *  * ● ADD_SELLER(“seller2”)
     *  * ● CREATE_AUCTION(“A1”, “10”, “50”, “seller1”)
     *  * ● CREATE_AUCTION(“A2”, “5”, “20”, “seller2”)
     *  * ● CREATE_BID(“buyer1”, “A1”, “17”)
     *  * ● CREATE_BID(“buyer2”, “A1”, “15”)
     *  * ● UPDATE_BID(“buyer2”, “A1”, “19”)
     *  * ● CREATE_BID(“buyer3”, “A1”, “19”)
     *  * ● CLOSE_AUCTION(“A1”) // Should give Buyer1 as winner
     *  * ● CREATE_BID(“buyer1, ”A1”, 5) //This should fail as budget exceeds for buyer1
     *  * ● CREATE_BID(“buyer3”, ”A2”, 25) //This should fail as highest bid limit is 20 for A2
     *  * ● CREATE_BID(“buyer2, ”A2”, 5)
     *  * ● WITHDRAW_BID(“buyer2”, “A2”)
     *  * ● CLOSE_AUCTION(“A2”) // No winner
     */
    private static void test3(){
        auctionService.addBuyer("buyer1",20);
        auctionService.addBuyer("buyer2",20);
        auctionService.addBuyer("buyer3",20);
        auctionService.addSeller("seller1");
        auctionService.addSeller("seller2");
        auctionService.createAuction("A1",10,50,"seller1");
        auctionService.createAuction("A2",5,20,"seller2");
        auctionService.createBid("buyer1","A1",17);
        auctionService.createBid("buyer2","A1",15);
        auctionService.updateBid("buyer2","A1",19);
        auctionService.createBid("buyer3","A1",19);
        auctionService.closeAuction("A1");

        auctionService.createBid("buyer1","A2",5);
        auctionService.createBid("buyer3","A2",25);
        auctionService.createBid("buyer2","A2",5);
        auctionService.closeAuction("A2");
    }

}
