package com.rentaroom.room.service;

import com.rentaroom.room.model.Room;

import java.util.List;

public interface RoomService {

    void save(Room room);

    Room findByRoomAddress(String address);

    List<Room> findAll();
}
