package br.com.aewinformatica.springbootswing.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aewinformatica.springbootswing.model.Pais;
import javax.swing.JLabel;


@Component
public class MDIApplication extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
    private JMenuItem aboutMenuItem;
    private JMenuItem contentMenuItem;
    private JDesktopPane desktopPane;
    private JMenuItem exitMenuItem;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuBar menuBar;
    private JMenuItem openMenuItem;
    private JComboBox<String> comboPaises;
    private DefaultComboBoxModel<String> defaultComboBoxModel;
    private List<Pais>listaPaises = new ArrayList<Pais>();

	@Autowired 
	PessoaUI pessoaUI;
	
    /**
     * Creates new form MDIApplication
     */
    public MDIApplication() {
        initComponents();
    }


    private void initComponents() {
    	setTitle("Controle de Pessoal");
    	
    	
        desktopPane = new JDesktopPane();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        openMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        contentMenuItem = new JMenuItem();
        aboutMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Arquivo");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Cadastro Contatos");
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ajuda");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Sobre");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
        
        comboPaises = new JComboBox<String>();
        comboPaises.setBounds(21, 76, 117, 20);
        preencherPaises();
        desktopPane.add(comboPaises);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );
        
        JLabel lblPais = new JLabel("Pais");
        lblPais.setBounds(21, 60, 46, 14);
        desktopPane.add(lblPais);
        
  
        


        pack();
    }

    private void exitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void openMenuItemActionPerformed(ActionEvent evt) {
        pessoaUI.setVisible(true);
    }
    
	
	public void preencherPaises() {
		
	     listaPaises.add(new Pais("pt-BR","Brasil"));
	     listaPaises.add(new Pais("fr-FR","France"));
		
		defaultComboBoxModel = new DefaultComboBoxModel<String>();
	     
		for(Pais p :listaPaises) {
		defaultComboBoxModel.addElement(p.getNome());
		}

		 comboPaises.setModel(defaultComboBoxModel);    
	     comboPaises.setSelectedIndex(0);
	}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIApplication().setVisible(true);
            }
        });
    }
}
