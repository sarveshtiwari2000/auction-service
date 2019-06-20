package com.auction.service;

import com.auction.model.Purchase;
import com.auction.repository.PurchaseRepository;
import com.auction.model.User;
import com.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Purchase> getBuyerPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findByBuyerUsername(username)
                .forEach(purchases::add);
        return purchases;
    }


    public List<Purchase> getSellerPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findBySellerUsername(username)
                .forEach(purchases::add);
        return purchases;
    }


    public void paymentPurchase(String username, String idPurchase){
        Purchase tempPurchase = purchaseRepository.findOne(idPurchase);
        if(tempPurchase.getStatus().equals("NOT PAID")) {
            User tempBuyerUser = userRepository.findOne(tempPurchase.getBuyer().getUsername());
            if (tempBuyerUser.getBalance() >= tempPurchase.getPrice()) {
                tempBuyerUser.subtractMoney(tempPurchase.getPrice());
                userRepository.save(tempBuyerUser);
                User tempSellerUser = userRepository.findOne(tempPurchase.getSeller().getUsername());
                tempSellerUser.addMoney(tempPurchase.getPrice());
                userRepository.save(tempSellerUser);
            }
            tempPurchase.setStatus("PAID");
            purchaseRepository.save(tempPurchase);
        }
    }



}
