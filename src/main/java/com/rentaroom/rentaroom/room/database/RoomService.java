package com.rentaroom.rentaroom.room.database;

import java.util.List;

public interface RoomService {
    void save(Room room);

    Room findByRoomAddress(String address);

    List<Room> findAll();
}
