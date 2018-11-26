package br.com.aewinformatica.springbootswing.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aewinformatica.springbootswing.model.Pais;
import br.com.aewinformatica.springbootswing.util.LocaleUtils;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;


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
   
    private String TITLE_MAIN_MENU;
    private ResourceBundle rb;

	@Autowired 
	PessoaUI pessoaUI;
	private JTextField TF_numero;
	private JTextField TF_moeda;
	private JTextField TF_data;
	
    /**
     * Creates new form MDIApplication
     */
    public MDIApplication() {
    	
    	rb = LocaleUtils.getRb();
    	TITLE_MAIN_MENU = rb.getString("title.MAIN");
    	
        initComponents();
    }


    private void initComponents() {

    	

    	setTitle(TITLE_MAIN_MENU);
    	
    	
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
        comboPaises.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		
				//indice
				int index = comboPaises.getSelectedIndex();
				String []pais = listaPaises.get(index).getCodigo().split("-");
				//Criando Locale
				Locale locale = new Locale(pais[0],pais[1]);
				
				//formatando Numero
				int numero=1234567;
				NumberFormat numeroFormatado = NumberFormat.getNumberInstance(locale); 
				TF_numero.setText(numeroFormatado.format(numero));
				
				//formatando Moeda
				NumberFormat numeroFormatadoMoeda = NumberFormat.getCurrencyInstance(locale);
				TF_moeda.setText(numeroFormatadoMoeda.format(numero));
				
				//formatanado Data
				DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
				TF_data.setText(df.format(new Date()));
        	}
        });
        comboPaises.setBounds(102, 93, 117, 20);
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
        lblPais.setBounds(103, 68, 46, 14);
        desktopPane.add(lblPais);
        
        TF_numero = new JTextField();
        TF_numero.setBounds(102, 124, 86, 20);
        desktopPane.add(TF_numero);
        TF_numero.setColumns(10);
        
        TF_moeda = new JTextField();
        TF_moeda.setBounds(102, 155, 86, 20);
        desktopPane.add(TF_moeda);
        TF_moeda.setColumns(10);
        
        TF_data = new JTextField();
        TF_data.setBounds(29, 186, 286, 20);
        desktopPane.add(TF_data);
        TF_data.setColumns(10);
        
  
        


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
