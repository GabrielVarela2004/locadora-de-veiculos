package repositorio;

import dominio.Veiculo;

public interface VeiculoRepositorio {
    boolean salvar (Veiculo veiculo);

    Veiculo[] listarTodos();

    Veiculo buscarPorPlaca(String placa);
}
