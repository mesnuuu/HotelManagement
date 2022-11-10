package com.mesnu.app.util;


import com.mesnu.app.entity.Reservation;
import com.mesnu.app.entity.Room;
import com.mesnu.app.repository.ReservationRepository;
import com.mesnu.app.repository.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;
    public AppStartupEvent(RoomRepository roomRepository, ReservationRepository reservationRepository) {

        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

//        Iterable<Room> rooms = this.roomRepository.findAll();
//        rooms.forEach(System.out::println );

        List<Reservation> result = this.reservationRepository.findAll();
        result.forEach(System.out::println);

    }
}
