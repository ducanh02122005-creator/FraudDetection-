package com.example.frauddetection.controller.auth;

import com.example.frauddetection.dtos.auth.AuthenticationRequest;
import com.example.frauddetection.dtos.auth.AuthenticationResponse;
import com.example.frauddetection.dtos.auth.RegisterRequest;
import com.example.frauddetection.entity.user.Role;
import com.example.frauddetection.service.userSerivice.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service;
    private Role role;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerCustomer(request));
        // cần viết lại đoạn này do đang tạo một biến rỗng ko cần thiết
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticate
    ){
        return ResponseEntity.ok(service.authenticate(authenticate));
    }

    @PostMapping("/admin")
    public ResponseEntity<AuthenticationResponse> createAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok((service.registerAdmin(request)));
    }

}
