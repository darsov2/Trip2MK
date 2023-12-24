package mk.ukim.finki.trip2mk.service.Impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.trip2mk.Dao.KorisniciDao;
import mk.ukim.finki.trip2mk.entities.Korisnici;
import mk.ukim.finki.trip2mk.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final KorisniciDao userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Korisnici> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Korisnici> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean hasUserWithUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Korisnici validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException(String.format("User with username %s not found", username)));
    }

    @Override
    public Korisnici saveUser(Korisnici user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Korisnici user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<Korisnici> validUsernameAndPassword(String username, String password) {
        return getUserByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }
}