package leogle.chapter13.SwingPrograming;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class JDialogWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new MyJFrame();
	}

	public JDialogWindow(MyJFrame frame) {
		// 1.实例化一个JDialog对话框，指定对话框父窗体、窗体标题和类型
		super(frame, "第一个JDialog窗体", true);
		Container container = getContentPane();
		container.add(new JLabel("这是一个对话框"));
		setBounds(200, 200, 200, 200);
	}
}

class MyJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyJFrame() {
		// 1.获取容器
		Container container = getContentPane();
		container.setLayout(null);

		// 2.在窗体中设置标签
		JLabel jl = new JLabel("这是一个JFrame窗体");
		// 3.将标签文字置于标签中间位置
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);

		// 4.定义一个按钮
		JButton jb = new JButton("弹出对话框");
		jb.setBounds(100, 100, 100, 21);
		// 5.为按钮添加鼠标点击事件
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 创建一个JDialogWindow窗口，并使其可见
				new JDialogWindow(MyJFrame.this).setVisible(true);
			}

		});
		// 6.将按钮添加到容器中
		container.add(jb);

		container.setBackground(Color.white);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
