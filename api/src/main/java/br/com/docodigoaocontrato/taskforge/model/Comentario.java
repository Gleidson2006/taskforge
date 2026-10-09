package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String autor;

    // construtor SEM id — usado pelo toEntity (quem numera é o banco)
    public Comentario(String descricao, String autor) {
        this.descricao = descricao;
        this.autor = autor;
    }
}
