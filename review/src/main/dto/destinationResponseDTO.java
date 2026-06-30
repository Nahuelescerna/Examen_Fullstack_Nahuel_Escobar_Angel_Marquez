package cl.duoc.review.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class DestinationResponseDTO {
    private UUID id;
    private String name;
    // Agrega aquí campos adicionales si los necesitas, pero con "id" basta para validar.
}