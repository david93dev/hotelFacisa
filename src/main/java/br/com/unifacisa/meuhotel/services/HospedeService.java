package br.com.unifacisa.meuhotel.services;

import br.com.unifacisa.meuhotel.dto.HospedeRecordDTO;
import br.com.unifacisa.meuhotel.entities.Hospede;
import br.com.unifacisa.meuhotel.entities.Hotel;
import br.com.unifacisa.meuhotel.repository.HospedeRepository;
import br.com.unifacisa.meuhotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    private final HospedeRepository hospedeRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public HospedeService(HospedeRepository hospedeRepository, HotelRepository hotelRepository) {
        this.hospedeRepository = hospedeRepository;
        this.hotelRepository = hotelRepository;
    }

    public Hospede save(HospedeRecordDTO hospedeRecordDTO) {
        Hospede hospede = new Hospede();

        hospede.setHotelId(hospedeRecordDTO.hotelId());
        hospede.setNome(hospedeRecordDTO.nome());
        hospede.setEndereco(hospedeRecordDTO.endereco());
        hospede.setDataNascimento(hospedeRecordDTO.dataNascimento());
        hospede.setNumeroTelefone(hospedeRecordDTO.numeroTelefone());
        hospede.setCpf(hospedeRecordDTO.cpf());
        hospede.setTipoEstadia(hospedeRecordDTO.tipoEstadia());

        Hotel hotel = hotelRepository.findById(hospedeRecordDTO.hotelId())
                .orElse(new Hotel());

        hospede.setHospedesHotel(hotel);
        hotel.getHospedes().add(hospede);
        hotelRepository.save(hotel);

        return hospedeRepository.save(hospede);
    }

    public List<Hospede> getAll() {
        return hospedeRepository.findAll();
    }

    public void delete(Integer idHospede) {
        hospedeRepository.deleteById(idHospede);
    }

    public Hospede update(Integer idHospede, HospedeRecordDTO updatedHospedeDTO) {
        Hospede hospede = hospedeRepository.findById(idHospede).get();

        hospede.setNome(updatedHospedeDTO.nome());
        hospede.setEndereco(updatedHospedeDTO.endereco());
        hospede.setDataNascimento(updatedHospedeDTO.dataNascimento());
        hospede.setNumeroTelefone(updatedHospedeDTO.numeroTelefone());
        hospede.setCpf(updatedHospedeDTO.cpf());
        hospede.setTipoEstadia(updatedHospedeDTO.tipoEstadia());
        return hospedeRepository.save(hospede);
    }


}
