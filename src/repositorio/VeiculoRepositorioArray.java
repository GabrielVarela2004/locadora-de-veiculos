package repositorio;

import dominio.Veiculo;

public class VeiculoRepositorioArray implements VeiculoRepositorio{

    public static final int TAMANHO_FROTA = 8;
    private final Veiculo[] frota = new Veiculo[TAMANHO_FROTA];

    @Override
    public boolean salvar(Veiculo veiculo) {
        for(int i = 0; i< this.frota.length; i++){
            if(frota[i] == null){
            frota[i] = veiculo;
            return true;
            }

        }
        return false;
    }

    @Override
    public Veiculo[] listarTodos() {
        int cont = 0;
        int index = 0;

        for(Veiculo v: this.frota){
            if(v != null){
                cont++;
            }
        }
        Veiculo[] frota2 = new Veiculo[cont];
        for(Veiculo v: this.frota){
            if(v!= null){
               frota2[index] = v;
               index++;
            }
        }

        return frota2;

    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
       for(Veiculo v: this.frota){
           if(v != null){
               if(v.getPlaca().equalsIgnoreCase(placa)){
                   return v;
               }
           }
       }
        return null;
    }
}
