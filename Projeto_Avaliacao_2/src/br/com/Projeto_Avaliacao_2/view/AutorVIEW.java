package br.com.Projeto_Avaliacao_2.view;

import br.com.Projeto_Avaliacao_2.ctr.AutorCTR;
import br.com.Projeto_Avaliacao_2.dto.AutorDTO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class AutorVIEW extends javax.swing.JInternalFrame {

    private AutorDTO autorDTO;
    private AutorCTR autorCTR;
    private int gravar_alterar;
    private int id_autor_selecionado;
    private ResultSet rs;
    private DefaultTableModel modelo_jtl_consultar_autor;

    private JLabel jLabel_nome;
    private JLabel jLabel_nacionalidade;
    private JLabel jLabel_data_nascimento;
    private JLabel jLabel_email;
    private JLabel jLabel_telefone;
    private JLabel jLabel_pesquisa_nome;
    private JTextField txt_nome;
    private JTextField txt_nacionalidade;
    private JFormattedTextField txt_data_nascimento;
    private JTextField txt_email;
    private JFormattedTextField txt_telefone;
    private JTextField txt_pesquisa_nome;
    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JButton btnExcluir;
    private JButton btnSair;
    private JButton btnPesquisar;
    private JTable jtl_consultar_autor;
    private JScrollPane jScrollPane_autor;

    public AutorVIEW() {
        initComponents();
        autorDTO = new AutorDTO();
        autorCTR = new AutorCTR();
        gravar_alterar = 0;
        id_autor_selecionado = 0;
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_autor = (DefaultTableModel) jtl_consultar_autor.getModel();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel_nome = new JLabel();
        jLabel_nacionalidade = new JLabel();
        jLabel_data_nascimento = new JLabel();
        jLabel_email = new JLabel();
        jLabel_telefone = new JLabel();
        jLabel_pesquisa_nome = new JLabel();
        txt_nome = new JTextField();
        txt_nacionalidade = new JTextField();
        txt_data_nascimento = criaCampoData();
        txt_email = new JTextField();
        txt_telefone = criaCampoTelefone();
        txt_pesquisa_nome = new JTextField();
        btnNovo = new JButton();
        btnSalvar = new JButton();
        btnCancelar = new JButton();
        btnExcluir = new JButton();
        btnSair = new JButton();
        btnPesquisar = new JButton();
        jScrollPane_autor = new JScrollPane();
        jtl_consultar_autor = new JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Autor");

        jLabel_nome.setText("Nome");
        jLabel_nacionalidade.setText("Nacionalidade");
        jLabel_data_nascimento.setText("Data Nascimento");
        jLabel_email.setText("Email");
        jLabel_telefone.setText("Telefone");
        jLabel_pesquisa_nome.setText("Pesquisar Nome");

        txt_nome.setColumns(20);
        txt_nacionalidade.setColumns(20);
        txt_email.setColumns(20);
        txt_pesquisa_nome.setColumns(20);

        btnNovo.setIcon(new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/novo.png")));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                liberaCampos(true);
                liberaBotoes(false, true, true, false, true);
                gravar_alterar = 1;
                id_autor_selecionado = 0;
                autorDTO.setId(0);
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
                id_autor_selecionado = 0;
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
                    modelo_jtl_consultar_autor.setNumRows(0);
                    gravar_alterar = 0;
                    id_autor_selecionado = 0;
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
                preencheTabela_Autor(txt_pesquisa_nome.getText());
            }
        });

        jtl_consultar_autor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nome", "Nacionalidade", "Nascimento", "Email", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

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
                    preencheCampos_Autor(id);
                    liberaBotoes(false, true, true, true, true);
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
                                .addComponent(jLabel_nome)
                                .addComponent(txt_nome, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_nacionalidade)
                                .addComponent(txt_nacionalidade, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_data_nascimento)
                                .addComponent(txt_data_nascimento, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_email)
                                .addComponent(txt_email, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_telefone)
                                .addComponent(txt_telefone, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_pesquisa_nome)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_pesquisa_nome, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnPesquisar))
                                .addComponent(jScrollPane_autor, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
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
                            .addComponent(jLabel_nacionalidade)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_nacionalidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel_data_nascimento)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_data_nascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel_email)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel_telefone)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_telefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_pesquisa_nome)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_pesquisa_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPesquisar))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane_autor, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
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

    private void gravar() {
        if (txt_nome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome do autor.");
            return;
        }
        if (txt_nacionalidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a nacionalidade do autor.");
            return;
        }
        if (!campoMascaraCompleta(txt_data_nascimento.getText(), "##/##/####")) {
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento no formato dd/mm/aaaa.");
            return;
        }
        if (txt_email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o email do autor.");
            return;
        }
        if (!campoMascaraCompleta(txt_telefone.getText(), "(##) #####-####")) {
            JOptionPane.showMessageDialog(null, "Informe o telefone no formato (xx) xxxxx-xxxx.");
            return;
        }

        autorDTO.setNome(txt_nome.getText());
        autorDTO.setNacionalidade(txt_nacionalidade.getText());
        autorDTO.setDataNascimento(txt_data_nascimento.getText());
        autorDTO.setEmail(txt_email.getText());
        autorDTO.setTelefone(txt_telefone.getText());
        JOptionPane.showMessageDialog(null, autorCTR.inserirAutorString(autorDTO));
    }

    private void alterar() {
        autorDTO.setId(id_autor_selecionado);
        autorDTO.setNome(txt_nome.getText());
        autorDTO.setNacionalidade(txt_nacionalidade.getText());
        autorDTO.setDataNascimento(txt_data_nascimento.getText());
        autorDTO.setEmail(txt_email.getText());
        autorDTO.setTelefone(txt_telefone.getText());
        JOptionPane.showMessageDialog(null, autorCTR.alterarAutorString(autorDTO));
    }

    private boolean excluir() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja excluir o autor selecionado?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            autorDTO.setId(id_autor_selecionado);
            JOptionPane.showMessageDialog(null, autorCTR.excluirAutorString(autorDTO));
            return true;
        }
        return false;
    }

    private void liberaCampos(boolean a) {
        txt_nome.setEnabled(a);
        txt_nacionalidade.setEnabled(a);
        txt_data_nascimento.setEnabled(a);
        txt_email.setEnabled(a);
        txt_telefone.setEnabled(a);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    private void limpaCampos() {
        txt_nome.setText("");
        txt_nacionalidade.setText("");
        txt_data_nascimento.setValue(null);
        txt_email.setText("");
        txt_telefone.setValue(null);
        txt_pesquisa_nome.setText("");
        modelo_jtl_consultar_autor.setNumRows(0);
        id_autor_selecionado = 0;
        autorDTO.setId(0);
    }

    private void preencheTabela_Autor(String nome) {
        try {
            modelo_jtl_consultar_autor.setNumRows(0);
            autorDTO.setNome(nome);
            rs = autorCTR.consultarAutorString(autorDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_autor.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nacionalidade"),
                    rs.getString("data_nascimento"),
                    rs.getString("email"),
                    rs.getString("telefone")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela de autor.\n" + e.getMessage());
        } finally {
            autorCTR.closeDb();
        }
    }

    private void preencheCampos_Autor(int id) {
        try {
            autorDTO.setId(id);
            rs = autorCTR.consultarAutorString(autorDTO, 2);
            if (rs.next()) {
                id_autor_selecionado = rs.getInt("id");
                txt_nome.setText(rs.getString("nome"));
                txt_nacionalidade.setText(rs.getString("nacionalidade"));
                txt_data_nascimento.setText(rs.getString("data_nascimento"));
                txt_email.setText(rs.getString("email"));
                txt_telefone.setText(rs.getString("telefone"));
                gravar_alterar = 2;
                liberaCampos(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher campos do autor.\n" + e.getMessage());
        } finally {
            autorCTR.closeDb();
        }
    }

    public void setPosicao() {
        Dimension desktopSize = getDesktopPane().getSize();
        Dimension jInternalFrameSize = getSize();
        setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    private boolean campoMascaraCompleta(String valor, String mascara) {
        return valor != null && !valor.trim().isEmpty() && !valor.contains("_") && valor.length() == mascara.length();
    }

    private JFormattedTextField criaCampoData() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            JFormattedTextField campo = new JFormattedTextField(mascara);
            campo.setColumns(20);
            campo.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
            return campo;
        } catch (ParseException e) {
            throw new IllegalStateException("Falha ao criar campo de data", e);
        }
    }

    private JFormattedTextField criaCampoTelefone() {
        try {
            MaskFormatter mascara = new MaskFormatter("(##) #####-####");
            mascara.setPlaceholderCharacter('_');
            JFormattedTextField campo = new JFormattedTextField(mascara);
            campo.setColumns(20);
            campo.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
            return campo;
        } catch (ParseException e) {
            throw new IllegalStateException("Falha ao criar campo de telefone", e);
        }
    }
}
