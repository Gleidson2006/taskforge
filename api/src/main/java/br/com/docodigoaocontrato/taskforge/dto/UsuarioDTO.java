package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO de SAIDA (a vitrine). Repare: NAO tem senha.
// O que sai da API mostra id, nome e email - nunca a senha.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
}
