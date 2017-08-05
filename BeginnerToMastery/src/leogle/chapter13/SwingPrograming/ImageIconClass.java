package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ImageIconClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public ImageIconClass() {
		Container container = getContentPane();
		// 1.����һ����ǩ
		JLabel jl = new JLabel("这是一个JLabel标签", JLabel.CENTER);
		// 2.��ȡͼƬ���ڵ�URL
		URL url = ImageIconClass.class.getResource("wo.png");
		// 3.ʵ����Icon����
		Icon icon = new ImageIcon(url, "这是图标描述");
		// 4.Ϊ��ǩ����ͼƬ
		jl.setIcon(icon);
		// 5.�������ַ����ڱ�ǩ�м�
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		// 6.���ñ�ǩΪ��͸��״̬
		jl.setOpaque(true);
		// 7.����ǩ��ӵ�������
		container.add(jl);
		// 8.���ô���λ�á���С
		setBounds(200, 200, 500, 500);
		// 9.���ô���Ϊ�ɼ�
		setVisible(true);
		// 10.���ô���رշ�ʽ
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ImageIconClass();
	}

}
