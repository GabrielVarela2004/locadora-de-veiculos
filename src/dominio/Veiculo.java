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
