package com.hotel.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendBookingConfirmation(String toEmail, String name, String hotelName, String checkIn, String checkOut) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setFrom("Nithinreddy9063@gmail.com");
        message.setSubject("Reservation Confirmed - " + hotelName);
        
        String body = String.format(
            "Hello %s,\n\n" +
            "Great news! Your stay at %s has been confirmed.\n\n" +
            "Booking Summary:\n" +
            "--------------------------\n" +
            "Hotel:    %s\n" +
            "Check-in: %s\n" +
            "Check-out: %s\n" +
            "--------------------------\n\n" +
            "Thank you for booking with us!\n" +
            "Safe travels,",
            name, hotelName, hotelName, checkIn, checkOut
        );
        
        message.setText(body);
        
        try {
            System.out.println("DEBUG: Attempting to send email to " + toEmail + "...");
            mailSender.send(message);
            System.out.println("DEBUG: Email sent successfully to " + toEmail);
        } catch (Exception e) {
            System.err.println("DEBUG ERROR: Email failed. Please check app-password or SMTP settings. Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
