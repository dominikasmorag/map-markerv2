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

    @Column(name = "shared")
    private boolean shared;

    @Column(name = "icon_path")
    private String iconPath;

    public Place(Long id, String name, String description, Position position, boolean shared, String iconPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
        this.shared = shared;
        this.iconPath = iconPath;
    }

    public Place(String name, String description, Position position, boolean shared, String iconPath) {
        this.name = name;
        this.description = description;
        this.position = position;
        this.shared = shared;
        this.iconPath = iconPath;
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

    public boolean isShared() { return shared; }

    public void setShared(boolean shared) { this.shared = shared; }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", position=" + position +
                ", shared=" + shared +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }
}