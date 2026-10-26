package dominio;

public class Moto extends Veiculo{
    int cilindradas;

    public Moto(String placa, String modelo, int ano, double valorDiariaBase, StatusVeiculo status, Cliente clienteAtual, int cilindradas) {
        super(placa, modelo, ano, valorDiariaBase, status, clienteAtual);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularDiariaTotal() {
        double total = this.valorDiariaBase;
        if(this.cilindradas > 300){
            total = total + 15;
        }
        return total;
    }

    public String verificarCategoriaCilindrada() {
        if (this.cilindradas <= 300) {
            return "Urbana";
        }
        return "Esportiva/Estrada";

    }

    @Override
    public String toString() {
        return super.toString() + "Moto{" +
                "cilindradas=" + cilindradas +
                '}';
    }

    public int getCilindradas() {
        return cilindradas;
    }
}
