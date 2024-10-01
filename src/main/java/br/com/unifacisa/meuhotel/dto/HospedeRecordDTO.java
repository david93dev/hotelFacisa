package br.com.unifacisa.meuhotel.dto;

public record HospedeRecordDTO(Integer idHospede, Integer hotelId, String cpf, String nome, String endereco, String numeroTelefone, String dataNascimento, String tipoEstadia) {
}
