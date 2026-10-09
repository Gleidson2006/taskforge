package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO de SAIDA do login: o cracha (token JWT) que o usuario recebe quando a senha confere.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private String token;
}
