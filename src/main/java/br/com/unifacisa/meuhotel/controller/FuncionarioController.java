package br.com.unifacisa.meuhotel.controller;

import br.com.unifacisa.meuhotel.dto.FuncionarioRecordDTO;
import br.com.unifacisa.meuhotel.entities.Funcionario;
import br.com.unifacisa.meuhotel.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAll();
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody FuncionarioRecordDTO funcionarioRecordDTO) {
        return funcionarioService.save(funcionarioRecordDTO);
    }

    @DeleteMapping("/{idFuncionario}")
    public void deleteFuncionario(@PathVariable Integer idFuncionario) {
        funcionarioService.delete(idFuncionario);
    }

    @PutMapping("/{idFuncionario}")
    public Funcionario updateFuncionario(@PathVariable Integer idFuncionario, @RequestBody FuncionarioRecordDTO updatedFuncionarioDTO) {
        return funcionarioService.update(idFuncionario, updatedFuncionarioDTO); }

}





