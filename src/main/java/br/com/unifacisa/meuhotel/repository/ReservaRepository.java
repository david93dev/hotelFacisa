package br.com.unifacisa.meuhotel.repository;


import br.com.unifacisa.meuhotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}