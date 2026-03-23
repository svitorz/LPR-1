package br.com.projeto_avaliacao_1.ctr;

import java.sql.*;

import br.com.projeto_avaliacao_1.dao.ConexaoDAO;
import br.com.projeto_avaliacao_1.dao.VeiculoDAO;
import br.com.projeto_avaliacao_1.dto.VeiculoDTO;

public class VeiculoCTR {
  VeiculoDAO dao = new VeiculoDAO();

  public VeiculoCTR() {
  }

  public String inserirVeiculo(VeiculoDTO dto) {
    if (dao.inserirVeiculo(dto)) {
      return "Veículo inserido com sucesso!\n";
    } else {
      return "Houve um erro ao inserir veículo.\n";
    }
  }

  public ResultSet buscarVeiculo(VeiculoDTO dto, int opcao) {
    return dao.buscarVeiculo(dto, opcao);
  }

  public String alterarVeiculo(VeiculoDTO dto) {
    if (dao.alterarVeiculo(dto)) {
      return "Veículo atualizado com sucesso!\n";
    } else {
      return "Erro ao atualizar veículo.\n";
    }
  }

  public String excluirVeiculo(VeiculoDTO dto) {
    if (dao.excluirVeiculo(dto)) {
      return "Veículo excluído com sucesso!\n";
    } else {
      return "Erro ao excluir veículo.\n";
    }
  }

  public void CloseDbHelper() {
    ConexaoDAO.closeDB();
  }
}
