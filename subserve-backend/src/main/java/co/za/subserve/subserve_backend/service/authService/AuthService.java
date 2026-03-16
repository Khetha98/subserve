package co.za.subserve.subserve_backend.service.authService;

import co.za.subserve.subserve_backend.dto.request.LoginUserDto;
import co.za.subserve.subserve_backend.dto.request.RegisterUserDto;
import co.za.subserve.subserve_backend.enums.UserRole;
import co.za.subserve.subserve_backend.enums.UserStatus;
import co.za.subserve.subserve_backend.model.User;
import co.za.subserve.subserve_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class AuthService
{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }




    @Transactional
    public User register(RegisterUserDto input) {

        boolean exist = userRepository.findByEmail(input.getEmail()).isPresent();

        // FIRST TIME: create organization
        if (!exist) {
            User user = new User();
            user.setFullName(input.getFullName());
            user.setEmail(input.getEmail());
            user.setStatus(UserStatus.ACTIVE);
            user.setCreatedAt(LocalDateTime.now());
            user.setPasswordHash(passwordEncoder.encode(input.getPassword()));
            user.setRole(input.getRole());


            return userRepository.save(user);
        }
        return null;
    }




    public User authenticate(LoginUserDto input) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getEmail(),
                            input.getPassword()
                    )
            );

            return userRepository.findByEmail(input.getEmail())
                    .orElseThrow();
        }catch(BadCredentialsException e){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,   // ← correct status
                    "Invalid email or password"
            );
        }
    }
}
