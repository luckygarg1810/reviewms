package com.microservices.reviewms.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    boolean createReview(Review review, Long companyId);
    Review getReview(Long reviewId);
    boolean updateReview(Long reviewId, Review updatedReview);
    boolean deleteReview(Long reviewId);
}
