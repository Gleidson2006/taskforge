package br.com.docodigoaocontrato.taskforge.repository;

import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // NOVO · nenhum SQL, nenhuma implementacao.
    // O Spring le o NOME do metodo: findBy + Concluida -> WHERE concluida = ?
    List<Tarefa> findByConcluida(boolean concluida);
}
