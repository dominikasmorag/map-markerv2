package com.dominika.springbootapp.entity;

import com.dominika.springbootapp.pojo.Position;
import jakarta.persistence.*;

@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //IDENTITY generation disables batch updates.
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Embedded
    @Column(name = "position")
    private Position position;

    public Place(Long id, String name, String description, Position position) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
    }

    public Place(String name, String description, Position position) {
        this.name = name;
        this.description = description;
        this.position = position;

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

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", position=" + position.toString() +
                '}';
    }
}