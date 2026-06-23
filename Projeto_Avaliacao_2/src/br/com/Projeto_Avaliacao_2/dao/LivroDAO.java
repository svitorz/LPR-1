/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Projeto_Avaliacao_2.dao;

import br.com.Projeto_Avaliacao_2.dto.AutorDTO;
import br.com.Projeto_Avaliacao_2.dto.CategoriaDTO;
import br.com.Projeto_Avaliacao_2.dto.LivroDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author svitorz
 */
public class LivroDAO {

    public LivroDAO() {
    }

    private ResultSet rs = null;
    private Statement stmtLivro = null;
    private Statement stmtCategoria = null;

    public boolean inserirLivro(LivroDTO livroDTO, CategoriaDTO categoriaDTO, AutorDTO autorDTO) {
        try {
            ConexaoDAO.ConnectDB();
            stmtLivro = ConexaoDAO.con.createStatement();

            String comando = "INSERT INTO livro(titulo, ano_publicacao, isbn, editora, edicao, quantidade_paginas, id_categoria) "
                    + "VALUES ('" + livroDTO.getTitulo() + "', "
                    + livroDTO.getAnoPublicacao() + ", '"
                    + livroDTO.getIsbn() + "', '"
                    + livroDTO.getEditora() + "', "
                    + livroDTO.getEdicao() + ", "
                    + livroDTO.getQuantidadePaginas() + ", "
                    + categoriaDTO.getId() + ");";

            System.out.println(comando);
            stmtLivro.execute(comando, Statement.RETURN_GENERATED_KEYS);
            rs = stmtLivro.getGeneratedKeys();
            rs.next();

            String comando2 = "INSERT INTO livro_autor (id_livro, id_autor) VALUES (" + rs.getInt("id") + ", " + autorDTO.getId() + ");";
            System.out.println(comando2);
            stmtLivro.execute(comando2);
            ConexaoDAO.con.commit();
            stmtLivro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarLivro(LivroDTO livroDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();
            stmtLivro = ConexaoDAO.con.createStatement();

            String comando = "";
            switch (opcao) {
                case 1:
                    // Busca por título com categoria e autores
                    comando = "SELECT l.id, l.titulo, l.ano_publicacao, l.isbn, l.editora, l.edicao, "
                            + "l.quantidade_paginas, c.nome AS categoria, "
                            + "COALESCE(string_agg(DISTINCT a.nome, ', ' ORDER BY a.nome), '') AS autores "
                            + "FROM livro l "
                            + "LEFT JOIN categoria c ON c.id = l.id_categoria "
                            + "LEFT JOIN livro_autor la ON la.id_livro = l.id "
                            + "LEFT JOIN autor a ON a.id = la.id_autor "
                            + "WHERE l.titulo LIKE '" + livroDTO.getTitulo() + "%' "
                            + "GROUP BY l.id, c.nome "
                            + "ORDER BY l.titulo";
                    break;
                case 2:
                    // Busca por ID
                    comando = "SELECT l.* FROM livro l "
                            + "WHERE l.id = " + livroDTO.getId();
                    break;
                case 3:
                    // Busca por categoria (lista todos de uma categoria)
                    comando = "SELECT l.* FROM livro l "
                            + "WHERE l.id_categoria = " + livroDTO.getIdCategoria()
                            + " ORDER BY l.titulo";
                    break;
                case 4:
                    // Lista todos
                    comando = "SELECT l.* FROM livro l ORDER BY l.titulo";
                    break;
            }

            System.out.println(comando);
            rs = stmtLivro.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public ResultSet listarLivros() {
        try {
            ConexaoDAO.ConnectDB();
            stmtLivro = ConexaoDAO.con.createStatement();

            String comando = "SELECT l.id, l.titulo, l.ano_publicacao, l.isbn, l.editora, l.edicao, "
                    + "l.quantidade_paginas, c.nome AS categoria, "
                    + "COALESCE(string_agg(DISTINCT a.nome, ', ' ORDER BY a.nome), '') AS autores "
                    + "FROM livro l "
                    + "LEFT JOIN categoria c ON c.id = l.id_categoria "
                    + "LEFT JOIN livro_autor la ON la.id_livro = l.id "
                    + "LEFT JOIN autor a ON a.id = la.id_autor "
                    + "GROUP BY l.id, c.nome "
                    + "ORDER BY l.titulo";

            System.out.println(comando);
            rs = stmtLivro.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
