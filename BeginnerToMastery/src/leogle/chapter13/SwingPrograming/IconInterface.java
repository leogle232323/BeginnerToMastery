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

	// 1.声明图标的宽
	private int width;
	// 2.声明图标的高
	private int height;

	// 3.定义构造方法
	public IconInterface(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// 4.实现paintIcon方法,绘制一个圆形（椭圆）
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.fillOval(x, y, width, height);
	}

	// 5.实现getIconWidth()方法
	@Override
	public int getIconWidth() {
		return this.width;
	}

	// 6.实现getIconHeight()方法
	@Override
	public int getIconHeight() {
		return this.height;
	}

	public static void main(String[] args) {
		Icon icon = new IconInterface(20, 20);
		// 1.创建一个带文本和图标的标签，并设置标签上的文字在标签正中间
		JLabel jl = new JLabel("测试", icon, SwingConstants.LEFT);

		// 2.创建一个JFrame窗口
		JFrame jf = new JFrame();
		Container container = jf.getContentPane();
		container.add(jl);

		container.setBackground(Color.gray);
		jf.setBounds(100, 100, 500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
