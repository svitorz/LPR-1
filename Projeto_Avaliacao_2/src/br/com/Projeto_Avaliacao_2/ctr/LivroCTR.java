/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Projeto_Avaliacao_2.ctr;

import br.com.Projeto_Avaliacao_2.dao.CategoriaDAO;
import br.com.Projeto_Avaliacao_2.dao.ConexaoDAO;
import br.com.Projeto_Avaliacao_2.dao.LivroDAO;
import br.com.Projeto_Avaliacao_2.dto.LivroDTO;
import br.com.Projeto_Avaliacao_2.dao.LivroDAO;
import br.com.Projeto_Avaliacao_2.dto.AutorDTO;
import br.com.Projeto_Avaliacao_2.dto.CategoriaDTO;
import br.com.Projeto_Avaliacao_2.dto.LivroDTO;
import java.sql.ResultSet;
/**
 *
 * @author svitorz
 */
public class LivroCTR {
    private LivroDAO livroDAO = new LivroDAO();

    public String inserirLivroString(LivroDTO livroDTO, CategoriaDTO categoriaDTO, AutorDTO autorDTO) {
        try {
            if (livroDAO.inserirLivro(livroDTO, categoriaDTO, autorDTO)) {
                return "Livro inserido com sucesso.";
            } else {
                return "Livro não inserido.";
            }
        } catch (Exception erTab) {
            return "Erro ao inserir Livro.\n" + erTab;
        }
    }

    public ResultSet consultarLivro(LivroDTO livroDTO, int opcao) {
        try {
            return livroDAO.consultarLivro(livroDTO, opcao);
        } catch (Exception erTab) {
            System.out.println("Erro ao consultar Livro.\n" + erTab);
            return null;
        }
    } 

    public ResultSet listarLivros() {
        try {
            return livroDAO.listarLivros();
        } catch (Exception erTab) {
            System.out.println("Erro ao listar Livros.\n" + erTab);
            return null;
        }
    }
    
    public void closeDB() {
        try {
            ConexaoDAO.CloseDB();
        } catch (Exception e) {
            System.out.println("erro ao fechar banco.");
        }
    }
}
