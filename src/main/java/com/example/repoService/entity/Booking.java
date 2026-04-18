package com.example.repoService.entity;

import com.gymbooking.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "bookings",
    uniqueConstraints = @UniqueConstraint(
        name = "uq_user_session_booking",
        columnNames = {"user_id", "session_id"}
    )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    @Builder.Default
    private BookingStatus status = BookingStatus.PENDING;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    @Column(name = "cancellation_reason", length = 300)
    private String cancellationReason;
}
