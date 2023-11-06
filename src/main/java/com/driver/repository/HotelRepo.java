package com.driver.repository;

import com.driver.model.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class HotelRepo {
    private Map<String, Hotel> hotelDB=new HashMap<>();

    public boolean save(Hotel hotel){

        if(StringUtils.isEmpty(hotel.getHotelName())||hotelDB.containsKey(hotel.getHotelName())) {
            return false;
        }
        hotelDB.put(hotel.getHotelName(),hotel);

        return true;
    }

    public void update(Hotel hotel){
        hotelDB.put(hotel.getHotelName(),hotel);
    }

    public List<Hotel> findAll(){
        return new ArrayList<>(hotelDB.values());
    }

    public Hotel findByName(String hotelName) {
        return hotelDB.get(hotelName);
    }

    public Hotel getbyName(String hotelName) {
        return hotelDB.get(hotelName);
    }
}
