package dominio;

public enum StatusVeiculo {
    DISPONIVEL("Disponível"),
    ALUGADO("Alugado"),
    MANUTENCAO("Em Manutenção");
    String descricao;

    StatusVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
