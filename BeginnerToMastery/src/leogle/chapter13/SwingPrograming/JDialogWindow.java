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
		// 1.ʵ����һ��JDialog�����ָ���Ի���ĸ����塢������������
		super(frame, "第一个JDialog窗体", true);
		Container container = getContentPane();
		container.add(new JLabel("这是一个对话框"));
		setBounds(200, 200, 200, 200);
	}
}

class MyJFrame extends JFrame {
	// ���л�
	private static final long serialVersionUID = 1L;

	public MyJFrame() {
		// 1.����һ������
		Container container = getContentPane();
		container.setLayout(null);

		// 2.�ڴ��������ñ�ǩ
		JLabel jl = new JLabel("这是一个JFrame窗体");
		// 3.����ǩ���������ڱ�ǩ�м�λ��
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);

		// 4.����һ����ť
		JButton jb = new JButton("弹出对话框");
		jb.setBounds(100, 100, 100, 21);
		// 5.Ϊ��ť�����굥���¼�
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ʹJDialog����ɼ�
				new JDialogWindow(MyJFrame.this).setVisible(true);
			}

		});
		// 6.����ť��ӵ�����
		container.add(jb);

		container.setBackground(Color.white);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
