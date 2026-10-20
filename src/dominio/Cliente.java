package dominio;

public class Cliente {
    String nome;
    String documento;
    TipoCliente tipoCliente;

    public Cliente(String nome, String documento, TipoCliente tipoCliente) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
