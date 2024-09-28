package br.com.unifacisa.meuhotel.controller;

import br.com.unifacisa.meuhotel.dto.QuartoRecordDTO;
import br.com.unifacisa.meuhotel.entities.Quarto;
import br.com.unifacisa.meuhotel.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @Autowired
    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping
    public List<Quarto> getAllQuartos() {
        return quartoService.getAll();
    }

    @PostMapping
    public Quarto createQuarto(@RequestBody QuartoRecordDTO quartoRecordDTO) {
        return quartoService.save(quartoRecordDTO);
    }

    @DeleteMapping("/{idQuarto}")
    public void deleteQuarto(@PathVariable Integer idQuarto) {
        quartoService.delete(idQuarto);
    }

    @PutMapping("/{idQuarto}")
    public Quarto updateQuarto(@PathVariable Integer idQuarto, @RequestBody QuartoRecordDTO updatedQuartoDTO) {
        return quartoService.update(idQuarto, updatedQuartoDTO); }

}
