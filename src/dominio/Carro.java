package dominio;

public class Carro extends Veiculo implements Seguravel{

    protected int quantidadePortas;
    protected boolean possuiArCondicionado;

    public Carro(String placa, String modelo, int ano, double valorDiariaBase, StatusVeiculo status, Cliente clienteAtual, int quantidadePortas, boolean possuiArCondicionado) {
        super(placa, modelo, ano, valorDiariaBase, status, clienteAtual);
        this.quantidadePortas = quantidadePortas;
        this.possuiArCondicionado = possuiArCondicionado;
    }

    @Override
    public double calcularDiariaTotal() {
        double total = this.valorDiariaBase;
        if(possuiArCondicionado){
            total = total + 25;
        }
        return total;
    }

    @Override
    public double calcularValorSeguro() {
        return valorDiariaBase * 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + "Carro{" +
                "quantidadePortas=" + quantidadePortas +
                ", possuiArCondicionado=" + possuiArCondicionado +
                '}';
    }
}
