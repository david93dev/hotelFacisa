package br.com.unifacisa.meuhotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("hospede_id")
    public Integer getHospedeId() {
        return hospede != null ? hospede.getIdHospede() : null;
    }

    // Expondo apenas o ID do quarto no JSON
    @JsonProperty("quarto_id")
    public Integer getQuartoId() {
        return quarto != null ? quarto.getIdQuarto() : null;
    }
}
