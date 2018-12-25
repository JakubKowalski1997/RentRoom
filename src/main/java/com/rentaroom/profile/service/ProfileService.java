package com.rentaroom.profile.service;

import com.rentaroom.profile.model.Profile;

public interface ProfileService {

    void save(Profile profile);

    Profile getById(Long id);

}
