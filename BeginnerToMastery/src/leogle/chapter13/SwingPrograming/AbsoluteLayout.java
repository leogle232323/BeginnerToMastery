package leogle.chapter13.SwingPrograming;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AbsoluteLayout extends JFrame {

	private static final long serialVersionUID = 1L;

	public AbsoluteLayout() {
		// 1.���ô���ı���
		setTitle("������ʹ�þ��Բ���");
		// 2.ʹ�ô���ȡ�����ֹ���������
		setLayout(null);
		// 3.���ô����λ�á���С
		setBounds(0, 0, 500, 500);
		// 4.��ȡ��������
		Container container = getContentPane();
		// 5.������ť
		JButton b1 = new JButton("��ť1");
		JButton b2 = new JButton("��ť2");
		// 6.���ð�ť��λ�á���С
		b1.setBounds(10, 30, 80, 30);
		b2.setBounds(60, 70, 100, 20);
		// 7.����ť��ӵ�������
		container.add(b1);
		container.add(b2);
		// 8.���ô���ɼ�
		setVisible(true);
		// 9.���ô���رշ�ʽ
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AbsoluteLayout();
	}

}
