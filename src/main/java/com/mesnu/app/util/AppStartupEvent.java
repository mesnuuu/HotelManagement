package com.mesnu.app.util;


import com.mesnu.app.dto.RoomReservation;
import com.mesnu.app.entity.Reservation;
import com.mesnu.app.entity.Room;
import com.mesnu.app.repository.ReservationRepository;
import com.mesnu.app.repository.RoomRepository;

import com.mesnu.app.service.ReservationService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);

    }
}
