package br.com.unifacisa.meuhotel.services;

import br.com.unifacisa.meuhotel.dto.ReservaRecordDTO;
import br.com.unifacisa.meuhotel.entities.Hospede;
import br.com.unifacisa.meuhotel.entities.Quarto;
import br.com.unifacisa.meuhotel.entities.Reserva;
import br.com.unifacisa.meuhotel.repository.HospedeRepository;
import br.com.unifacisa.meuhotel.repository.QuartoRepository;
import br.com.unifacisa.meuhotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final HospedeRepository hospedeRepository;
    private final QuartoRepository quartoRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, HospedeRepository hospedeRepository, QuartoRepository quartoRepository) {
        this.reservaRepository = reservaRepository;
        this.hospedeRepository = hospedeRepository;
        this.quartoRepository = quartoRepository;
    }

    public Reserva save(ReservaRecordDTO reservaRecordDTO) {
        Reserva reserva = new Reserva();

        Hospede hospede = hospedeRepository.findById(reservaRecordDTO.hospede().getIdHospede()).get();
        Quarto quarto = quartoRepository.findById(reservaRecordDTO.quarto().getIdQuarto()).get();

        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);
        reserva.setDataInicioReserva(reservaRecordDTO.dataInicioReserva());
        reserva.setDataFimReserva(reservaRecordDTO.dataFimReserva());
        reserva.setStatusReserva(reservaRecordDTO.statusReserva());

        return reservaRepository.save(reserva);
    }

    public List<Reserva> getAll() {
        return reservaRepository.findAll();
    }

    public void delete(Integer idReserva) {
        reservaRepository.deleteById(idReserva);
    }

    public Reserva update(Integer idReserva, ReservaRecordDTO updatedReservaDTO) {
        Reserva reserva = reservaRepository.findById(idReserva).get();

        Hospede hospede = hospedeRepository.findById(updatedReservaDTO.hospede().getIdHospede()).get();
        Quarto quarto = quartoRepository.findById(updatedReservaDTO.quarto().getIdQuarto()).get();

        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);
        reserva.setDataInicioReserva(updatedReservaDTO.dataInicioReserva());
        reserva.setDataFimReserva(updatedReservaDTO.dataFimReserva());
        reserva.setStatusReserva(updatedReservaDTO.statusReserva());
        return reservaRepository.save(reserva);
    }

}