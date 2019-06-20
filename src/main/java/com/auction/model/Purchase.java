package com.auction.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Purchase {
    @Id
    private long id;
    private String name;
    private String topic;
    private String description;
    private double price;
    private String endDate;
    private String purchaseDate;
    private String status = "NOT PAID";

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;

    public Purchase(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.endDate = item.getEndDate();
        this.seller=item.getSeller();
        this.buyer = item.getBuyer();
        this.topic = item.getTopic();

    }

    public Purchase(long id, String name, String description, double price, String endDate,  String sellerName, String topic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.endDate = endDate;
        this.seller=new User(sellerName,"", "","", "",0);
        this.buyer = new User("","", "","", "",0);
        this.topic = topic;
    }

    public boolean hasBuyer(){
        if(this.buyer!=null)
            return true;
        else return false;
    }

}
