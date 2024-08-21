package edu.example.training.repository;

import edu.example.training.entity.Reservation;

public interface ReservationRepository {
    boolean insert(Reservation reservation);
    Reservation selectById(String id);

}
