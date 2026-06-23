package br.com.projeto_4.ctr;

/**
 * Importando as classes necessárias para trabalhar nesta classe
 */
import java.sql.ResultSet;
import br.com.projeto_4.dto.FuncionarioDTO;
import br.com.projeto_4.dao.FuncionarioDAO;
import br.com.projeto_4.dao.ConexaoDAO;


public class FuncionarioCTR {
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * Método construtor da classe
     */
    public FuncionarioCTR() {
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirFuncionario da
     * classe FuncionarioAO
     *
     * @param funcionarioDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionário Cadastrado com Sucesso!!!";
            } else {
                return "Funcinário NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO Cadastrado";
        }
    }//Fecha o método inserirFuncionario
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionário Alterado com Sucesso!!!";
            } else {
                return "Funcionário NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionário NÃO Alterado!!!";
        }
    }//Fecha o método alterarFuncionario

    
    /**
     * Método utilizado para controlar o acesso ao método excluirFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionário Excluído com Sucesso!!!";
            } else {
                return "Funcionário NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionário NÃO Excluído!!!";
        }
    }//Fecha o método excluirFuncionario

    
    /**
     * Método utilizado para controlar o acesso ao método consultarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do funcionario
     */
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;
    }//Fecha o método consultarCliente
    
    public String logarFuncionario(FuncionarioDTO dto){
        return funcionarioDAO.logarFuncionario(dto);
    }
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}//Fecha classe FuncionarioCTR
