package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class JButtonClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JButtonClass() {
		URL url = JButtonClass.class.getResource("button.png");
		Icon icon = new ImageIcon(url);
		setLayout(new GridLayout(3, 2, 5, 5));
		Container container = getContentPane();
		for (int i = 0; i < 5; i++) {
			// 1.创建按钮，同时设置按钮文字与图标
			JButton jb = new JButton("button" + i, icon);
			container.add(jb);
			if (i % 2 == 0) {
				// 设置按钮不可用
				jb.setEnabled(false);
			}
		}

		// 2.创建一个没有文字与图片的按钮
		JButton jb = new JButton();
		// 3.设置按钮最大
		jb.setMaximumSize(new Dimension(30, 30));
		// 4.为按钮设置图标
		jb.setIcon(icon);
		jb.setText("button6");
		jb.setHideActionText(true);
		// 5.设置按钮提示文字
		jb.setToolTipText("图片按钮");
		// 6.设置按钮边界不显示
		jb.setBorderPainted(false);
		// 7.为按钮添加监听事件
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 8.弹出对话框
				JOptionPane.showMessageDialog(JButtonClass.this, "弹出对话框");
			}

		});

		container.add(jb);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JButtonClass();
	}

}
