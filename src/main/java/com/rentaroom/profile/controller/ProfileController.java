package com.rentaroom.profile.controller;

import com.rentaroom.profile.model.Profile;
import com.rentaroom.profile.service.ProfileService;
import com.rentaroom.profile.validator.ProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileValidator profileValidator;

    // profile details
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private String details(@PathVariable Long id, Model model) {
        Profile profile = profileService.getById(id);
        model.addAttribute(profile);

        return "profile_details";
    }
    // profile edit
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    private String edit(@PathVariable Long id, Model model) {
        Profile profile = profileService.getById(id);
        model.addAttribute("profile", profile);

        return "profile_edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    private String edit(@ModelAttribute("profile") Profile profile, @PathVariable Long id, BindingResult bindingResult, Model model) {
        profileValidator.validate(profile, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/edit/" + id;
        }

        profileService.save(profile);

        return "redirect:/welcome";
    }
}