package com.example.frauddetection.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminRequest {
    private String email;
    private String password;
}
