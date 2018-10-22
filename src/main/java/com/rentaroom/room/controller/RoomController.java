package com.rentaroom.room.controller;

import com.rentaroom.room.service.RoomService;
import com.rentaroom.room.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public String addRoom(Model model) {
        model.addAttribute("roomForm", new Room());

        return "room";
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("roomForm") Room roomForm, Model model){
        roomService.save(roomForm);
        return "redirect:/rooms";
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public String allRooms(Model model){
        model.addAttribute("rooms", roomService.findAll());
        return "rooms";
    }
}
