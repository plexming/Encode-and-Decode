package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class DES_frame {

	public JFrame frmDes;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DES_frame window = new DES_frame();
					window.frmDes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DES_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDes = new JFrame();
		frmDes.setTitle("DES");
		frmDes.setBounds(100, 100, 632, 474);
		frmDes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDes.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("\u660E\u6587");
		textArea.setBounds(14, 85, 586, 97);
		frmDes.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("\u52A0\u5BC6\u6A21\u5F0F\uFF1A");
		lblNewLabel.setBounds(14, 211, 82, 18);
		frmDes.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"ECB", "CBC", "OFB", "CFB"}));
		spinner.setBounds(91, 208, 61, 24);
		frmDes.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("8\u4F4D\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(186, 211, 72, 18);
		frmDes.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(256, 208, 144, 24);
		frmDes.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setText("\u7ED3\u679C\u533A");
		textArea_1.setBounds(14, 262, 586, 97);
		frmDes.getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("\u52A0\u5BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					String c ="";
					String m = textArea.getText();
					String p = textField.getText();
					String mod = spinner.getValue().toString();
					if(mod.equals("ECB")) {
						c = DES.DES_ECB_Encrypt(m, mod, p);
					}
					else c = DES.DES_Encrypt(m, mod, p);
					textArea_1.setText(c);
				}
			}
		});
		btnNewButton.setBounds(14, 45, 113, 27);
		frmDes.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("DES");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(282, 33, 72, 18);
		frmDes.getContentPane().add(lblNewLabel_2);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmDes.setJMenuBar(menuBar);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==back)
				{
					frmDes.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ENCODE d =new ENCODE();
					d.frame.setVisible(true);
					
				}
			}
		});
		back.setBackground(Color.WHITE);
		menuBar.add(back);
	}
}
