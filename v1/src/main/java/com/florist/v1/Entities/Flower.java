package com.florist.v1.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "maker")
@Table(name = "Inventario_Floral")
public class Flower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Color")
    private String color;

    @Column(name = "Variedad")
    private String variedad;

    @Column(name = "Stock")
    private long stock;

    @Column(name = "Precio_Venta")
    private long precio_venta;

    @Column(name = "Precio_Compra")
    private long precio_compra;
    
    @Column(name = "Fecha_Ingreso")
    private Date fecha_ingreso;
    
    @Column(name = "Ubicacion")
    private String Ubicacion;

    @ManyToOne
    @JoinColumn(name = "Id_Proveedor",nullable = false)
    @JsonIgnore
    private Maker maker;
    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ArregloFlor> arreglosFlores;
    
}
