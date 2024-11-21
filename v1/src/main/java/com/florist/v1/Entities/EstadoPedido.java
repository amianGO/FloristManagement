package com.florist.v1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "estado_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    private String descripcion;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}
