package com.example.frauddetection.entity.user;

import com.example.frauddetection.entity.transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer_profiles")
public class CustomerProfile {
    @Id
    private Long userId; // Không dùng @GeneratedValue vì ID lấy từ bảng User

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "account_no", length = 100)
    private String accountNo;

    @OneToOne
    @MapsId // Chia sẻ khóa chính với bảng User
    @JoinColumn(name = "user_id")
    private User user;

}
