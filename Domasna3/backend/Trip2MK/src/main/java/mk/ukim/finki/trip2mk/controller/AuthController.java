package mk.ukim.finki.trip2mk.controller;

//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.trip2mk.dto.AuthResponse;
import mk.ukim.finki.trip2mk.dto.LoginRequest;
import mk.ukim.finki.trip2mk.entities.Korisnici;
import mk.ukim.finki.trip2mk.security.WebSecurityConfig;
import mk.ukim.finki.trip2mk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        Optional<Korisnici> userOptional = userService.validUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (userOptional.isPresent()) {
            Korisnici user = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(user.getKorisnikId(), user.getIme(), user.getUloga()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        if (userService.hasUserWithUsername(signUpRequest.getUsername())) {
            throw new RuntimeException(String.format("Username %s is already been used", signUpRequest.getUsername()));
        }
        if (userService.hasUserWithEmail(signUpRequest.getEmail())) {
            throw new RuntimeException(String.format("Email %s is already been used", signUpRequest.getEmail()));
        }

        Korisnici user = userService.saveUser(createUser(signUpRequest));
        return new AuthResponse(user.getKorisnikId(), user.getIme(), user.getUloga());
    }

    private Korisnici createUser(SignUpRequest signUpRequest) {
        Korisnici user = new Korisnici();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setIme(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setUloga(WebSecurityConfig.USER);
        return user;
    }
}