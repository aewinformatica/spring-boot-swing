package br.com.aewinformatica.springbootswing.ui;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aewinformatica.springbootswing.model.Pessoa;
import br.com.aewinformatica.springbootswing.repository.PessoaRepository;


@Component
public class PessoaUI extends javax.swing.JFrame {
	

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

        jBtnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jBtnAdicionar.setText("Adicicionar");
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jBtnAdicionar)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnAdicionar)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Pessoa pessoa = new Pessoa("AewInformatica", new Date());
    	pessoaRepository.save(pessoa);
    	List<Pessoa> pessoaEncontrada = pessoaRepository.findByNome("AewInformatica");
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

    // Variables declaration
    private javax.swing.JButton jBtnAdicionar;
    // End of variables declaration
}
