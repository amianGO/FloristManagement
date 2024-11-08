package com.florist.v1.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Flowers")
public class Flower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Color")
    private String color;

    @Column(name = "Name")
    private String name;

    @Column(name = "Size")
    private String size;

    @Column(name = "Health")
    private Boolean health;

    @ManyToOne()
    @JoinColumn(name = "Id_Maker", nullable = false)
    @JsonIgnore
    private Maker maker;
}
