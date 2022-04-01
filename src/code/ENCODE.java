package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ENCODE {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ENCODE window = new ENCODE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ENCODE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u591A\u529F\u80FD\u52A0\u5BC6");
		frame.setBounds(100, 100, 588, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(14, 74, 539, 89);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u53E4\u5178\u5BC6\u7801");
		lblNewLabel_1.setBounds(227, 6, 84, 24);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u79FB\u4F4D\u5BC6\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					frame.setVisible(false);//点击按钮时frame销毁,跳转到加密界面
					Caesar q =new Caesar();
					q.frame.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(130, 49, 113, 27);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6469\u65AF\u5BC6\u7801");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					frame.setVisible(false);//点击按钮时frame销毁,跳转到加密界面
					Morse q =new Morse();
					q.frmMorse.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(295, 49, 113, 27);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u591A\u529F\u80FD\u52A0\u5BC6");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 37));
		lblNewLabel.setBounds(174, 13, 210, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(14, 176, 539, 89);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u73B0\u4EE3\u5BC6\u7801");
		lblNewLabel_2.setBounds(227, 5, 84, 24);
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 20));
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("DES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_3)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					DES_frame d =new DES_frame();
					d.frmDes.setVisible(true);
					
				}
			}
		});
		btnNewButton_3.setBounds(46, 49, 113, 27);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("AES");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_4)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					AES_frame d =new AES_frame();
					d.frmAes.setVisible(true);
					
				}
			}
		});
		btnNewButton_4.setBounds(211, 49, 113, 27);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("RSA");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_5)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					RSA_frame d =new RSA_frame();
					d.frmRsa.setVisible(true);
					
				}
			}
		});
		btnNewButton_5.setBounds(372, 49, 113, 27);
		panel.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(14, 278, 539, 89);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u6587\u4EF6\u52A0\u5BC6");
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(225, 13, 97, 24);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton_6 = new JButton("\u6587\u4EF6\u52A0\u5BC6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_6)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ImageEncode d =new ImageEncode();
					d.frame.setVisible(true);
					
				}
			}
		});
		btnNewButton_6.setBounds(209, 50, 113, 27);
		panel_2.add(btnNewButton_6);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E3B\u754C\u9762");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u89E3\u5BC6");
		menuBar.add(mnNewMenu_1);
	}
}
