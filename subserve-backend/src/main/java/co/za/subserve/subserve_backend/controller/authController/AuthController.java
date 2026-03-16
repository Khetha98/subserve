package co.za.subserve.subserve_backend.controller.authController;


import co.za.subserve.subserve_backend.dto.request.LoginUserDto;
import co.za.subserve.subserve_backend.dto.request.RegisterUserDto;
import co.za.subserve.subserve_backend.dto.response.LoginResponse;
import co.za.subserve.subserve_backend.model.User;
import co.za.subserve.subserve_backend.service.authService.AuthService;
import co.za.subserve.subserve_backend.service.jwtService.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtService jwtService;

    private final AuthService authenticationService;

    public AuthController(JwtService jwtService, AuthService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerInstitutionDto) {
        User registeredUser = authenticationService.register(registerInstitutionDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setRole(authenticatedUser.getRole());
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}

