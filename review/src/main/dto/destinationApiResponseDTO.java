package cl.duoc.review.dto;

import lombok.Data;

@Data
public class DestinationApiResponseDTO {
    private int code;
    private String message;
    private DestinationResponseDTO data;
}