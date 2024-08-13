package edu.example.training.service;

import edu.example.training.entity.Reservation;
import edu.example.training.input.ReservationInput;

public interface ReservationService {
    Reservation reserve(ReservationInput reservationInput);

}
