package leogle.chapter18.Thread;

import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ThreadImplementsRunnableInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	// 声明JLabel对象
	private JLabel jl = new JLabel();
	// 声明线程对象
	private static Thread t;
	// 声明计数变量
	private int count = 0;
	// 声明容器
	private Container container = getContentPane();

	public ThreadImplementsRunnableInterface() {
		// 绝对定位窗体大小与位置
		setBounds(300, 200, 250, 100);
		// 使窗体不使用任何布局管理器
		container.setLayout(null);
		// 获取图片URL
		URL url = ThreadImplementsRunnableInterface.class.getResource("button.png");
		// 实例化一个icon
		Icon icon = new ImageIcon(url);
		// 将图标放置在标签中
		jl.setIcon(icon);
		// 设置图片在标签最左方
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		// 设置标签的位置与大小
		jl.setBounds(10, 10, 200, 50);
		jl.setOpaque(true);
		t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (count < 200) {
					jl.setBounds(count, 10, 200, 50);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					count += 4;
					if (count == 200) {
						count = 10;
					}
				}
			}
		});
		// 启动线程
		t.start();
		// 将标签添加到容器
		container.add(jl);
		// 设置窗体可见
		setVisible(true);
		// 设置窗体默认关闭方式
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ThreadImplementsRunnableInterface();
	}

}
