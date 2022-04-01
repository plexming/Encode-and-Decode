package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import javax.swing.JMenuItem;

public class CODE {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CODE window = new CODE();
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
	public CODE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u52A0\u5BC6\u4E0E\u89E3\u5BC6");
		frame.setBounds(100, 100, 561, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(85, 76, 381, 59);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("\u591A\u529F\u80FD\u52A0\u89E3\u5BC6\u5E94\u7528");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 37));
		panel.add(lblNewLabel);
		
		Button start = new Button("\u5F00\u59CB\u4F7F\u7528");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==start)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到加密界面
					ENCODE q =new ENCODE();
					q.frame.setVisible(true);
					
				}
			}
		});
		start.setBounds(225, 196, 87, 25);
		frame.getContentPane().add(start);
		
		JLabel lblNewLabel_1 = new JLabel("1903130214 \u6F58\u541B\u5B87");
		lblNewLabel_1.setBounds(320, 148, 146, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E3B\u754C\u9762");
		menuBar.add(mnNewMenu);
	}
}
