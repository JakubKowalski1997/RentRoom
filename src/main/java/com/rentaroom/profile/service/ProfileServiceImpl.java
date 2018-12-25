package com.rentaroom.profile.service;

import com.rentaroom.profile.model.Profile;
import com.rentaroom.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }
}
