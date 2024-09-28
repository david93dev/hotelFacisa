package br.com.unifacisa.meuhotel.controller;

import br.com.unifacisa.meuhotel.dto.HospedeRecordDTO;
import br.com.unifacisa.meuhotel.entities.Hospede;
import br.com.unifacisa.meuhotel.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    private final HospedeService hospedeService;

    @Autowired
    public HospedeController(HospedeService hospedeService){
        this.hospedeService = hospedeService;
    }

    @GetMapping
    public List<Hospede> getAllHospedes() {
        return hospedeService.getAll();
    }

    @PostMapping
    public Hospede createHospede(@RequestBody HospedeRecordDTO hospedeRecordDTO) {
        return hospedeService.save(hospedeRecordDTO);
    }

    @DeleteMapping("/{idHospede}")
    public void deleteHospede(@PathVariable Integer idHospede) {
        hospedeService.delete(idHospede);
    }

    @PutMapping("/{idHospede}")
    public Hospede updateHospede(@PathVariable Integer idHospede, @RequestBody HospedeRecordDTO updatedHospedeDTO) {
        return hospedeService.update(idHospede, updatedHospedeDTO); }

}
