package br.com.unifacisa.meuhotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_quartos")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuarto;

    @Column(nullable = false)
    private String statusQuarto;

    @Column(nullable = false)
    private double valorQuarto;

    @Column(nullable = false)
    private int capacidadeQuarto;

    @Column(nullable = false)
    private String tipoQuarto;

    @JsonIgnore
    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
