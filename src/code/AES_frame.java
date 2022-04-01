package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;

public class AES_frame {

	public JFrame frmAes;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AES_frame window = new AES_frame();
					window.frmAes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AES_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAes = new JFrame();
		frmAes.setTitle("AES");
		frmAes.setBounds(100, 100, 583, 426);
		frmAes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAes.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("\u8F93\u5165\u660E\u6587\u6216\u5BC6\u6587");
		textArea.setBounds(14, 75, 537, 80);
		frmAes.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u51658\u4F4D\u5BC6\u7801\uFF1A");
		lblNewLabel.setBounds(14, 186, 98, 18);
		frmAes.getContentPane().add(lblNewLabel);
		
		password = new JTextField();
		password.setBounds(126, 183, 148, 24);
		frmAes.getContentPane().add(password);
		password.setColumns(10);
		
		JTextArea txtrbase = new JTextArea();
		txtrbase.setEditable(false);
		txtrbase.setText("\u7ED3\u679C\uFF08\u52A0\u5BC6\u7ED3\u679C\u4E3Abase64\u5F62\u5F0F)");
		txtrbase.setBounds(14, 229, 537, 80);
		frmAes.getContentPane().add(txtrbase);
		
		JButton btnNewButton = new JButton("\u52A0\u5BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					String m = textArea.getText();
					String p = password.getText();
					String encode = AES.encode(p, m);
					txtrbase.setText(encode);
				}
			}
		});
		btnNewButton.setBounds(288, 182, 113, 27);
		frmAes.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u6A21\u5F0F\uFF1AECB");
		lblNewLabel_1.setBounds(14, 35, 72, 18);
		frmAes.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u89E3\u5BC6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
				{
					String m = textArea.getText();
					String p = password.getText();
					String decode = AES.decode(p, m);
					txtrbase.setText(decode);
				}
			}
		});
		btnNewButton_1.setBounds(415, 182, 113, 27);
		frmAes.getContentPane().add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		frmAes.setJMenuBar(menuBar);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==back)
				{
					frmAes.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ENCODE d =new ENCODE();
					d.frame.setVisible(true);
					
				}
			}
		});
		back.setBackground(Color.WHITE);
		menuBar.add(back);
		
		
	}
}
