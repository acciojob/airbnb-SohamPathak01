package com.driver.repository;

import com.driver.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepo {
    private static final Map<String, Booking> bookingDB=new HashMap<>();

    public void save(Booking booking){
        bookingDB.put(booking.getBookingId(),booking);
    }

    public int nuberOfBookingsByUser(int ardharCardNumber){
        int numberOfBookings=0;
        for(Booking booking:bookingDB.values()){
            if(booking.getBookingAadharCard()==ardharCardNumber){
                numberOfBookings++;
            }
        }
        return numberOfBookings;
    }
}
