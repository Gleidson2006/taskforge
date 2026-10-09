package br.com.docodigoaocontrato.taskforge.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

// Responsavel so por UMA coisa: fabricar o cracha (o token JWT).
// Igual ao BCrypt, a gente INSTANCIA essa ferramenta com new la no service.
public class JwtService {

    // EM PRODUCAO este segredo vai pra uma variavel de ambiente - NUNCA no codigo.
    // Aqui, pra aula, deixamos fixo (precisa ter pelo menos 32 caracteres).
    private static final String SEGREDO = "do-codigo-ao-contrato-segredo-super-secreto-32+";

    private final SecretKey chave = Keys.hmacShaKeyFor(SEGREDO.getBytes(StandardCharsets.UTF_8));

    // uma hora de validade
    private static final long UMA_HORA = 1000L * 60 * 60;

    public String gerarToken(String email) {
        return Jwts.builder()
                .subject(email)                                       // de quem e o cracha
                .issuedAt(new Date())                                 // quando foi emitido
                .expiration(new Date(System.currentTimeMillis() + UMA_HORA)) // ate quando vale
                .signWith(chave)                                      // a assinatura (o lacre)
                .compact();                                           // vira a String do token
    }
}
