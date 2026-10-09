package br.com.docodigoaocontrato.taskforge.controller;
import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.service.ComentarioService;
import org.springframework.http.HttpStatus; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.Optional;
@RestController
public class ComentarioController {
    private final ComentarioService comentarioService;
    public ComentarioController(ComentarioService comentarioService){this.comentarioService=comentarioService;}
    @GetMapping("/comentarios")
    public List<ComentarioDTO> listar(@RequestParam(required = false) String autor){
        return comentarioService.buscarTodos(autor);
    }
    @GetMapping("/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> buscarPorId(@PathVariable Long id){
        Optional<ComentarioDTO> c = comentarioService.buscarPorId(id);
        if (c.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c.get());
    }
    @PostMapping("/comentarios")
    public ResponseEntity<ComentarioDTO> criar(@RequestBody ComentarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.criarComentario(dto));
    }
    @PutMapping("/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> atualizar(@PathVariable Long id, @RequestBody ComentarioDTO dto){
        Optional<ComentarioDTO> at = comentarioService.atualizarComentario(id, dto);
        if (at.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(at.get());
    }
    @DeleteMapping("/comentarios/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (!comentarioService.deletarComentario(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
