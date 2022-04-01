package code;

import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import javax.swing.JComponent;
import javax.swing.TransferHandler;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ImageEncode {

	public JFrame frame;
	private JTextField textField;
	private JTextField txtCusersdesktopmorsepng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageEncode window = new ImageEncode();
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
	public ImageEncode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6587\u4EF6\u52A0\u5BC6");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("\u8BF7\u5C06\u6587\u4EF6\u62D6\u62FD\u5230\u7A97\u53E3\u4E2D");
		lblNewLabel.setBounds(14, 49, 167, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(14, 72, 225, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setTransferHandler(new TransferHandler()
        {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    Object o = t.getTransferData(DataFlavor.javaFileListFlavor);
 
                    String filepath = o.toString();
                    if (filepath.startsWith("[")) {
                        filepath = filepath.substring(1);
                    }
                    if (filepath.endsWith("]")) {
                        filepath = filepath.substring(0, filepath.length() - 1);
                    }
                    System.out.println(filepath);
                    textField.setText(filepath);
                    return true;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
            @Override
            public boolean canImport(JComponent comp, DataFlavor[] flavors) {
                for (int i = 0; i < flavors.length; i++) {
                    if (DataFlavor.javaFileListFlavor.equals(flavors[i])) {
                        return true;
                    }
                }
                return false;
            }
        });
		
		txtCusersdesktopmorsepng = new JTextField();
		txtCusersdesktopmorsepng.setBackground(SystemColor.control);
		txtCusersdesktopmorsepng.setText("C:\\Users\\11931\\Desktop\\Morse1.png");
		txtCusersdesktopmorsepng.setBounds(103, 128, 291, 24);
		frame.getContentPane().add(txtCusersdesktopmorsepng);
		txtCusersdesktopmorsepng.setColumns(10);
		
		JLabel rs = new JLabel("");
		rs.setBounds(14, 162, 72, 18);
		frame.getContentPane().add(rs);
		
		JButton btnNewButton = new JButton("\u52A0\u5BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String str1 = textField.getText();
					String str2 = txtCusersdesktopmorsepng.getText();
					ImageEn.lockImage(str1, str2);
					rs.setText("success!!");
				}
			}
		});
		btnNewButton.setBounds(268, 71, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FDD\u5B58\u8DEF\u5F84\uFF1A");
		lblNewLabel_1.setBounds(14, 131, 75, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==back)
				{
					frame.setVisible(false);//点击按钮时frame销毁,跳转到DES 
					ENCODE d =new ENCODE();
					d.frame.setVisible(true);
					
				}
			}
		});
		back.setBackground(Color.WHITE);
		menuBar.add(back);
	}
}
