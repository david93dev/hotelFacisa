package br.com.unifacisa.meuhotel.services;

import br.com.unifacisa.meuhotel.dto.QuartoRecordDTO;
import br.com.unifacisa.meuhotel.entities.Quarto;
import br.com.unifacisa.meuhotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;

    @Autowired
    public QuartoService(QuartoRepository hospedeRepository) {
        this.quartoRepository = hospedeRepository;
    }

    public Quarto save(QuartoRecordDTO quartoRecordDTO) {
        Quarto quarto = new Quarto();

        quarto.setCapacidadeQuarto(quartoRecordDTO.capacidadeQuarto());
        quarto.setStatusQuarto(quartoRecordDTO.statusQuarto());
        quarto.setTipoQuarto(quartoRecordDTO.tipoQuarto());
        quarto.setValorQuarto(quartoRecordDTO.valorQuarto());
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
        quarto.setStatusQuarto(quartoRecordDTO.statusQuarto());
        quarto.setTipoQuarto(quartoRecordDTO.tipoQuarto());
        quarto.setValorQuarto(quartoRecordDTO.valorQuarto());
        return quartoRepository.save(quarto);
    }



}
