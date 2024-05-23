package br.com.fiap.gerenciamentotrafego.dto;

public record RuaCadastroDTO(
        Long idRua,
        String logradouro,
        Integer numero,
        String cep,
        String cidade,
        String estado
) {
}
