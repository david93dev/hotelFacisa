package br.com.unifacisa.meuhotel.dto;

import br.com.unifacisa.meuhotel.entities.Hospede;
import br.com.unifacisa.meuhotel.entities.Quarto;

public record ReservaRecordDTO(Integer idReserva, Integer hotelId, Hospede hospede, Quarto quarto, String dataInicioReserva, String dataFimReserva, String statusReserva) {

}
