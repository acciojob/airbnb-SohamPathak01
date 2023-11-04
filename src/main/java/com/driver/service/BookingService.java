package com.driver.service;

import com.driver.model.Booking;
import com.driver.model.Hotel;

import com.driver.repository.BookingRepo;
import com.driver.repository.HotelRepo;
import org.springframework.stereotype.Service;


import java.util.UUID;


@Service
public class BookingService {
    private final HotelRepo hotelRepo;
    private final BookingRepo bookingRepo;

    public BookingService(HotelRepo hotelRepo,BookingRepo bookingRepo){
        this.hotelRepo=hotelRepo;
        this.bookingRepo=bookingRepo;
    }

    public int createBookings(Booking booking){
        String hotelName=booking.getHotelName();
        Hotel hotel=hotelRepo.findByName(hotelName);
        if(booking.getNoOfRooms()>hotel.getAvailableRooms()){
            return -1;
        }
        int amountToBePaid=hotel.getPricePerNight()*booking.getNoOfRooms();
        booking.setAmountToBePaid(amountToBePaid);
        booking.setBookingId(UUID.randomUUID().toString());
        bookingRepo.save(booking);
        return amountToBePaid;
    }

    public int getNumberOfBookingsByUser(int adharCard){
        return bookingRepo.nuberOfBookingsByUser(adharCard);
    }

}
