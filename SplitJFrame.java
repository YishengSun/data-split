import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class SplitJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplitJFrame frame = new SplitJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplitJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u521D\u59CB\u6587\u672C\u9009\u62E9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(94, 148, 139, 39);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(229, 148, 331, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u9009\u62E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			    JFileChooser jfc = new JFileChooser();// 文件选择器  
				jfc.setFileSelectionMode(0);// 设定只能选择到文件  
	            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
	            if (state == 1) {  
	                return;// 撤销则返回  
	            } else {  
	                File f = jfc.getSelectedFile();// f为选择到的文件  
	                textField.setText(f.getAbsolutePath());  
	            }  
			}
		});
		button.setBounds(570, 148, 129, 39);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u751F\u6210\u6587\u4EF6\u8DEF\u5F84\u9009\u62E9");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(94, 252, 139, 39);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 252, 331, 39);
		contentPane.add(textField_1);
		
		JButton button_1 = new JButton("\u9009\u62E9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFileChooser jfc = new JFileChooser();// 文件选择器  
				jfc.setFileSelectionMode(1);// 设定只能选择到文件夹  
	            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
	            if (state == 1) {  
	                return;  
	            } else {  
	                File f = jfc.getSelectedFile();// f为选择到的目录  
	                textField_1.setText(f.getAbsolutePath());  
	            }  
			}
		});
		button_1.setBounds(570, 252, 129, 39);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u5F00\u59CB\u751F\u6210");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SplitMethod splitMethod=new SplitMethod(textField.getText(), textField_1.getText());
				
			}
		});
		button_2.setBounds(229, 369, 342, 65);
		contentPane.add(button_2);
	}
}
