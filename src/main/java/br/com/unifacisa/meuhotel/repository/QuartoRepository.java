package br.com.unifacisa.meuhotel.repository;

import br.com.unifacisa.meuhotel.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer>{

}
