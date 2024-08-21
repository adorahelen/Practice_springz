package edu.example.training.entity;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor // 주석처리 하면 왜 오류나는지
@Data
@NoArgsConstructor // 주석처리 하면 왜 오류 나는지
public class Training {
    private String id;
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer reserved;
    private Integer capacity;

   private List<Reservation> reservations;

}
