package br.com.unifacisa.meuhotel.repository;

import br.com.unifacisa.meuhotel.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

}