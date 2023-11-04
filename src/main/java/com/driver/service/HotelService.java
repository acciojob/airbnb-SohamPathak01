package com.driver.service;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.repository.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {

    private final HotelRepo hotelRepo;
    public HotelService(HotelRepo hotelRepo){
        this.hotelRepo=hotelRepo;
    }
    public boolean createHotel(Hotel hotel) {

        return hotelRepo.save(hotel);
    }

    public String getHotelWithMostFacilities(){
        String hotelName="";
        int maxNumberOfFacility=0;
        List<Hotel> hotelList=hotelRepo.findAll();
        for(Hotel hotel:hotelList){
            int curNumberOfFacility=hotel.getFacilities().size();
            if(curNumberOfFacility>maxNumberOfFacility) {
                hotelName = hotel.getHotelName();
                maxNumberOfFacility=curNumberOfFacility;
            }else if(curNumberOfFacility==maxNumberOfFacility){
                if(hotelName.compareTo(hotel.getHotelName())>0){
                    hotelName=hotel.getHotelName();
                }
            }
        }
        return hotelName;
    }

    public Hotel addFacility(List<Facility> newFacilities,String hotelName){

        Hotel hotel=hotelRepo.getbyName(hotelName);

        List<Facility> facilities=hotel.getFacilities();

        Map<Facility,Boolean> facilityAvaliable=new HashMap<>();

        for(Facility facility:facilities){
            facilityAvaliable.put(facility,true);
        }

        for(Facility facility:newFacilities){
            if(!facilityAvaliable.containsKey(facility)){
                facilities.add(facility);
                facilityAvaliable.put(facility,true);
            }
        }
        hotelRepo.update(hotel);
        return hotel;
    }
}
