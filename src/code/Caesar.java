package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Caesar {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caesar window = new Caesar();
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
	public Caesar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u79FB\u4F4D\u5BC6\u7801\u52A0\u5BC6");
		frame.setBounds(100, 100, 555, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 25, 1));
		spinner.setBounds(146, 160, 31, 24);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u4F4D\u79FB\u6570\uFF1A");
		lblNewLabel.setBounds(41, 163, 91, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setText("\u5728\u6B64\u8F93\u5165\u660E\u6587");
		textArea.setBounds(41, 40, 458, 87);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("\u52A0\u5BC6\u7ED3\u679C");
		textArea_1.setBounds(41, 212, 458, 87);
		frame.getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("\u52A0\u5BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					String s = textArea.getText();
					char a[]=new char[s.length()];
					int n = (int)(spinner.getValue());
					for(int i=0;i<s.length();i++){
						a[i]=s.charAt(i);//charAt(i)方法取出一个字符串索引为i的字符
						}
					for(int j=0;j<s.length();j++) {
						if(a[j]>='a'&&a[j]<=('z'-n)) {
							a[j]=(char)(a[j]+n);
						}
						else if(a[j]>('z'-n)&&a[j]<='z') {
							a[j]=(char)(a[j]-(26-n));
						}
						else if(a[j]>='A'&&a[j]<=('Z'-n)) {
							a[j]=(char)(a[j]+n);
						}
						else if(a[j]>('Z'-n)&&a[j]<='Z') {
							a[j]=(char)(a[j]-(26-n));
						}
					}
					s = String.valueOf(a);
					textArea_1.setText(s);
				}
			}
		});
		btnNewButton.setBounds(256, 163, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ENCODE d =new ENCODE();
					d.frame.setVisible(true);
					
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		menuBar.add(btnNewButton_1);
	}
}
