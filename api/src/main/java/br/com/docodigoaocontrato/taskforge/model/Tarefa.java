package br.com.docodigoaocontrato.taskforge.model;

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
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int prioridade;
    private boolean concluida;

    // Gerado no IntelliJ na 6.1 (Generate > Constructor), SEM o id:
    // quem numera a tarefa e o banco. E o que o toEntity usa.
    public Tarefa(String nome, int prioridade, boolean concluida) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }
}
