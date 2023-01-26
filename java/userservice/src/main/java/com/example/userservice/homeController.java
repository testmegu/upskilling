package com.example.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class homeController {
      @Autowired
      JwtUtil JwtUtil;

      @Autowired
      MyUserDetailsService MyUserDetailsService;

      @Autowired
      AuthenticationManager authenticationManager;

    // Repositroy
    @Autowired
     UserRepository userRepository;

    // Home
    @GetMapping("/")
    public String home() {
        return "<h1>Welcome!</h1>";
    }

    // User Page
    @GetMapping("/user")
    public String user() {
        return "<h1>Welcome user!</h1>";
    }

    // Admin Page
    @GetMapping("/admin/a")
    public String admin() {
        return "<h1>Welcome admin!</h1>";
    }

    // Repositroy
    @Autowired
    private UserRepository repository;

    // Sign In Page
    // Let's the user to sign in
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/logIn")
    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest auth) {

        String username = auth.getUsername();
        String password = auth.getPassword();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new RequestResponse("Authentication Failed!"));
        }

        final UserDetails userDetails = MyUserDetailsService.loadUserByUsername(auth.getUsername());
        final String jwt = JwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(auth.getUsername(), "Authentication Succesful!", jwt,
                userRepository.findById(auth.getUsername()).get().getRoles()));
    }

    // Sign Up Page
    // To create new user and add it to the database
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserModel user) {

        repository.save(user);
        return ResponseEntity.ok("Added User to the Database with id: " + user.getUsername());

    }

    // Users List
    // List of all users in the database
    @GetMapping("/allUsers")
    public List<UserModel> getAllUsers() {
        return repository.findAll();
    }

    // Find the user by id
    @GetMapping("/allUsers/{username}")
    public Optional<UserModel> getUser(@PathVariable String username) {
        return repository.findById(username);
    }

    // To delete by id
    @GetMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) throws Exception {
        repository.deleteById(username);
        return ResponseEntity.ok("Added User to the Database with id: " + username);
    }
}
