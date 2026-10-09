package br.com.docodigoaocontrato.taskforge.service;
import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import br.com.docodigoaocontrato.taskforge.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    public ComentarioService(ComentarioRepository comentarioRepository){this.comentarioRepository=comentarioRepository;}
    public List<ComentarioDTO> buscarTodos(String autor){
        List<Comentario> comentarios;
        if (autor == null) comentarios = comentarioRepository.findAll();
        else comentarios = comentarioRepository.findByAutor(autor);
        return comentarios.stream().map(c -> toDto(c)).toList();
    }
    public Optional<ComentarioDTO> buscarPorId(Long id){
        return comentarioRepository.findById(id).map(c -> toDto(c));
    }
    public ComentarioDTO criarComentario(ComentarioDTO dto){
        return toDto(comentarioRepository.save(toEntity(dto)));
    }
    public Optional<ComentarioDTO> atualizarComentario(Long id, ComentarioDTO dto){
        Optional<Comentario> enc = comentarioRepository.findById(id);
        if (enc.isEmpty()) return Optional.empty();
        Comentario c = enc.get();
        c.setDescricao(dto.getDescricao()); c.setAutor(dto.getAutor());
        return Optional.of(toDto(comentarioRepository.save(c)));
    }
    public boolean deletarComentario(Long id){
        if (!comentarioRepository.existsById(id)) return false;
        comentarioRepository.deleteById(id); return true;
    }
    private ComentarioDTO toDto(Comentario c){ return new ComentarioDTO(c.getId(), c.getDescricao(), c.getAutor()); }
    private Comentario toEntity(ComentarioDTO d){ return new Comentario(d.getDescricao(), d.getAutor()); }
}
