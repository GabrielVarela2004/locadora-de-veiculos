package dominio;



public abstract class Veiculo {

    protected String placa;
    protected String modelo;
    protected int ano;
    protected double valorDiariaBase;
    protected StatusVeiculo status;
    protected Cliente clienteAtual;

    public static final double TAXA_HIGIENIZACAO = 35.0;

    public Veiculo(String placa, String modelo, int ano, double valorDiariaBase, StatusVeiculo status, Cliente clienteAtual) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiariaBase = valorDiariaBase;
        this.status = StatusVeiculo.DISPONIVEL;
        this.clienteAtual = null;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getValorDiariaBase() {
        return valorDiariaBase;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", valorDiariaBase=" + valorDiariaBase +
                ", status=" + status +
                ", clienteAtual=" + clienteAtual +
                '}';
    }

    public abstract double calcularDiariaTotal();
}
