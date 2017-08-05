package leogle.chapter13.SwingPrograming;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class JFrameWindow extends JFrame {

	// ���л�
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new JFrameWindow("创建一个JFrame窗体");
	}

	public JFrameWindow(String title) {
		// 1.ʵ����JFrame����
		JFrame jf = new JFrame(title);

		// 2.��ȡһ������
		Container container = jf.getContentPane();

		// 3.����һ��JLabel��ǩ
		JLabel jl = new JLabel("这是一个JFrame窗体");
		// 4.ʹ��ǩ�ϵ����־���
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		// 5.����ǩ��ӵ�������
		container.add(jl);

		// 6.���������ı�����ɫ
		container.setBackground(Color.gray);
		// 7.ʹ�������
		jf.setVisible(true);
		// 8.���ô����С��λ��
		jf.setBounds(100, 100, 200, 200);
		// 9.���ô���رշ�ʽ
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
