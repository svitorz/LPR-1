/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.ctr;

import br.com.projeto_1.dao.ClienteDAO;
import br.com.projeto_1.dto.ClienteDTO;
import br.com.projeto_1.dao.ConexaoDAO;
import java.sql.ResultSet;
/**
 *
 * @author svitorz
 */
public class ClienteCTR {

    ClienteDAO dao = new ClienteDAO();

    public ClienteCTR() {
    }
    
    public String inserirCliString(ClienteDTO dto){
        try {
            if(dao.inserirCliente(dto)){
                return "Cliente inserido com sucesso!\n";
            } else {
                return "Erro ao inserir cliente\n";
            }
        } catch (Exception e) {
            return "Cliente não cadastrado.\n";
        } 
    }
}
