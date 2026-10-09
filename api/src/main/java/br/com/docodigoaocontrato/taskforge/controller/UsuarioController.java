package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.LoginDTO;
import br.com.docodigoaocontrato.taskforge.dto.TokenDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ---- 7.1: cadastro ----
    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioCadastroDTO dto) {
        Optional<UsuarioDTO> criado = usuarioService.cadastrar(dto);
        if (criado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();   // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(criado.get()); // 201
    }

    // ---- 7.2: login ----
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {
        Optional<TokenDTO> token = usuarioService.login(dto);
        if (token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401
        }
        return ResponseEntity.ok(token.get());                            // 200 + token
    }
}
