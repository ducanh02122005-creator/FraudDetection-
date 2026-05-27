package com.example.frauddetection.service.userSerivice;

import com.example.frauddetection.dtos.AuthenticationRequest;
import com.example.frauddetection.dtos.AuthenticationResponse;
import com.example.frauddetection.dtos.RegisterRequest;
import com.example.frauddetection.config.JwtService;
import com.example.frauddetection.entity.user.Role;
import com.example.frauddetection.entity.user.User;
import com.example.frauddetection.repository.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
//    quản lý entity user

    private final PasswordEncoder encoder;
//    mã hóa mật khẩu

    private final JwtService jwtService;
//    tạo token

    private final AuthenticationManager authenticationManager;


//    public AuthenticationResponse register(RegisterRequest request, Role role) {
//var user = User.builder()
//        .email(request.getEmail())
//        .password(encoder.encode(request.getPassword()))
//        .role(Role.CUSTOMER)//khi nào muốn tạo method riêng cho thì hãy sửa lại đoạn này
//        .build();
//repository.save(user);
////tạo email,password, tự phân role là user
//
//
//var jwtToken = jwtService.generateToken(user);
//return AuthenticationResponse.builder()
//        .token(jwtToken)
//        .build();
//    }

public AuthenticationResponse register(RegisterRequest request, Role role) {

    var user = User.builder()
            .email(request.getEmail())
            .password(encoder.encode(request.getPassword()))
            .role(role)
            .build();

    repository.save(user);

    var jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
}

    public AuthenticationResponse authenticate(AuthenticationRequest authenticate) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticate.getEmail(),
                        authenticate.getPassword()
                )
        );
        var user =repository.findByEmail(authenticate.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerCustomer(
            RegisterRequest request
    ) {

        return register(request, Role.CUSTOMER);
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {

        return register(request, Role.ADMIN);
    }
}
