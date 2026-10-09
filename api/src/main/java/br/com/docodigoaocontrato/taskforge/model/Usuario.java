package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // email nao pode repetir: dois usuarios com o mesmo email nao faz sentido.
    @Column(unique = true)
    private String email;

    // a senha fica no ESTOQUE (a entidade). Ela NUNCA vai pra VITRINE (o DTO de saida).
    // e aqui ela ja entra criptografada - texto puro nunca encosta no banco.
    private String senha;

    // construtor SEM id - quem numera e o banco. E o que o toEntity usa.
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
