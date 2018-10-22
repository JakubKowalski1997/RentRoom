package com.rentaroom.room.repository;

import com.rentaroom.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByAddress(String address);
}
