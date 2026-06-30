package com.example.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.review.model.reviewModel;

@Repository
public interface reviewRepository extends JpaRepository<reviewModel, Long>{ 
    List<reviewModel> findByDestinationId(Long destinationId);
    List<reviewModel> findByUserId(Long userId);


}
