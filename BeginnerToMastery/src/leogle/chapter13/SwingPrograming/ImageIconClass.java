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
		// 1.创建一个标签
		JLabel jl = new JLabel("这是一个JLabel标签", JLabel.CENTER);
		// 2.获取图片所在的URL
		URL url = ImageIconClass.class.getResource("wo.png");
		// 3.实例化Icon对象
		Icon icon = new ImageIcon(url, "这是我自己");
		// 4.为标签设置图片
		jl.setIcon(icon);
		// 5.设置文字放置在标签中间
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		// 6.设置标签为不透明状态
		jl.setOpaque(true);
		// 7.将标签添加到容器中
		container.add(jl);
		// 8.设置窗体位置、大小
		setBounds(200, 200, 500, 500);
		// 9.设置窗体为可见
		setVisible(true);
		// 10.设置窗体关闭方式
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ImageIconClass();
	}

}
