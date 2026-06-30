package cl.duoc.review.service;

import cl.duoc.review.dto.ReviewRequestDTO;
import cl.duoc.review.model.Review;
import java.util.List;
import java.util.UUID;

public interface ReviewService {
    Review saveReview(ReviewRequestDTO dto, String tokenHeader);
    List<Review> fetchReviewsByDestination(UUID destinationId);
}