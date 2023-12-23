package mk.ukim.finki.trip2mk.service;

import mk.ukim.finki.trip2mk.entities.Korisnici;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Korisnici> getUsers();

    Optional<Korisnici> getUserByUsername(String username);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithEmail(String email);

    Korisnici validateAndGetUserByUsername(String username);

    Korisnici saveUser(Korisnici user);

    void deleteUser(Korisnici user);

    Optional<Korisnici> validUsernameAndPassword(String username, String password);
}