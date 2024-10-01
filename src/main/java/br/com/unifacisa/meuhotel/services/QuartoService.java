package br.com.unifacisa.meuhotel.services;

import br.com.unifacisa.meuhotel.dto.QuartoRecordDTO;
import br.com.unifacisa.meuhotel.entities.Hotel;
import br.com.unifacisa.meuhotel.entities.Quarto;
import br.com.unifacisa.meuhotel.repository.HotelRepository;
import br.com.unifacisa.meuhotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public QuartoService(QuartoRepository hospedeRepository, HotelRepository hotelRepository) {
        this.quartoRepository = hospedeRepository;
        this.hotelRepository = hotelRepository;
    }

    public Quarto save(QuartoRecordDTO quartoRecordDTO) {
        Quarto quarto = new Quarto();

        quarto.setCapacidadeQuarto(quartoRecordDTO.capacidadeQuarto());
        quarto.setHotelId(quartoRecordDTO.hotelId());
        quarto.setStatusQuarto(quartoRecordDTO.statusQuarto());
        quarto.setTipoQuarto(quartoRecordDTO.tipoQuarto());
        quarto.setValorQuarto(quartoRecordDTO.valorQuarto());

        Hotel hotel = hotelRepository.findById(quartoRecordDTO.hotelId())
                .orElse(new Hotel());

        quarto.setQuartosHotel(hotel);
        hotel.getQuartos().add(quarto);
        hotelRepository.save(hotel);

        return quartoRepository.save(quarto);
    }

    public List<Quarto> getAll() {
        return quartoRepository.findAll();
    }

    public void delete(Integer idQuarto) {
        quartoRepository.deleteById(idQuarto);
    }

    public Quarto update(Integer idQuarto, QuartoRecordDTO quartoRecordDTO) {
        Quarto quarto = quartoRepository.findById(idQuarto).get();

        quarto.setCapacidadeQuarto(quartoRecordDTO.capacidadeQuarto());
        quarto.setHotelId(quartoRecordDTO.hotelId());
        quarto.setStatusQuarto(quartoRecordDTO.statusQuarto());
        quarto.setTipoQuarto(quartoRecordDTO.tipoQuarto());
        quarto.setValorQuarto(quartoRecordDTO.valorQuarto());
        return quartoRepository.save(quarto);
    }



}
