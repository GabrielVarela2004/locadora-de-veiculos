package dominio;

public final class Caminhao extends Veiculo implements Seguravel{

    private double capacidadeTonelada;

    public Caminhao(String placa, String modelo, int ano, double valorDiariaBase, StatusVeiculo status, Cliente clienteAtual, double capacidadeTonelada) {
        super(placa, modelo, ano, valorDiariaBase, status, clienteAtual);
        this.capacidadeTonelada = capacidadeTonelada;
    }

    @Override
    public double calcularValorSeguro() {
        return 80 + (this.capacidadeTonelada * 10.0);
    }

    @Override
    public double calcularDiariaTotal() {
        return valorDiariaBase + (capacidadeTonelada * 30.0);
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacidadetonelada=" + capacidadeTonelada +
                '}';
    }

    public double getCapacidadeTonelada() {
        return capacidadeTonelada;
    }
}
