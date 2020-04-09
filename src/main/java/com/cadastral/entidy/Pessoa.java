package com.cadastral.entidy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @CPF
    @Column(unique = true)
    @NotNull(message = "{Pessoa.cpf.NotNull}")
    private String cpf;
    @NotNull(message = "{Pessoa.nome.NotNull}")
    private String nome;
    private String sexo;
    @Email
    private String email;
    @Past(message = "{Pessoa.dtNascimento.Past}")
    @NotNull(message = "{Pessoa.dtNascimento.NotNull}")
    private Date dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    @CreatedDate
    private LocalDateTime dtCreated;
    @LastModifiedDate
    private LocalDateTime dtUpdated;
}
