package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO de ENTRADA do cadastro. A senha ENTRA aqui (so na entrada), e nunca sai.
// Por isso ele e separado do UsuarioDTO (a saida): um campo que entra mas nao sai
// e exatamente onde o "DTO unico" nao da mais conta.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCadastroDTO {
    private String nome;
    private String email;
    private String senha;
}
