package com.dominika.springbootapp.entity;

import com.dominika.springbootapp.pojo.Position;
import jakarta.persistence.*;

@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    //IDENTITY generation disables batch updates.
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Embedded
    @Column(name = "position")
    private Position position;
    private boolean isShared;


    public Place(Long id, String name, String description, Position position, boolean isShared) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
        this.isShared = isShared;
    }

    public Place(String name, String description, Position position, boolean isShared) {
        this.name = name;
        this.description = description;
        this.position = position;
        this.isShared = isShared;
    }

    public Place() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }
}