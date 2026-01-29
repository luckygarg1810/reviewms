package com.microservices.reviewms.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long companyId){
        if(reviewService.createReview(review, companyId)){
            return ResponseEntity.ok("Review added successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
       Review review = reviewService.getReview(reviewId);
       if(review != null){
           return ResponseEntity.ok(review);
       }else{
           return ResponseEntity.notFound().build();
       }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId ,@RequestBody Review updatedReview){
        if(reviewService.updateReview(reviewId, updatedReview)){
            return ResponseEntity.ok("Review updated successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{reviewId}")
        public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        if(reviewService.deleteReview(reviewId)){
                return ResponseEntity.ok("Review deleted successfully");
        }else{
                return ResponseEntity.notFound().build();
        }
    }

}
