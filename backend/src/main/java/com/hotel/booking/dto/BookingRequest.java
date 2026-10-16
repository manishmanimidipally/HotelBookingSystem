package com.hotel.booking.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequest {
    private Long roomId;
    private Long userId;
    private LocalDate checkIn;
    private LocalDate checkOut;
}
