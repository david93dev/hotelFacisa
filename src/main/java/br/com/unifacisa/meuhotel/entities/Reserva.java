package br.com.unifacisa.meuhotel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "hospede_id", referencedColumnName = "idHospede")
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "quarto_id", referencedColumnName = "idQuarto")
    private Quarto quarto;

    @Column(nullable = false)
    private String dataInicioReserva;

    @Column(nullable = false)
    private String dataFimReserva;

    @Column(nullable = false)
    private String statusReserva;
}
