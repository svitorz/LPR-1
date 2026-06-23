package br.com.Projeto_Avaliacao_2.view;

import br.com.Projeto_Avaliacao_2.ctr.AutorCTR;
import br.com.Projeto_Avaliacao_2.ctr.CategoriaCTR;
import br.com.Projeto_Avaliacao_2.ctr.LivroCTR;
import br.com.Projeto_Avaliacao_2.dto.AutorDTO;
import br.com.Projeto_Avaliacao_2.dto.CategoriaDTO;
import br.com.Projeto_Avaliacao_2.dto.LivroDTO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class LivroVIEW extends javax.swing.JInternalFrame {

    private LivroDTO livroDTO;
    private LivroCTR livroCTR;
    private CategoriaDTO categoriaDTO;
    private CategoriaCTR categoriaCTR;
    private AutorDTO autorDTO;
    private AutorCTR autorCTR;
    private int gravar_alterar;
    private ResultSet rs;
    private DefaultTableModel modelo_jtl_consultar_categoria;
    private DefaultTableModel modelo_jtl_consultar_autor;
    private DefaultTableModel modelo_jtl_consultar_livro;

    private JLabel jLabel_titulo;
    private JLabel jLabel_ano_publicacao;
    private JLabel jLabel_isbn;
    private JLabel jLabel_editora;
    private JLabel jLabel_edicao;
    private JLabel jLabel_quantidade_paginas;
    private JLabel jLabel_categoria;
    private JLabel jLabel_autor;
    private JLabel jLabel_pesquisa_categoria;
    private JLabel jLabel_pesquisa_autor;
    private JLabel jLabel_pesquisa_livro;
    private JLabel jLabel_lista_livros;
    private JTextField txt_titulo;
    private JTextField txt_ano_publicacao;
    private JTextField txt_isbn;
    private JTextField txt_editora;
    private JTextField txt_edicao;
    private JTextField txt_quantidade_paginas;
    private JTextField txt_pesquisa_categoria;
    private JTextField txt_pesquisa_autor;
    private JTextField txt_pesquisa_livro;
    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JButton btnSair;
    private JButton btnPesquisarCategoria;
    private JButton btnPesquisarAutor;
    private JButton btnPesquisarLivro;
    private JTable jtl_consultar_categoria;
    private JTable jtl_consultar_autor;
    private JTable jtl_consultar_livro;
    private JScrollPane jScrollPane_categoria;
    private JScrollPane jScrollPane_autor;
    private JScrollPane jScrollPane_livro;

    public LivroVIEW() {
        initComponents();
        livroDTO = new LivroDTO();
        livroCTR = new LivroCTR();
        categoriaDTO = new CategoriaDTO();
        categoriaCTR = new CategoriaCTR();
        autorDTO = new AutorDTO();
        autorCTR = new AutorCTR();
        gravar_alterar = 0;
        liberaCampos(false);
        liberaBotoes(true, false, false, true);
        modelo_jtl_consultar_categoria = (DefaultTableModel) jtl_consultar_categoria.getModel();
        modelo_jtl_consultar_autor = (DefaultTableModel) jtl_consultar_autor.getModel();
        modelo_jtl_consultar_livro = (DefaultTableModel) jtl_consultar_livro.getModel();
        preencheTabela_Categoria("");
        preencheTabela_Autor("");
        preencheTabela_Livro();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                setPosicao();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel_titulo = new JLabel();
        jLabel_ano_publicacao = new JLabel();
        jLabel_isbn = new JLabel();
        jLabel_editora = new JLabel();
        jLabel_edicao = new JLabel();
        jLabel_quantidade_paginas = new JLabel();
        jLabel_categoria = new JLabel();
        jLabel_autor = new JLabel();
        jLabel_pesquisa_categoria = new JLabel();
        jLabel_pesquisa_autor = new JLabel();
        jLabel_pesquisa_livro = new JLabel();
        jLabel_lista_livros = new JLabel();
        txt_titulo = new JTextField();
        txt_ano_publicacao = new JTextField();
        txt_isbn = new JTextField();
        txt_editora = new JTextField();
        txt_edicao = new JTextField();
        txt_quantidade_paginas = new JTextField();
        txt_pesquisa_categoria = new JTextField();
        txt_pesquisa_autor = new JTextField();
        txt_pesquisa_livro = new JTextField();
        btnNovo = new JButton();
        btnSalvar = new JButton();
        btnCancelar = new JButton();
        btnSair = new JButton();
        btnPesquisarCategoria = new JButton();
        btnPesquisarAutor = new JButton();
        btnPesquisarLivro = new JButton();
        jScrollPane_categoria = new JScrollPane();
        jScrollPane_autor = new JScrollPane();
        jScrollPane_livro = new JScrollPane();
        jtl_consultar_categoria = new JTable();
        jtl_consultar_autor = new JTable();
        jtl_consultar_livro = new JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Livro");

        jLabel_titulo.setText("Titulo");
        jLabel_ano_publicacao.setText("Ano Publicacao");
        jLabel_isbn.setText("ISBN");
        jLabel_editora.setText("Editora");
        jLabel_edicao.setText("Edicao");
        jLabel_quantidade_paginas.setText("Quantidade de Paginas");
        jLabel_categoria.setText("Categoria");
        jLabel_autor.setText("Autor");
        jLabel_pesquisa_categoria.setText("Pesquisar Categoria");
        jLabel_pesquisa_autor.setText("Pesquisar Autor");
        jLabel_pesquisa_livro.setText("Pesquisar Livro");
        jLabel_lista_livros.setText("Livros");

        txt_titulo.setColumns(20);
        txt_ano_publicacao.setColumns(20);
        txt_isbn.setColumns(20);
        txt_editora.setColumns(20);
        txt_edicao.setColumns(20);
        txt_quantidade_paginas.setColumns(20);
        txt_pesquisa_categoria.setColumns(20);
        txt_pesquisa_autor.setColumns(20);
        txt_pesquisa_livro.setColumns(20);

        btnNovo.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/novo.png")));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                limpaCampos();
                liberaCampos(true);
                liberaBotoes(false, true, true, true);
                gravar_alterar = 1;
                livroDTO.setId(0);
                livroDTO.setIdCategoria(0);
                categoriaDTO.setId(0);
                autorDTO.setId(0);
                preencheTabela_Categoria("");
                preencheTabela_Autor("");
                preencheTabela_Livro();
            }
        });

        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/salvar.png")));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (gravar_alterar == 1) {
                    if (gravar()) {
                        limpaCampos();
                        liberaCampos(false);
                        liberaBotoes(true, false, false, true);
                        gravar_alterar = 0;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Clique em Novo para incluir um livro.");
                }
            }
        });

        btnCancelar.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/cancelar.png")));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                limpaCampos();
                liberaCampos(false);
                liberaBotoes(true, false, false, true);
                gravar_alterar = 0;
                categoriaDTO.setId(0);
                autorDTO.setId(0);
                preencheTabela_Categoria("");
                preencheTabela_Autor("");
                preencheTabela_Livro();
            }
        });

        btnSair.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/sair.png")));
        btnSair.setText("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        btnPesquisarCategoria.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/pesquisar.png")));
        btnPesquisarCategoria.setText("Pesquisar");
        btnPesquisarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                preencheTabela_Categoria(txt_pesquisa_categoria.getText());
            }
        });

        btnPesquisarAutor.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/pesquisar.png")));
        btnPesquisarAutor.setText("Pesquisar");
        btnPesquisarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                preencheTabela_Autor(txt_pesquisa_autor.getText());
            }
        });

        btnPesquisarLivro.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/pesquisar.png")));
        btnPesquisarLivro.setText("Pesquisar");
        btnPesquisarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                preencheTabela_Livro(txt_pesquisa_livro.getText());
            }
        });

        jtl_consultar_categoria.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome"}
        ) {
            boolean[] canEdit = new boolean[]{false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jtl_consultar_categoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int linha = jtl_consultar_categoria.getSelectedRow();
                if (linha >= 0) {
                    int id = Integer.parseInt(jtl_consultar_categoria.getValueAt(linha, 0).toString());
                    categoriaDTO.setId(id);
                }
            }
        });
        jScrollPane_categoria.setViewportView(jtl_consultar_categoria);

        jtl_consultar_autor.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome"}
        ) {
            boolean[] canEdit = new boolean[]{false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jtl_consultar_autor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int linha = jtl_consultar_autor.getSelectedRow();
                if (linha >= 0) {
                    int id = Integer.parseInt(jtl_consultar_autor.getValueAt(linha, 0).toString());
                    autorDTO.setId(id);
                }
            }
        });
        jScrollPane_autor.setViewportView(jtl_consultar_autor);

        jtl_consultar_livro.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Titulo", "Ano", "ISBN", "Editora", "Edicao", "Paginas", "Categoria", "Autores"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane_livro.setViewportView(jtl_consultar_livro);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_titulo)
                                                        .addComponent(txt_titulo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_ano_publicacao)
                                                        .addComponent(txt_ano_publicacao, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_isbn)
                                                        .addComponent(txt_isbn, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_editora)
                                                        .addComponent(txt_editora, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_edicao)
                                                        .addComponent(txt_edicao, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_quantidade_paginas)
                                                        .addComponent(txt_quantidade_paginas, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_categoria)
                                                        .addComponent(jLabel_pesquisa_categoria)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txt_pesquisa_categoria, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnPesquisarCategoria))
                                                        .addComponent(jScrollPane_categoria, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_autor)
                                                        .addComponent(jLabel_pesquisa_autor)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txt_pesquisa_autor, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnPesquisarAutor))
                                                        .addComponent(jScrollPane_autor, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnNovo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSalvar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancelar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSair))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_lista_livros)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_pesquisa_livro)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_pesquisa_livro, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnPesquisarLivro))
                                        .addComponent(jScrollPane_livro))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_titulo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel_ano_publicacao)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_ano_publicacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel_isbn)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_isbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel_editora)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_editora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel_edicao)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_edicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel_quantidade_paginas)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_quantidade_paginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_categoria)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_pesquisa_categoria)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txt_pesquisa_categoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnPesquisarCategoria))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane_categoria, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_autor)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_pesquisa_autor)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txt_pesquisa_autor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnPesquisarAutor))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane_autor, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNovo)
                                        .addComponent(btnSalvar)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnSair))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_lista_livros)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_pesquisa_livro)
                                        .addComponent(txt_pesquisa_livro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPesquisarLivro))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane_livro, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private boolean gravar() {
        String titulo = txt_titulo.getText().trim();
        String anoPublicacaoTexto = txt_ano_publicacao.getText().trim();
        String isbn = txt_isbn.getText().trim();
        String editora = txt_editora.getText().trim();
        String edicaoTexto = txt_edicao.getText().trim();
        String quantidadePaginasTexto = txt_quantidade_paginas.getText().trim();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o titulo do livro.");
            return false;
        }
        if (anoPublicacaoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o ano de publicação do livro.");
            return false;
        }
        if (isbn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o ISBN do livro.");
            return false;
        }
        if (editora.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a editora do livro.");
            return false;
        }
        if (edicaoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a edição do livro.");
            return false;
        }
        if (quantidadePaginasTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de páginas do livro.");
            return false;
        }
        if (categoriaDTO.getId() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma categoria.");
            return false;
        }
        if (autorDTO.getId() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione um autor.");
            return false;
        }

        try {
            int anoPublicacao = Integer.parseInt(anoPublicacaoTexto);
            int edicao = Integer.parseInt(edicaoTexto);
            int quantidadePaginas = Integer.parseInt(quantidadePaginasTexto);

            if (anoPublicacao <= 0 || edicao <= 0 || quantidadePaginas <= 0) {
                JOptionPane.showMessageDialog(null, "Os campos numéricos devem ser maiores que zero.");
                return false;
            }

            livroDTO.setTitulo(titulo);
            livroDTO.setAnoPublicacao(anoPublicacao);
            livroDTO.setIsbn(isbn);
            livroDTO.setEditora(editora);
            livroDTO.setEdicao(edicao);
            livroDTO.setQuantidadePaginas(quantidadePaginas);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano de publicação, edição e quantidade de páginas devem conter apenas números.");
            return false;
        }
        livroDTO.setIdCategoria(categoriaDTO.getId());

        String mensagem = livroCTR.inserirLivroString(livroDTO, categoriaDTO, autorDTO);
        JOptionPane.showMessageDialog(null, mensagem);
        return mensagem.toLowerCase().contains("sucesso");
    }

    private void liberaCampos(boolean a) {
        txt_titulo.setEnabled(a);
        txt_ano_publicacao.setEnabled(a);
        txt_isbn.setEnabled(a);
        txt_editora.setEnabled(a);
        txt_edicao.setEnabled(a);
        txt_quantidade_paginas.setEnabled(a);
        jtl_consultar_categoria.setEnabled(a);
        jtl_consultar_autor.setEnabled(a);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnSair.setEnabled(d);
    }

    private void limpaCampos() {
        txt_titulo.setText("");
        txt_ano_publicacao.setText("");
        txt_isbn.setText("");
        txt_editora.setText("");
        txt_edicao.setText("");
        txt_quantidade_paginas.setText("");
        categoriaDTO.setId(0);
        autorDTO.setId(0);
        livroDTO.setId(0);
        livroDTO.setIdCategoria(0);
        jtl_consultar_categoria.clearSelection();
        jtl_consultar_autor.clearSelection();
    }

    private void preencheTabela_Categoria(String nome) {
        try {
            modelo_jtl_consultar_categoria.setNumRows(0);
            categoriaDTO.setNome(nome);
            rs = categoriaCTR.consultarCategoriaString(categoriaDTO, 1);
            while (rs != null && rs.next()) {
                modelo_jtl_consultar_categoria.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela de categoria.\n" + e.getMessage());
        } finally {
            categoriaCTR.closeDb();
        }
    }

    private void preencheTabela_Autor(String nome) {
        try {
            modelo_jtl_consultar_autor.setNumRows(0);
            autorDTO.setNome(nome);
            rs = autorCTR.consultarAutorString(autorDTO, 1);
            while (rs != null && rs.next()) {
                modelo_jtl_consultar_autor.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela de autor.\n" + e.getMessage());
        } finally {
            autorCTR.closeDb();
        }
    }

    private void preencheTabela_Livro() {
        preencheTabela_Livro("");
    }

    private void preencheTabela_Livro(String titulo) {
        try {
            modelo_jtl_consultar_livro.setNumRows(0);
            if (titulo == null || titulo.trim().isEmpty()) {
                rs = livroCTR.listarLivros();
            } else {
                livroDTO.setTitulo(titulo.trim());
                rs = livroCTR.consultarLivro(livroDTO, 1);
            }
            while (rs != null && rs.next()) {
                modelo_jtl_consultar_livro.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("ano_publicacao"),
                    rs.getString("isbn"),
                    rs.getString("editora"),
                    rs.getInt("edicao"),
                    rs.getInt("quantidade_paginas"),
                    rs.getString("categoria"),
                    rs.getString("autores")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela de livros.\n" + e.getMessage());
        } finally {
            livroCTR.closeDB();
        }
    }

    public void setPosicao() {
        if (getDesktopPane() == null) {
            return;
        }
        Dimension desktopSize = getDesktopPane().getSize();
        Dimension jInternalFrameSize = getSize();
        setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        setPosicao();
    }

}
