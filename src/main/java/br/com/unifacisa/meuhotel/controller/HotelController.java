package br.com.unifacisa.meuhotel.controller;

import br.com.unifacisa.meuhotel.dto.HotelRecordDTO;
import br.com.unifacisa.meuhotel.entities.Hotel;
import br.com.unifacisa.meuhotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllFuncionarios() {
        return hotelService.getAll();
    }

    @PostMapping
    public Hotel createFuncionario(@RequestBody HotelRecordDTO hotelRecordDTO) {
        return hotelService.save(hotelRecordDTO);
    }

    @DeleteMapping("/{idFuncionario}")
    public void deleteFuncionario(@PathVariable Integer idFuncionario) {
        hotelService.delete(idFuncionario);
    }

    @PutMapping("/{idFuncionario}")
    public Hotel updateFuncionario(@PathVariable Integer idFuncionario, @RequestBody HotelRecordDTO updatedFuncionarioDTO) {
        return hotelService.update(idFuncionario, updatedFuncionarioDTO); }

}





