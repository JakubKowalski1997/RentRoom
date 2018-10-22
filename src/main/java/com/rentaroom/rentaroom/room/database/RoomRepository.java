package com.rentaroom.rentaroom.room.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByAddress(String address);
}
