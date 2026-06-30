package cl.duoc.review.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private int code;
    private String message;
    private UserDTO data;
}