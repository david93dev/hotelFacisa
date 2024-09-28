package br.com.unifacisa.meuhotel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncionario;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String numeroTelefone;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String turnoTrabalho;

    @Column(nullable = false)
    private double salario;
}
