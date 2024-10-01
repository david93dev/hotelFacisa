package br.com.unifacisa.meuhotel.services;

import br.com.unifacisa.meuhotel.dto.HotelRecordDTO;
import br.com.unifacisa.meuhotel.entities.Hotel;
import br.com.unifacisa.meuhotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel save(HotelRecordDTO hotelRecordDTO) {
        Hotel hotel = new Hotel();

        hotel.setNome(hotelRecordDTO.nome());
        hotel.setEndereco(hotelRecordDTO.endereco());
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public void delete(Integer idFuncionario) {
        hotelRepository.deleteById(idFuncionario);
    }

    public Hotel update(Integer idFuncionario, HotelRecordDTO updatedFuncionarioDTO) {
        Hotel hotel = hotelRepository.findById(idFuncionario).get();

        hotel.setNome(updatedFuncionarioDTO.nome());
        hotel.setEndereco(updatedFuncionarioDTO.endereco());

        return hotelRepository.save(hotel);
    }

}
