package com.example.frauddetection.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_profiles")
public class AdminProfile {
    @Id
    private Long userId; // Không dùng @GeneratedValue vì ID lấy từ bảng User

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String permission;

    @OneToOne
    @MapsId // Chia sẻ khóa chính với bảng User
    @JoinColumn(name = "user_id")
    private User user;
}
