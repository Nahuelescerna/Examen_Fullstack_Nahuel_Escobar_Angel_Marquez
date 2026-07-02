package cl.duoc.review.controller;

import cl.duoc.review.dto.ApiResponse;
import cl.duoc.review.dto.ReviewRequestDTO;
import cl.duoc.review.model.Review;
import cl.duoc.review.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;



@RestController
@Tag(name = "Review Controller", description = "Endpoints para la gestión e integración de reseñas de destinos.")
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @Operation(summary = "Crear una nueva reseña", description = "Permite registrar una calificación y comentario validando de forma distribuida el token de usuario y la existencia del destino.")
    public ResponseEntity<ApiResponse<Review>> createReview(
            @Valid @RequestBody ReviewRequestDTO dto,
            @RequestHeader("Authorization") String authorizationHeader) {
        
        Review newReview = reviewService.saveReview(dto, authorizationHeader);
        ApiResponse<Review> response = new ApiResponse<>(201, "Reseña registrada con éxito", newReview);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/destination/{destinationId}")
    @Operation(summary = "Obtener reseñas por destino", description = "Recupera todas las valoraciones asociadas al identificador único (UUID) de un destino específico.")
    public ResponseEntity<ApiResponse<List<Review>>> getReviewsByDestination(@PathVariable UUID destinationId) {
        List<Review> reviews = reviewService.fetchReviewsByDestination(destinationId);
        ApiResponse<List<Review>> response = new ApiResponse<>(200, "Listado de reseñas obtenido", reviews);
        return ResponseEntity.ok(response);
    }
}
