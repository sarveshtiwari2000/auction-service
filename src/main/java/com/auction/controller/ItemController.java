package com.auction.controller;

import com.auction.model.Item;
import com.auction.model.User;
import com.auction.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.auction.service.ItemService;

import java.util.List;

@RestController
public class ItemController {



    @Autowired
    private ItemService itemService;
    @Autowired
    private SecurityService securityService;


    /*get all items for one seller*/
    @RequestMapping("/myItems")
    public List<Item> getAllUserItems(){
        User user = securityService.getAuthenticatedUser();
        return itemService.getAllUserItems(user.getUsername());
    }


    /*get all items from DB*/
    @RequestMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    /*get all items from DB in sorted by price*/
    @RequestMapping("/items/sort")
    public List<Item> getAllSortedItems(){
        return itemService.getAllSortedItems();
    }



    /*get all items from DB by topic*/
    @RequestMapping("/items/{topicName}")
    public List<Item> getAllItemsByTopic(@PathVariable String topicName){
        return itemService.getAllItemsByTopic(topicName);
    }


    /*get one item for one seller*/
    @RequestMapping("myItems/{id}")
    public Item getItem(@PathVariable String id){
        return itemService.getItem(id);
    }


    @RequestMapping(method= RequestMethod.POST, value = "/addItem")
    public void addItem(@RequestBody Item item){
        User user = securityService.getAuthenticatedUser();
        itemService.addItem(item, user.getUsername());
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/items/{id}")
    public void updateItem(@RequestBody Item item, @PathVariable String username,@PathVariable String id){
        item.setSeller(new User(username,"","","", "",0));
        itemService.updateItem(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
    public void  deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

}
