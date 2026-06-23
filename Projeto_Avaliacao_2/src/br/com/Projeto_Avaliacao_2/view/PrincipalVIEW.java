package br.com.Projeto_Avaliacao_2.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class PrincipalVIEW extends javax.swing.JFrame {

    private JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private JMenu menuCadastro;
    private JMenu menuSair;
    private JMenuItem itemMenuCategoria;
    private JMenuItem itemMenuAutor;
    private JMenuItem itemMenuLivro;
    private ImageIcon imagemFundo;

    public PrincipalVIEW() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/novo.png")));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        imagemFundo = new ImageIcon(getClass().getResource("/br/com/Projeto_Avaliacao_2/view/imagens/tela_inicial.jpg"));
        desktopPane = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Image image = imagemFundo.getImage();
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        menuBar = new JMenuBar();
        menuCadastro = new JMenu();
        itemMenuCategoria = new JMenuItem();
        itemMenuAutor = new JMenuItem();
        itemMenuLivro = new JMenuItem();
        menuSair = new JMenu();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuCadastro.setMnemonic('c');
        menuCadastro.setText("Cadastro");

        itemMenuCategoria.setText("Categoria");
        itemMenuCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                abreCategoriaVIEW();
            }
        });
        menuCadastro.add(itemMenuCategoria);

        itemMenuAutor.setText("Autor");
        itemMenuAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                abreAutorVIEW();
            }
        });
        menuCadastro.add(itemMenuAutor);

        itemMenuLivro.setText("Livro");
        itemMenuLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                abreLivroVIEW();
            }
        });
        menuCadastro.add(itemMenuLivro);

        menuBar.add(menuCadastro);

        menuSair.setMnemonic('s');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                sair();
            }
        });
        menuBar.add(menuSair);
        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    /**
     * Abre a tela de categoria.
     */
    private void abreCategoriaVIEW() {
        CategoriaVIEW categoriaVIEW = new CategoriaVIEW();
        this.desktopPane.add(categoriaVIEW);
        categoriaVIEW.setVisible(true);
        categoriaVIEW.setPosicao();
    }

    /**
     * Abre a tela de autor.
     */
    private void abreAutorVIEW() {
        AutorVIEW autorVIEW = new AutorVIEW();
        this.desktopPane.add(autorVIEW);
        autorVIEW.setVisible(true);
        autorVIEW.setPosicao();
    }

    /**
     * Abre a tela de livro.
     */
    private void abreLivroVIEW() {
        LivroVIEW livroVIEW = new LivroVIEW();
        this.desktopPane.add(livroVIEW);
        livroVIEW.setVisible(true);
        livroVIEW.setPosicao();
    }

    /**
     * Exibe a confirmação de saída do sistema.
     */
    private void sair() {
        Object[] options = {"Sair", "Cancelar"};
        int opcao = JOptionPane.showOptionDialog(this, "Deseja sair do sistema?", "Biblioteca",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (opcao == 0) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }
}
