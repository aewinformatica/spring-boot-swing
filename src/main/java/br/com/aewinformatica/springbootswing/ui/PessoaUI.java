package br.com.aewinformatica.springbootswing.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aewinformatica.springbootswing.model.Pessoa;
import br.com.aewinformatica.springbootswing.repository.PessoaRepository;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;


@Component
public class PessoaUI extends JFrame {
	
    // Variables declaration
    private JButton jBtnAdicionar;
    private JComboBox<String> comboBoxPessoa;
    private DefaultComboBoxModel<String> defaultComboBoxModel;

    // End of variables declaration
	

	private static final long serialVersionUID = 1L;
	
	@Autowired
	PessoaRepository pessoaRepository;

    /**
     * Creates new form PessoaUI
     */
    public PessoaUI() {
    	setTitle("Cadastro de Pessoas");
        initComponents();
    }



    private void initComponents() {

        jBtnAdicionar = new JButton();
        comboBoxPessoa = new JComboBox<String>();

        preencherCombo();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        jBtnAdicionar.setText("Adicicionar");
        jBtnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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
        getContentPane().setLayout(layout);

        pack();
    }
    
    private void preencherCombo() {
    	
    	defaultComboBoxModel = new DefaultComboBoxModel<String>();
    	defaultComboBoxModel.addElement("Jose");
    	defaultComboBoxModel.addElement("Joao");
    	
    comboBoxPessoa.setModel(defaultComboBoxModel);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        Pessoa pessoa = new Pessoa(comboBoxPessoa.getSelectedItem().toString(), new Date());
    	pessoaRepository.save(pessoa);
    	List<Pessoa> pessoaEncontrada = pessoaRepository.findByNome(comboBoxPessoa.getSelectedItem().toString());
    	JOptionPane.showMessageDialog(rootPane, pessoaEncontrada);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* (Set the Nimbus look and feel) Defina o visual e a sensação do Nimbus * /
        /*Para detalhes, consulte http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PessoaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PessoaUI().setVisible(true);
            }
        });
    }
}
