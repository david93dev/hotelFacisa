package br.com.unifacisa.meuhotel.entities;

import br.com.unifacisa.meuhotel.repository.QuartoRepository;
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
@Table(name = "tab_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHotel;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "quartosHotel")
    private List<Quarto> quartos;

    @OneToMany(mappedBy = "hospedesHotel")
    private List<Hospede> hospedes;

    @OneToMany(mappedBy = "reservasHotel")
    private List<Reserva> Reserva;

}
