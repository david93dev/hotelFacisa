package br.com.unifacisa.meuhotel.dto;

public record HotelRecordDTO(Integer idFuncionario, String cpf, String nome, String endereco, String numeroTelefone, String dataNascimento, String cargo, String turnoTrabalho, double salario) {
}
