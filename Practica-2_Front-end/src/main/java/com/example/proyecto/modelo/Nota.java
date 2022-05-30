package com.example.proyecto.modelo;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column
    @Getter @Setter private String titulo;

    @Column
    @Getter @Setter private String contenido;

    //@Column
    //colorprivate String texto;
}
