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
		URL url = JButtonClass.class.getResource("wo.png");
		Icon icon = new ImageIcon(url);
		setLayout(new GridLayout(3, 2, 5, 5));
		Container container = getContentPane();
		for (int i = 0; i < 5; i++) {
			// 1.������ť��ͬʱ���ð�ť������ͼ��
			JButton jb = new JButton("button" + i, icon);
			container.add(jb);
			if (i % 2 == 0) {
				jb.setEnabled(false);
			}
		}

		// 2.ʵ����һ��û��������ͼƬ�İ�
		JButton jb = new JButton();
		// 3.���ð�ť��ͼƬ��ͬ��С
		jb.setMaximumSize(new Dimension(30, 30));
		// 4.Ϊ��ť����ͼ��
		jb.setIcon(icon);
		jb.setText("button6");
		jb.setHideActionText(true);
		// 5.���ð�ť��ʾΪ����
		jb.setToolTipText("ͼƬ��ť");
		// 6.���ð�ť�߽粻��ʾ
		jb.setBorderPainted(false);
		// 7.Ϊ��ť��Ӽ����¼�
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 8.����ȷ�϶Ի���
				JOptionPane.showMessageDialog(JButtonClass.this, "�����Ի���");
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
