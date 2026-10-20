package dominio;

public enum TipoCliente {
    PESSOA_FISICA(0.0){
        public double calcularDesconto(double valorBruto){
            return valorBruto * 0.0;
        }
    },
    PESSOA_JURIDICA(0.10){
        public double calcularDesconto(double valorBruto){
            return valorBruto * 0.10;
        }
    };
    private double valorDesconto;

    TipoCliente(double VALOR_DESCONTO) {
        this.valorDesconto = VALOR_DESCONTO;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public abstract double calcularDesconto(double valorBruto);


}
