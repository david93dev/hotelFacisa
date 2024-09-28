package br.com.unifacisa.meuhotel.controller;

import br.com.unifacisa.meuhotel.dto.ReservaRecordDTO;
import br.com.unifacisa.meuhotel.entities.Reserva;
import br.com.unifacisa.meuhotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> getAllReserva() {
        return reservaService.getAll();
    }

    @PostMapping
    public Reserva createReserva(@RequestBody ReservaRecordDTO reservaRecordDTO) {
        return reservaService.save(reservaRecordDTO);
    }

    @DeleteMapping("/{idReserva}")
    public void deleteReserva(@PathVariable Integer idReserva) {
        reservaService.delete(idReserva);
    }

    @PutMapping("/{idReserva}")
    public Reserva updateReserva(@PathVariable Integer idReserva, @RequestBody ReservaRecordDTO updatedReservaDTO) {
        return reservaService.update(idReserva, updatedReservaDTO); }
}
