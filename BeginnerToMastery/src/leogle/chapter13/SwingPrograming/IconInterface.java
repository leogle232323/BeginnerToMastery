package leogle.chapter13.SwingPrograming;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class IconInterface implements Icon {

	// 1.����ͼ��Ŀ�
	private int width;
	// 2.����ͼ��ĸ�
	private int height;

	// 3.���幹�췽��
	public IconInterface(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// 4.ʵ��paintIcon����,����һ��Բ�Σ���Բ��
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.fillOval(x, y, width, height);
	}

	// 5.ʵ��getIconWidth()����
	@Override
	public int getIconWidth() {
		return this.width;
	}

	// 6.ʵ��getIconHeight()����
	@Override
	public int getIconHeight() {
		return this.height;
	}

	public static void main(String[] args) {
		Icon icon = new IconInterface(20, 20);
		// 1.����һ�����ı���ͼ��ı�ǩ�������ñ�ǩ�ϵ������ڱ�ǩ���м�
		JLabel jl = new JLabel("����", icon, SwingConstants.LEFT);

		// 2.����һ��JFrame����
		JFrame jf = new JFrame();
		Container container = jf.getContentPane();
		container.add(jl);

		container.setBackground(Color.gray);
		jf.setBounds(100, 100, 500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
