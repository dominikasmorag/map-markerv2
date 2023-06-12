package com.dominika.springbootapp.controller;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.pojo.Position;
import com.dominika.springbootapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    @PostMapping("/savePlace")
    public void saveLocation(@RequestBody Position position) {
        System.out.println("PlaceController.saveLocation");
        System.out.println("position = " + position);
        Place place = new Place();
        place.setName("test name");
        place.setDescription("test description");
        place.setPosition(position);

        placeService.savePlace(place);
    }

}
