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

    private JLabel jLabel_titulo;
    private JLabel jLabel_ano_publicacao;
    private JLabel jLabel_isbn;
    private JLabel jLabel_editora;
    private JLabel jLabel_edicao;
    private JLabel jLabel_quantidade_paginas;
    private JLabel jLabel_categoria;
    private JLabel jLabel_autor;
    private JTextField txt_titulo;
    private JTextField txt_ano_publicacao;
    private JTextField txt_isbn;
    private JTextField txt_editora;
    private JTextField txt_edicao;
    private JTextField txt_quantidade_paginas;
    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JButton btnSair;
    private JTable jtl_consultar_categoria;
    private JTable jtl_consultar_autor;
    private JScrollPane jScrollPane_categoria;
    private JScrollPane jScrollPane_autor;

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
        preencheTabela_Categoria("");
        preencheTabela_Autor("");
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
        txt_titulo = new JTextField();
        txt_ano_publicacao = new JTextField();
        txt_isbn = new JTextField();
        txt_editora = new JTextField();
        txt_edicao = new JTextField();
        txt_quantidade_paginas = new JTextField();
        btnNovo = new JButton();
        btnSalvar = new JButton();
        btnCancelar = new JButton();
        btnSair = new JButton();
        jScrollPane_categoria = new JScrollPane();
        jScrollPane_autor = new JScrollPane();
        jtl_consultar_categoria = new JTable();
        jtl_consultar_autor = new JTable();

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

        txt_titulo.setColumns(20);
        txt_ano_publicacao.setColumns(20);
        txt_isbn.setColumns(20);
        txt_editora.setColumns(20);
        txt_edicao.setColumns(20);
        txt_quantidade_paginas.setColumns(20);

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
                                                        .addComponent(jScrollPane_categoria, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_autor)
                                                        .addComponent(jScrollPane_autor, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnNovo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSalvar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancelar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSair)))
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
                                                .addComponent(jScrollPane_categoria, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_autor)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane_autor, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNovo)
                                        .addComponent(btnSalvar)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnSair))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private boolean gravar() {
        if (txt_titulo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o titulo do livro.");
            return false;
        }
        if (txt_ano_publicacao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o ano de publicação do livro.");
            return false;
        }
        if (txt_isbn.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o ISBN do livro.");
            return false;
        }
        if (txt_editora.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a editora do livro.");
            return false;
        }
        if (txt_edicao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a edição do livro.");
            return false;
        }
        if (txt_quantidade_paginas.getText().trim().isEmpty()) {
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

        livroDTO.setTitulo(txt_titulo.getText());
        livroDTO.setAnoPublicacao(Integer.parseInt(txt_ano_publicacao.getText()));
        livroDTO.setIsbn(txt_isbn.getText());
        livroDTO.setEditora(txt_editora.getText());
        livroDTO.setEdicao(Integer.parseInt(txt_edicao.getText()));
        livroDTO.setQuantidadePaginas(Integer.parseInt(txt_quantidade_paginas.getText()));
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

    public void setPosicao() {
        if (getDesktopPane() == null) {
            return;
        }
        Dimension desktopSize = getDesktopPane().getSize();
        Dimension jInternalFrameSize = getSize();
        setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

}
