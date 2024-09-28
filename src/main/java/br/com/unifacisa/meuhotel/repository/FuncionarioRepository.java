package br.com.unifacisa.meuhotel.repository;

import br.com.unifacisa.meuhotel.entities.Funcionario;
import br.com.unifacisa.meuhotel.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}