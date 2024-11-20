package com.florist.v1.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_arreglo")
    private Arreglo arreglo;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    private double presupuesto;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPedido estado;

    @Column(name = "tipo_entrega")
    private String tipoEntrega;

    @Column(name = "detalles_adicionales")
    private String detallesAdicionales;
}
