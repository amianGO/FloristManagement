package com.florist.v1.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "arreglos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Arreglo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arreglo")
    private Long idArreglo;

    private String nombre;

    @OneToMany(mappedBy = "arreglo", cascade = CascadeType.ALL)
    private List<ArregloFlor> arreglosFlores;
}
