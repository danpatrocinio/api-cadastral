package com.cadastral.entidy;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/* Requisitos:

        Nome - obrigatório
        Sexo
        E-mail - não obrigatório, deve ser validado caso preenchido
        Data de Nascimento - obrigatório, deve ser validada
        Naturalidade
        Nacionalidade
        CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)
        Obs: a data de cadastro e atualização dos dados devem ser armazenados.
*/

@Data
@NoArgsConstructor
@Entity
@Audited
public class Pessoa extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @CPF(message = "{Generic.invalid.cpf}")
    @Column(unique = true)
    @NotNull(message = "{Pessoa.cpf.NotNull}")
    private String cpf;
    @NotNull(message = "{Pessoa.nome.NotNull}")
    private String nome;
    private String sexo;
    @Email(message = "{Generic.invalid.email}")
    private String email;
    @Past(message = "{Pessoa.dtNascimento.Past}")
    @NotNull(message = "{Pessoa.dtNascimento.NotNull}")
    private Date dataNascimento;
    private String naturalidade;
    private String nacionalidade;

}
