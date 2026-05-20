/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.dao;

/**
 *
 * @author svitorz
 */
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.swing.JTable;

public class VendaDAO {

    public VendaDAO() {
    }

    private ResultSet rs = null;

    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();
            stmt1 = ConexaoDAO.conn.createStatement();

            String comando1 = "insert into venda(dat_vend, val_vend, id_cli) values ( "
                    + "to_date('" + date.format(vendaDTO.getDat_venda()) + "', 'DD/MM/YYYY'), "
                    + vendaDTO.getVal_venda() + ", "
                    + clienteDTO.getId_cli() + ");";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();

            for (int cont = 0; cont < produtos.getRowCount(); cont++) {
                String comando2 = "insert into produto_venda(id_vend, id_prod, val_prod, qtd_prod) values ("
                        + rs.getInt("id_venda") + ", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";
                
                stmt1.execute(comando2);
                        
            }
            
            ConexaoDAO.conn.commit();
            
            stmt.close();
            stmt1.close();
            rs.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }
}
