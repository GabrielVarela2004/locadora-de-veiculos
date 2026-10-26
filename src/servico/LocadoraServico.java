package servico;

import dominio.*;
import repositorio.VeiculoRepositorio;

import static dominio.StatusVeiculo.ALUGADO;
import static dominio.StatusVeiculo.DISPONIVEL;


public class LocadoraServico {
    private final VeiculoRepositorio REPOSITORIO;

    public LocadoraServico(VeiculoRepositorio REPOSITORIO) {
        this.REPOSITORIO = REPOSITORIO;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo){
        if(veiculo == null){
            return false;
        }
        String placa = veiculo.getPlaca();
        String modelo = veiculo.getModelo();
        int ano = veiculo.getAno();
        double valorDiariaBase = veiculo.getValorDiariaBase();

        if(placa == null || placa.trim().isEmpty()){
            return false;
        }

        if(REPOSITORIO.buscarPorPlaca(placa) != null){
            return false;
        }

        if(modelo == null || modelo.trim().isEmpty()){
            return false;
        }

        if(ano < 1990){
            return false;
        }

        if(valorDiariaBase <= 0){
            return false;
        }

        if( veiculo instanceof Carro c){
            if(c.getQuantidadePortas() < 2){
                return false;
            }
        }

        if(veiculo instanceof Moto m){
            if(m.getCilindradas() < 50) {
                return false;
            }
        }

        if(veiculo instanceof Caminhao C){
            if(C.getCapacidadeTonelada() <= 0){
                return false;
            }
        }

        return REPOSITORIO.salvar(veiculo);



    }

    public Veiculo[] listarFrota(){
         return REPOSITORIO.listarTodos();
    }

    public Veiculo buscarVeiculoPorPlaca(String placa){
        return REPOSITORIO.buscarPorPlaca(placa);
    }

    public boolean alugarVeiculo(String placa, Cliente cliente){
        if(placa == null || cliente == null){
            return false;
        }
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if(cliente.getNome() == null || cliente.getDocumento() == null){
            return false;
        }

        if(cliente.getNome().trim().isEmpty() || cliente.getDocumento().trim().isEmpty()){
            return false;
        }

        if(veiculo == null || veiculo.getStatus() != DISPONIVEL){
            return false;
        }

        veiculo.setStatus(ALUGADO);
        veiculo.setClienteAtual(cliente);

        return true;
    }

   public boolean devolverVeiculo(String placa){
        Veiculo veiculo = REPOSITORIO.buscarPorPlaca(placa);

        if(veiculo == null){
            return false;
        }

        if(veiculo.getStatus() != ALUGADO){
            return false;
        }

        if(veiculo != null && veiculo.getStatus() == ALUGADO){
            veiculo.setStatus(DISPONIVEL);
            veiculo.setClienteAtual(null);
        }
        return true;
   }

   public double simularOrcamento(String placa, int dias, TipoCliente tipoCliente){
        if(dias <= 0 || tipoCliente == null){
            return -1;
        }

        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if(veiculo == null){
            return -1;
        }

        double total = veiculo.calcularDiariaTotal() * dias;
        if(veiculo instanceof Seguravel){
            Seguravel seg = (Seguravel) veiculo;
            total = total + (seg.calcularValorSeguro() * dias);
        }

       total = total + Veiculo.TAXA_HIGIENIZACAO;
       total = total - tipoCliente.calcularDesconto(total);
       return total;
   }

   public void exibirRelatorioEspecifico(Veiculo veiculo){
        if(veiculo == null){
            return;
        }

        if(veiculo instanceof Seguravel){
            System.out.println("Veículo tem Seguro");
        }

        if(veiculo instanceof Moto){
            ((Moto) veiculo).verificarCategoriaCilindrada();
        }

   }

}
