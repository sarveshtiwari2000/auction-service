package com.auction.repository;

import com.auction.model.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, String> {

    public List<Result> findByFromWhomUsername (String username);
    public List<Result> findByToWhomUsername (String username);
    public Result findById (long username);
}
