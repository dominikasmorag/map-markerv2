package com.dominika.springbootapp.controller;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.service.PlaceService;
import com.dominika.springbootapp.service.UserPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class PlaceController {
    private final PlaceService placeService;
    private final UserPlaceService userPlaceService;

    @Autowired
    public PlaceController(PlaceService placeService, UserPlaceService userPlaceService) {
        this.placeService = placeService;
        this.userPlaceService = userPlaceService;
    }

    @GetMapping("/places")
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    @GetMapping("/places/{id}")
    @ResponseBody
    public List<Place> getUserPlaces(@PathVariable(value="id") Long userId) { return userPlaceService.findUserPlaces(userId);}

    //this method is not finished yet in javascript
    @GetMapping("/places/shared")
    @ResponseBody
    public List<Place> getSharedPlaces() { return placeService.findSharedPlaces();
    }
    @PostMapping("/savePlace")
    public void saveLocation(@RequestBody Place place) {
        placeService.savePlace(place);
    }

}
