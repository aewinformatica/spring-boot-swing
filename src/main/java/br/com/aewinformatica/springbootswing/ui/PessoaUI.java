package br.com.aewinformatica.springbootswing.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aewinformatica.springbootswing.model.Pessoa;
import br.com.aewinformatica.springbootswing.repository.PessoaRepository;


@Component
public class PessoaUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    private JButton jBtnAdicionar;
    private JComboBox<String> comboBoxPessoa;
    private DefaultComboBoxModel<String> defaultComboBoxModel;

	@Autowired
	PessoaRepository pessoaRepository;

    public PessoaUI() {
    	setTitle("Cadastro de Pessoas");
        initComponents();
    }

    private void initComponents() {
    
        jBtnAdicionar = new JButton();
        jBtnAdicionar.setText("Adicicionar");
        comboBoxPessoa = new JComboBox<String>();

    

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        
        jBtnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	jBtnAdicionarActionPerformed(evt);
            }
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
			        layout.setHorizontalGroup(
			        	layout.createParallelGroup(Alignment.LEADING)
			        		.addGroup(layout.createSequentialGroup()
			        			.addGap(50)
			        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
			        				.addComponent(comboBoxPessoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			        				.addComponent(jBtnAdicionar))
			        			.addContainerGap(278, Short.MAX_VALUE))
        );
			        layout.setVerticalGroup(
			        	layout.createParallelGroup(Alignment.LEADING)
			        		.addGroup(layout.createSequentialGroup()
			        			.addContainerGap()
			        			.addComponent(jBtnAdicionar)
			        			.addGap(18)
			        			.addComponent(comboBoxPessoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			        			.addContainerGap(221, Short.MAX_VALUE))
        );
			     
			        preencherCombo();	        
        getContentPane().setLayout(layout);

        pack();
    }
    
    private void preencherCombo() {
    	
    	defaultComboBoxModel = new DefaultComboBoxModel<String>();
    	defaultComboBoxModel.addElement("Jose");
    	defaultComboBoxModel.addElement("Joao");
    	
    comboBoxPessoa.setModel(defaultComboBoxModel);
    }

    private void jBtnAdicionarActionPerformed(ActionEvent evt) {
        Pessoa pessoa = new Pessoa(comboBoxPessoa.getSelectedItem().toString(), new Date());
    	pessoaRepository.save(pessoa);
    	List<Pessoa> pessoaEncontrada = pessoaRepository.findByNome(comboBoxPessoa.getSelectedItem().toString());
    	JOptionPane.showMessageDialog(rootPane, pessoaEncontrada);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PessoaUI().setVisible(true);
            }
        });
    }
}
