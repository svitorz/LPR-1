package br.com.Projeto_Avaliacao_2.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import br.com.Projeto_Avaliacao_2.dto.CategoriaDTO;
import br.com.Projeto_Avaliacao_2.ctr.CategoriaCTR;

public class CategoriaVIEW extends javax.swing.JInternalFrame {

    // Variables declaration - do not modify
    private CategoriaDTO categoriaDTO;
    private CategoriaCTR categoriaCTR;
    private int gravar_alterar;
    private int id_categoria_selecionada;
    private ResultSet rs;
    private DefaultTableModel modelo_jtl_consultar_categoria;

    private JLabel jLabel_nome;
    private JLabel jLabel_descricao;
    private JLabel jLabel_pesquisa_nome;
    private JTextField txt_nome;
    private JTextField txt_descricao;
    private JTextField txt_pesquisa_nome;
    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JButton btnExcluir;
    private JButton btnSair;
    private JButton btnPesquisar;
    private JTable jtl_consultar_categoria;
    private JScrollPane jScrollPane_categoria;
    // End of variables declaration

    public CategoriaVIEW() {
        initComponents();
        categoriaDTO = new CategoriaDTO();
        categoriaCTR = new CategoriaCTR();
        gravar_alterar = 0;
        id_categoria_selecionada = 0;
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_categoria = (DefaultTableModel) jtl_consultar_categoria.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel_nome = new JLabel();
        jLabel_descricao = new JLabel();
        jLabel_pesquisa_nome = new JLabel();
        txt_nome = new JTextField();
        txt_descricao = new JTextField();
        txt_pesquisa_nome = new JTextField();
        btnNovo = new JButton();
        btnSalvar = new JButton();
        btnCancelar = new JButton();
        btnExcluir = new JButton();
        btnSair = new JButton();
        btnPesquisar = new JButton();
        jScrollPane_categoria = new JScrollPane();
        jtl_consultar_categoria = new JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categoria");

        jLabel_nome.setText("Nome");
        jLabel_descricao.setText("Descricao");
        jLabel_pesquisa_nome.setText("Pesquisar Nome");

        txt_nome.setColumns(20);
        txt_descricao.setColumns(20);
        txt_pesquisa_nome.setColumns(20);

        btnNovo.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/novo.png")));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                liberaCampos(true);
                liberaBotoes(false, true, true, false, true);
                gravar_alterar = 1;
                id_categoria_selecionada = 0;
                categoriaDTO.setId(0);
            }
        });

        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/salvar.png")));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (gravar_alterar == 1) {
                    gravar();
                } else if (gravar_alterar == 2) {
                    alterar();
                } else {
                    JOptionPane.showMessageDialog(null, "Clique em Novo ou selecione um registro para alterar.");
                }
                limpaCampos();
                liberaCampos(false);
                liberaBotoes(true, false, false, false, true);
                gravar_alterar = 0;
            }
        });

        btnCancelar.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/cancelar.png")));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                limpaCampos();
                liberaCampos(false);
                liberaBotoes(true, false, false, false, true);
                gravar_alterar = 0;
                id_categoria_selecionada = 0;
            }
        });

        btnExcluir.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/excluir.png")));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (excluir()) {
                    limpaCampos();
                    liberaCampos(false);
                    liberaBotoes(true, false, false, false, true);
                    modelo_jtl_consultar_categoria.setNumRows(0);
                    gravar_alterar = 0;
                    id_categoria_selecionada = 0;
                }
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

        btnPesquisar.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/pesquisar.png")));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                preencheTabela_Categoria(txt_pesquisa_nome.getText());
            }
        });

        jtl_consultar_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };
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
                    preencheCampos_Categoria(id);
                    liberaBotoes(false, true, true, true, true);
                }
            }
        });
        jScrollPane_categoria.setViewportView(jtl_consultar_categoria);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_nome)
                                .addComponent(txt_nome, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_descricao)
                                .addComponent(txt_descricao, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_pesquisa_nome)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_pesquisa_nome, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnPesquisar))
                                .addComponent(jScrollPane_categoria, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNovo)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSalvar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCancelar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnExcluir)
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
                            .addComponent(jLabel_nome)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel_descricao)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_descricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_pesquisa_nome)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_pesquisa_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPesquisar))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane_categoria, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo)
                        .addComponent(btnSalvar)
                        .addComponent(btnCancelar)
                        .addComponent(btnExcluir)
                        .addComponent(btnSair))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * Grava uma nova categoria.
     */
    private void gravar() {
        categoriaDTO.setNome(txt_nome.getText());
        categoriaDTO.setDescricao(txt_descricao.getText());
        JOptionPane.showMessageDialog(null, categoriaCTR.inserirCategoriaString(categoriaDTO));
    }

    /**
     * Altera a categoria selecionada.
     */
    private void alterar() {
        categoriaDTO.setId(id_categoria_selecionada);
        categoriaDTO.setNome(txt_nome.getText());
        categoriaDTO.setDescricao(txt_descricao.getText());
        JOptionPane.showMessageDialog(null, categoriaCTR.alterarCategoriaString(categoriaDTO));
    }

    /**
     * Exclui a categoria selecionada.
     *
     * @return true quando a exclusão for confirmada e executada.
     */
    private boolean excluir() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja excluir a categoria selecionada?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            categoriaDTO.setId(id_categoria_selecionada);
            JOptionPane.showMessageDialog(null, categoriaCTR.excluirCategoriaString(categoriaDTO));
            return true;
        }
        return false;
    }

    /**
     * Habilita ou desabilita os campos da tela.
     *
     * @param a estado desejado dos campos
     */
    private void liberaCampos(boolean a) {
        txt_nome.setEnabled(a);
        txt_descricao.setEnabled(a);
    }

    /**
     * Habilita ou desabilita os botões da tela.
     *
     * @param a estado do botão Novo
     * @param b estado do botão Salvar
     * @param c estado do botão Cancelar
     * @param d estado do botão Excluir
     * @param e estado do botão Sair
     */
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    /**
     * Limpa os campos e as tabelas da tela.
     */
    private void limpaCampos() {
        txt_nome.setText("");
        txt_descricao.setText("");
        txt_pesquisa_nome.setText("");
        modelo_jtl_consultar_categoria.setNumRows(0);
        id_categoria_selecionada = 0;
        categoriaDTO.setId(0);
    }

    /**
     * Preenche a tabela de categorias.
     *
     * @param nome nome utilizado na pesquisa
     */
    private void preencheTabela_Categoria(String nome) {
        try {
            modelo_jtl_consultar_categoria.setNumRows(0);
            categoriaDTO.setNome(nome);
            rs = categoriaCTR.consultarCategoriaString(categoriaDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_categoria.addRow(new Object[] {
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

    /**
     * Preenche os campos da categoria.
     *
     * @param id identificador da categoria
     */
    private void preencheCampos_Categoria(int id) {
        try {
            categoriaDTO.setId(id);
            rs = categoriaCTR.consultarCategoriaString(categoriaDTO, 2);
            if (rs.next()) {
                id_categoria_selecionada = rs.getInt("id");
                txt_nome.setText(rs.getString("nome"));
                txt_descricao.setText(rs.getString("descricao"));
                gravar_alterar = 2;
                liberaCampos(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher campos da categoria.\n" + e.getMessage());
        } finally {
            categoriaCTR.closeDb();
        }
    }

    /**
     * Posiciona o InternalFrame no centro do DesktopPane.
     */
    public void setPosicao() {
        Dimension desktopSize = getDesktopPane().getSize();
        Dimension jInternalFrameSize = getSize();
        setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }
}
