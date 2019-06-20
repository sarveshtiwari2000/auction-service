package com.auction.controller;

import com.auction.service.ResultService;
import com.auction.model.Result;
import com.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;


    /*get all results from username*/

    @RequestMapping("/users/{username}/feedbacks/from")
    public List<Result> getAllFromResults(@PathVariable String username){
        return resultService.getAllFromResults(username);
    }

     /*get all results to username*/

    @RequestMapping("/users/{username}/feedbacks/to")
    public List<Result> getAllToResults(@PathVariable String username){
        return resultService.getAllToResults(username);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/users/{fromWhom}/feedbacks/{toWhom}")
    public void addResult(@RequestBody String description, @PathVariable String fromWhom, @PathVariable String toWhom){
        Result result = new Result(description,new User(fromWhom,"","","", "",0),new User(toWhom,"", "","", "",0));
        resultService.addResult(result);
    }


    @RequestMapping("/feedbacks")
    public String getAll(){
        return "Request";
    }



}
