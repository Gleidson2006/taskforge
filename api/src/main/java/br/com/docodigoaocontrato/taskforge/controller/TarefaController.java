package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// A controller so traduz HTTP <-> Java. Os "if" daqui escolhem o codigo HTTP, nao regra.
@RestController
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // GET /tarefas            -> todas
    // GET /tarefas?concluida=true  -> so as concluidas
    // required = false: sem o parametro, concluida chega null
    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefaDTO>> listar(
            @RequestParam(required = false) Boolean concluida) {
        return ResponseEntity.ok(tarefaService.buscarTodos(concluida));
    }

    // GET /tarefas/2 -> 200 | 404
    @GetMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        Optional<TarefaDTO> tarefa = tarefaService.buscarPorId(id);
        if (tarefa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa.get());
    }

    // POST /tarefas -> 201
    @PostMapping("/tarefas")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    // PUT /tarefas/2 -> 200 | 404
    @PutMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id,
                                                     @RequestBody TarefaDTO tarefaDTO) {
        Optional<TarefaDTO> atualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada.get());
    }

    // DELETE /tarefas/2 -> 204 | 404
    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (!tarefaService.deletarTarefa(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
