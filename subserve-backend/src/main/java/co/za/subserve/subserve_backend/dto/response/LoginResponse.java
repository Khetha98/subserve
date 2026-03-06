package co.za.subserve.subserve_backend.dto.response;

import co.za.subserve.subserve_backend.enums.UserRole;
import lombok.*;

@Getter
@Setter
@ToString
public class LoginResponse {

    private String token;
    private long expiresIn;
    private UserRole role;
}
