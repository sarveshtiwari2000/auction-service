package com.auction.repository;


import com.auction.model.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, String> {
    public List<Purchase> findBySellerUsername (String username);
    public List<Purchase> findByBuyerUsername (String username);
    public List<Purchase> findByPurchaseDate (String username);
}
