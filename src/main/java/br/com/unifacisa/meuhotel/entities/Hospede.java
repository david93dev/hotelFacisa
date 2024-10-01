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
@Table(name = "tab_hospedes")
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHospede;

    @Column(nullable = false)
    private Integer hotelId;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String numeroTelefone;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String tipoEstadia;

    @JsonIgnore
    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hospedeID")
    private Hotel hospedesHotel;
}
