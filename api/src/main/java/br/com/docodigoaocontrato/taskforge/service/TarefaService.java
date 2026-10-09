package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // MUDOU · GET /tarefas e GET /tarefas?concluida=true
    // A decisao de "filtrar ou nao" e regra: mora aqui, nao na controller.
    public List<TarefaDTO> buscarTodos(Boolean concluida) {
        List<Tarefa> tarefas;
        if (concluida == null) {
            tarefas = tarefaRepository.findAll();
        } else {
            tarefas = tarefaRepository.findByConcluida(concluida);
        }
        return tarefas.stream()
                .map(tarefa -> toDto(tarefa))
                .toList();
    }

    // NOVO · GET /tarefas/{id}
    // Optional = a caixa que pode vir vazia. A Service NAO sabe o que e 404.
    public Optional<TarefaDTO> buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> toDto(tarefa));
    }

    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = toEntity(tarefaDTO);
        return toDto(tarefaRepository.save(tarefa));
    }

    // NOVO · PUT /tarefas/{id}
    // Primeiro busca. Se nao existe, a caixa volta vazia.
    // O id vem da URL, nunca do JSON.
    public Optional<TarefaDTO> atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Optional<Tarefa> encontrada = tarefaRepository.findById(id);
        if (encontrada.isEmpty()) {
            return Optional.empty();
        }

        Tarefa tarefa = encontrada.get();
        tarefa.setNome(tarefaDTO.getNome());
        tarefa.setPrioridade(tarefaDTO.getPrioridade());
        tarefa.setConcluida(tarefaDTO.isConcluida());

        return Optional.of(toDto(tarefaRepository.save(tarefa)));
    }

    // NOVO · DELETE /tarefas/{id}
    // Devolve se conseguiu. Quem traduz pra HTTP e a controller.
    public boolean deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            return false;
        }
        tarefaRepository.deleteById(id);
        return true;
    }

    private TarefaDTO toDto(Tarefa tarefa) {
        return new TarefaDTO(tarefa.getId(), tarefa.getNome(),
                tarefa.getPrioridade(), tarefa.isConcluida());
    }

    private Tarefa toEntity(TarefaDTO tarefaDTO) {
        return new Tarefa(tarefaDTO.getNome(), tarefaDTO.getPrioridade(),
                tarefaDTO.isConcluida());
    }
}
