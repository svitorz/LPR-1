/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Projeto_Avaliacao_2.dao;

import br.com.Projeto_Avaliacao_2.dto.AutorDTO;
import java.sql.*;
/**
 *
 * @author svitorz
 */
public class AutorDAO {
    
    public AutorDAO() {
    }

    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    public boolean inserirAutor(AutorDTO autorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "INSERT INTO autor(nome, nacionalidade, data_nascimento, email, telefone) VALUES ('"
                    + autorDTO.getNome() + "', '"
                    + autorDTO.getNacionalidade() + "', '"
                    + autorDTO.getDataNascimento() + "', '"
                    + autorDTO.getEmail() + "', '"
                    + autorDTO.getTelefone() + "');";

            System.out.println(comando);
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarAutor(AutorDTO autorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "UPDATE autor SET nome = '" + autorDTO.getNome()
                    + "', nacionalidade = '" + autorDTO.getNacionalidade()
                    + "', data_nascimento = '" + autorDTO.getDataNascimento()
                    + "', email = '" + autorDTO.getEmail()
                    + "', telefone = '" + autorDTO.getTelefone()
                    + "' WHERE id = " + autorDTO.getId();
            //Executa o comando SQL no banco de Dados 
            System.out.println(comando);
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem 
        //no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirAutor(AutorDTO autorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "DELETE FROM autor WHERE id = " + autorDTO.getId();

            //Executa o comando SQL no banco de Dados
            System.out.println(comando);
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarAutor(AutorDTO autorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select c.* "
                            + "from autor c "
                            + "where UPPER(nome) like UPPER('" + autorDTO.getNome() + "%') "
                            + "order by c.nome";
                    break;
                case 2:
                    comando = "Select c.* "
                            + "from autor c "
                            + "where c.id = " + autorDTO.getId();
                    break;
                case 3:
                    comando = "Select c.id, c.nome "
                            + "from autor c "
                            + "order by c.nome";
                    break;

            }
            //Executa o comando SQL no banco de Dados
            System.out.println(comando);
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarCliente
}
