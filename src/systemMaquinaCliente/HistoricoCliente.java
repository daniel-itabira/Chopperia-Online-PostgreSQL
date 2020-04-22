package systemMaquinaCliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import connectDB.Conexao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoricoCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private JLabel label_qtd;
	private JLabel label_Valor;
	private int numeroCartao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoCliente frame = new HistoricoCliente(-1);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void historico() {
		
		String query = "SELECT * FROM pedidos WHERE \"nrCartao\"= ?";
		Conexao con = new Conexao();
		Connection conn = con.getConnection();
		DefaultListModel<String> ls = new DefaultListModel<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		try {

			DecimalFormat df = new DecimalFormat("0.00");
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, numeroCartao);
			ResultSet rs = prep.executeQuery();
			
			int qtd = 0;
			double valor = 0;
			while (rs.next()) {
				ls.addElement("  Número do pedido: " + rs.getInt("idPedido") + "  Opção: " + rs.getInt("idOpcao")
						+ "  Data: " + rs.getDate("dataPedido") + "  Produto: " + rs.getString("compra") + "  Valor: "
						+ df.format(rs.getDouble("valor")));
				qtd++;
				valor = valor + rs.getDouble("valor");
			}
			
			df.format(valor);
			label_Valor.setText(""+df.format(valor));
			label_qtd.setText("" + qtd);
			
			
			
			rs.close();
			prep.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
			return;
		}

		list.setModel(ls);

	}

	/**
	 * Create the frame.
	 */
	public HistoricoCliente(int numero) {
		numeroCartao = numero;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCompras = new JLabel("Compras");
		lblCompras.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompras.setBounds(310, 11, 153, 59);
		contentPane.add(lblCompras);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 69, 509, 506);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(new Color(255, 0, 0));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFinalizar.setBackground(new Color(255, 255, 255));
		btnFinalizar.setBounds(29, 593, 509, 44);
		contentPane.add(btnFinalizar);
		
		JLabel lblQuantidadeDeCompras = new JLabel("Quantidade de Compras");
		lblQuantidadeDeCompras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeDeCompras.setBounds(560, 71, 164, 31);
		contentPane.add(lblQuantidadeDeCompras);
		
		label_qtd = new JLabel("----");
		label_qtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_qtd.setForeground(new Color(0, 255, 0));
		label_qtd.setBounds(612, 113, 48, 14);
		contentPane.add(label_qtd);
		
		JLabel lblValorTotalGasto = new JLabel("Valor Total Gasto");
		lblValorTotalGasto.setBounds(560, 148, 140, 20);
		contentPane.add(lblValorTotalGasto);
		
		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblR.setBounds(560, 179, 48, 24);
		contentPane.add(lblR);
		
		 label_Valor = new JLabel("----");
		label_Valor.setForeground(new Color(255, 0, 0));
		label_Valor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Valor.setBounds(612, 179, 88, 24);
		contentPane.add(label_Valor);
		historico();
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
}
