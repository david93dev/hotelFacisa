package br.com.unifacisa.meuhotel.services;

import br.com.unifacisa.meuhotel.dto.FuncionarioRecordDTO;
import br.com.unifacisa.meuhotel.entities.Funcionario;
import br.com.unifacisa.meuhotel.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario save(FuncionarioRecordDTO funcionarioRecordDTO) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioRecordDTO.nome());
        funcionario.setCpf(funcionarioRecordDTO.cpf());
        funcionario.setEndereco(funcionarioRecordDTO.endereco());
        funcionario.setNumeroTelefone(funcionarioRecordDTO.numeroTelefone());
        funcionario.setDataNascimento(funcionarioRecordDTO.dataNascimento());
        funcionario.setSalario(funcionarioRecordDTO.salario());
        funcionario.setCargo(funcionarioRecordDTO.cargo());
        funcionario.setTurnoTrabalho(funcionarioRecordDTO.turnoTrabalho());
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    public void delete(Integer idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }

    public Funcionario update(Integer idFuncionario, FuncionarioRecordDTO updatedFuncionarioDTO) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).get();

        funcionario.setNome(updatedFuncionarioDTO.nome());
        funcionario.setCpf(updatedFuncionarioDTO.cpf());
        funcionario.setEndereco(updatedFuncionarioDTO.endereco());
        funcionario.setNumeroTelefone(updatedFuncionarioDTO.numeroTelefone());
        funcionario.setDataNascimento(updatedFuncionarioDTO.dataNascimento());
        funcionario.setSalario(updatedFuncionarioDTO.salario());
        funcionario.setCargo(updatedFuncionarioDTO.cargo());
        funcionario.setTurnoTrabalho(updatedFuncionarioDTO.turnoTrabalho());
        return funcionarioRepository.save(funcionario);
    }

}
