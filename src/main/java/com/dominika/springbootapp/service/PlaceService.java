package com.dominika.springbootapp.service;

import com.dominika.springbootapp.controller.SecurityController;
import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.entity.User;
import com.dominika.springbootapp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    PlaceRepository placeRepository;
    UserService userService;
    UserPlaceService userPlaceService;
    @Autowired
    SecurityController securityController;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, UserService userService, UserPlaceService userPlaceService) {
        this.placeRepository = placeRepository;
        this.userService = userService;
        this.userPlaceService = userPlaceService;
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public void savePlace(Place place) {
        Place newPlace = placeRepository.save(place);
        User user = userService.currentUser();
        userPlaceService.saveUserPlace(user, newPlace);
    }

}
