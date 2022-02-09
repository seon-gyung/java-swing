package site.metacoding.bubble.ex01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author �̼��� ���� : ���ȭ�� ����, ĳ���� �߰�
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����. �ۼַ�Ʈ ���̾ƿ�
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	public static void main(String[] args) {

	}

}
