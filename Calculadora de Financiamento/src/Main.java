import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		Problema problema1 = new Problema();
		JFrame j0 = new JFrame("Calculadora de financiamento");
		j0.setBounds(150, 150, 400, 400); j0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);j0.setResizable(false);
		j0.getContentPane().setLayout(new FlowLayout());
		JLabel jLNumeroDeParcelas = new JLabel("Digite o numero maximo de parcelas     ");
		JTextField jTNumeroDeParcelas = new JTextField(10);
		JLabel jLJuros = new JLabel("Digite o valor do juros em porcentagem");
		JTextField jTJuros = new JTextField(10);
		JLabel jLValor = new JLabel("Digite o valor a ser fianciado                   ");
		JTextField jTValor = new JTextField(10);
		Dimension dimLinha = new Dimension(400, 30);
		JPanel pLinha1 = new JPanel();pLinha1.setPreferredSize(dimLinha); pLinha1.setLayout(new FlowLayout());pLinha1.add(jLValor); pLinha1.add(jTValor);j0.getContentPane().add(pLinha1);
		JPanel pLinha2 = new JPanel();pLinha2.setPreferredSize(dimLinha);pLinha2.setLayout(new FlowLayout());pLinha2.add(jLNumeroDeParcelas); pLinha2.add(jTNumeroDeParcelas);j0.getContentPane().add(pLinha2);
		JPanel pLinha3 = new JPanel();pLinha2.setPreferredSize(dimLinha);pLinha3.setLayout(new FlowLayout());pLinha3.add(jLJuros); pLinha3.add(jTJuros);j0.getContentPane().add(pLinha3);
		JButton bCalcular = new JButton("Calcular");
		j0.getContentPane().add(bCalcular);
		JComboBox combo = new JComboBox(); combo.setPreferredSize(new Dimension(200, 20));
		j0.getContentPane().add(combo);
		JTextArea jAevolucao = new JTextArea("");
		JScrollPane painelRolagem = new JScrollPane(jAevolucao); painelRolagem.setPreferredSize(new Dimension(375, 200));
		j0.getContentPane().add(painelRolagem);
		j0.setVisible(true);
		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					float valorMontante;
					float valorParcela;
					float juros;
					int nParcelas;
					valorMontante = Float.valueOf(jTValor.getText());
					nParcelas = Integer.valueOf(jTNumeroDeParcelas.getText());
					String[] lista = new String[nParcelas];
					juros = Float.valueOf(jTJuros.getText())/100;
					problema1.setValores(valorMontante, juros);
					lista = problema1.solve(nParcelas);
					for(int i = 0; i < nParcelas; i++){
						combo.addItem(lista[i]);
					}
				}catch(Exception err){
					err.printStackTrace();
					JOptionPane.showMessageDialog(null, "Digite os valores no formato correto.\nExemplo: 3521.41");
				}
				
			}
		});
		combo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				jAevolucao.setText(problema1.printEvolucao((String)combo.getSelectedItem()));
			}
		});
		
		
		
		
		//compra de whey com denis 28/03/2018 235,08 = 0,9 * (2 * 85 + 25,20 + 66)
	}
}
