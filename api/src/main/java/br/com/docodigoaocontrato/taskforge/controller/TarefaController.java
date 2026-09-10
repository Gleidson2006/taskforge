package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaController {

    @GetMapping("/tarefas")
    public TarefaDTO Listar() {
        return new TarefaDTO(1,"Minha primeira Tarefa",1,false);
    }
}
