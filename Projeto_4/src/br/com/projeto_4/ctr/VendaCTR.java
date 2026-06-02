package br.com.projeto_4.ctr;

/**
 * Importando as classes necessárias para trabalhar nesta classe
 */
import br.com.projeto_4.dao.ConexaoDAO;
import br.com.projeto_4.dao.VendaDAO;
import br.com.projeto_4.dto.VendaDTO;
import br.com.projeto_4.dto.ClienteDTO;
import javax.swing.JTable;


public class VendaCTR {
    VendaDAO vendaDAO = new VendaDAO();

    /**
     * Método construtor da classe
     */
    public VendaCTR() {
    }

    /**
     * Método utilizado para controlar o acesso ao método inserirVenda da
     * classe VendaDAO
     * @param vendaDTO, que vem da classe da página (VIEW) 
     * @param clienteDTO, que vem da classe da página (VIEW) 
     * @param produtos, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos)) {
                return "Venda Cadastrada com Sucesso!!!";
            } else {
                return "Venda NÃO Cadastrada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem 
        //no console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Venda NÃO Cadastrada";
        }
    }//Fecha o método inserirVenda

    
    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

}//Fecha a classe VendaCTR
