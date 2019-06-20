package com.auction.service;

import com.auction.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auction.repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;


    public List<Result> getAllFromResults(String username){
        System.out.println(1);
        List<Result> results = new ArrayList<>();
        resultRepository.findByFromWhomUsername(username)
                .forEach(results::add);
        return results;

    }

    public List<Result> getAllToResults(String username){

        System.out.println(0);
        List<Result> results = new ArrayList<>();
        resultRepository.findByToWhomUsername(username)
                .forEach(results::add);

        return results;

    }

    public void addResult(Result result) {

        resultRepository.save(result);
    }


}
