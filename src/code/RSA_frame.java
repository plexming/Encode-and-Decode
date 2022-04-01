package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class RSA_frame {

	public JFrame frmRsa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSA_frame window = new RSA_frame();
					window.frmRsa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RSA_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRsa = new JFrame();
		frmRsa.setTitle("RSA");
		frmRsa.setBounds(100, 100, 673, 593);
		frmRsa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRsa.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(14, 269, 627, 139);
		frmRsa.getContentPane().add(scrollPane);
		
		JTextArea privatekey = new JTextArea();
		privatekey.setLineWrap(true);
		scrollPane.setViewportView(privatekey);
		
		JTextArea publickey = new JTextArea();
		publickey.setLineWrap(true);
		publickey.setWrapStyleWord(true);
		publickey.setColumns(10);
		publickey.setRows(2);
		publickey.setBounds(14, 168, 627, 57);
		frmRsa.getContentPane().add(publickey);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setBounds(14, 36, 627, 57);
		frmRsa.getContentPane().add(textArea_2);
		
		JButton btnNewButton = new JButton("\u751F\u6210\u5BC6\u94A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					try {
						RSA.keyPairGen();
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String pu=RSA.GetPublickey();
					String pr=RSA.GetPrivatekey();
					publickey.setText(pu);
					privatekey.setText(pr);
					
					
				}
			}
		});
		btnNewButton.setBounds(14, 106, 113, 27);
		frmRsa.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u516C\u94A5\uFF1A");
		lblNewLabel.setBounds(14, 149, 72, 18);
		frmRsa.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u79C1\u94A5\uFF1A");
		lblNewLabel_1.setBounds(14, 238, 72, 18);
		frmRsa.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u660E\u6587/\u5BC6\u6587:");
		lblNewLabel_2.setBounds(14, 13, 100, 18);
		frmRsa.getContentPane().add(lblNewLabel_2);
		
		JTextArea ResultText = new JTextArea();
		ResultText.setLineWrap(true);
		ResultText.setText("\u7ED3\u679C\u533A");
		ResultText.setBounds(14, 421, 627, 72);
		frmRsa.getContentPane().add(ResultText);
		
		JButton btnNewButton_1 = new JButton("\u516C\u94A5\u52A0\u5BC6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
				{
					String str = textArea_2.getText();
					String p = publickey.getText();
					try {
						String rs = RSA.encrypt(str, p);
						ResultText.setText(rs);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton_1.setBounds(152, 106, 113, 27);
		frmRsa.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u79C1\u94A5\u89E3\u5BC6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2)
				{
					String m = textArea_2.getText();
					String p = privatekey.getText();
					try {
						String rs = RSA.decrypt(m, p);
						ResultText.setText(rs);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_2.setBounds(301, 106, 113, 27);
		frmRsa.getContentPane().add(btnNewButton_2);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmRsa.setJMenuBar(menuBar);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==back)
				{
					frmRsa.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ENCODE d =new ENCODE();
					d.frame.setVisible(true);
					
				}
			}
		});
		back.setBackground(Color.WHITE);
		menuBar.add(back);
	}
}
