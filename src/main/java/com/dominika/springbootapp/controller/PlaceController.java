package com.dominika.springbootapp.controller;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.service.PlaceService;
import com.dominika.springbootapp.service.UserPlaceService;
import com.dominika.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class PlaceController {
    private PlaceService placeService;
    private UserPlaceService userPlaceService;
    private UserService userService;

    @Autowired
    public PlaceController(PlaceService placeService, UserPlaceService userPlaceService,  UserService userService) {
        this.placeService = placeService;
        this.userPlaceService = userPlaceService;
        this.userService = userService;
    }

    @GetMapping("/places/myPlaces")
    @ResponseBody
    public List<Place> getUserPlaces() { return userPlaceService.findUserPlaces(userService.currentUserId());}

    @GetMapping("/places/shared")
    @ResponseBody
    public List<Place> getSharedPlaces() { return placeService.findSharedPlaces();
    }
    @PostMapping("/savePlace")
    public void saveLocation(@RequestBody Place place) {
        placeService.savePlace(place);
    }


    @GetMapping("places/userPlacesQuantity")
    public int countUserPlaces() {
        return userPlaceService.countUserPlaces(userService.currentUser());
    }

    @GetMapping("places/sharedPlacesQuantity")
    public int countSharedPlaces() {
        return userPlaceService.countSharedPlaces();
    }

}
