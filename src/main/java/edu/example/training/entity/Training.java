package edu.example.training.entity;

import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Training {
    private String id;
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer reserved;
    private Integer capacity;

}
