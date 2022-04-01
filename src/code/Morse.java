package code;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Morse {

	public JFrame frmMorse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Morse window = new Morse();
					window.frmMorse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Morse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMorse = new JFrame();
		frmMorse.setTitle("Morse");
		frmMorse.setBounds(100, 100, 692, 456);
		frmMorse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMorse.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6469\u65AF\u5BC6\u7801\u52A0\u5BC6");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(240, 40, 159, 34);
		frmMorse.getContentPane().add(lblNewLabel);
		
		JTextArea Plaintext = new JTextArea();
		Plaintext.setFont(new Font("Monospaced", Font.PLAIN, 20));
		Plaintext.setText("\u5728\u6B64\u8F93\u5165\u660E\u6587");
		Plaintext.setBounds(14, 77, 646, 94);
		frmMorse.getContentPane().add(Plaintext);
		
		JTextArea ciphertext = new JTextArea();
		ciphertext.setFont(new Font("Monospaced", Font.PLAIN, 20));
		ciphertext.setText("\u52A0\u5BC6\u7ED3\u679C");
		ciphertext.setBounds(14, 231, 646, 94);
		frmMorse.getContentPane().add(ciphertext);
		
		JButton btnNewButton = new JButton("\u52A0\u5BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					Map<Character, String> maplist = new HashMap<Character, String>();// 摩尔斯编码表集合
					maplist.put('A', ".-");
					maplist.put('B', "-...");
					maplist.put('C', "-.-.");
					maplist.put('D', "-..");
					maplist.put('E', ".");
					maplist.put('F', "..-.");
					maplist.put('G', "--.");
					maplist.put('H', "....");
					maplist.put('I', "..");
					maplist.put('G', ".---");
					maplist.put('K', "-.-");
					maplist.put('L', ".-..");
					maplist.put('M', "--");
					maplist.put('N', "-.");
					maplist.put('O', "---");
					maplist.put('P', ".--.");
					maplist.put('Q', "--.-");
					maplist.put('R', ".-.");
					maplist.put('S', "...");
					maplist.put('T', "-");
					maplist.put('U', "..-");
					maplist.put('V', "...-");
					maplist.put('W', ".--");
					maplist.put('X', "-..-");
					maplist.put('Y', "-.--");
					maplist.put('Z', "--..");
			 
					/* 数字电码0-9 */
					maplist.put('0', "-----");
					maplist.put('1', ".----");
					maplist.put('2', "..---");
					maplist.put('3', "...--");
					maplist.put('4', "....-");
					maplist.put('5', ".....");
					maplist.put('6', "-....");
					maplist.put('7', "--...");
					maplist.put('8', "---..");
					maplist.put('9', "----.");
			 
					/* 标点符号 */
					maplist.put(',', "--..--"); // ,逗号
					maplist.put('.', ".-.-.-"); // .句号
					maplist.put('?', "..--.."); // ?问号
					maplist.put('!', "-.-.--"); // !感叹号
					maplist.put('\'', ".----.");// '单引号
					maplist.put('\"', ".-.-.");// "引号
					maplist.put('=', "-...-"); 	// =等号
					maplist.put(':', "---..."); // :冒号
					maplist.put(';', "-.-.-."); // ;分号
					maplist.put('(', "-.--."); 	// (前括号
					maplist.put(')', "-.--.-"); // )后括号
					maplist.put(' ', "/");		// 空格
					
					String m = Plaintext.getText();
					StringBuffer c = new StringBuffer(" ");
					m=m.toUpperCase();
					char a[]=new char[m.length()];
					for(int i=0;i<m.length();i++){
						a[i]=m.charAt(i);
						}
					for(int j=0;j<m.length();j++) {
						if(maplist.containsKey(a[j])) {
							c.append(maplist.get(a[j])+" "); 
						}
					}
					ciphertext.setText(c.toString());

				}
			}
		});
		btnNewButton.setBounds(14, 184, 113, 27);
		frmMorse.getContentPane().add(btnNewButton);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmMorse.setJMenuBar(menuBar);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==back)
				{
					frmMorse.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ENCODE d =new ENCODE();
					d.frame.setVisible(true);
					
				}
			}
		});
		back.setBackground(Color.WHITE);
		menuBar.add(back);
	}
}
