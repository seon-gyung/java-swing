package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author �̼���
 *
 */
// 1. ���ȭ�� ����
// 2. ĳ���� �߰�
// 3. ĳ���� �¿��̵�
// 4. �¿� �̵� �������ϰ�

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // paintComponent() �׸� �ٽ� �׸��� �ڵ� ������
	}

	// new �ϴ� ��. �ٸ����� �� ���ϱ� private
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png")); // ���̺� �̹��� ���
		setContentPane(backgroundMap); // �����̳ʿ� ��׶��� �ֱ�

		// player �߰�
		player = new Player();
		add(player);
	}

	// ���� �� ����. �ٸ����� �� ���ϱ� private
	private void initSetting() {
		setSize(1000, 640); // ������ ũ�� ����
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����. �ۼַ�Ʈ ���̾ƿ�
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	// ������ �����. �ٸ����� �� ���ϱ� private
	private void initListener() {
		// key�� �ֽ��ϴ� ������
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			// key ���� ���� �ֽ��ϴ� ������
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // ������ Ű�� �������� ��
					// isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // ���� Ű�� �������� ��
					// isLeft�� false
					player.setLeft(false);
				}
			}

			// key ������ ���� �ֽ��ϴ� ������
			@Override
			public void keyPressed(KeyEvent e) {
				// KeyCode ���� : 37, ������ : 39, ���� : 38, �Ʒ��� : 40
				// System.out.println("Ű���� ������ : " + e.getKeyCode());

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// Ű���带 ������ �ִ� ���� right() �޼��带 �ѹ��� �����ϰ� �ʹ�.
					if (player.isRight() == false) { // ������ �̵��ϰ� ���� ���� �� ������ Ű ������ right() ����
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// Ű���带 ������ �ִ� ���� left() �޼��带 �ѹ��� �����ϰ� �ʹ�.
					if (player.isLeft() == false) { // ���� �̵��ϰ� ���� ���� �� ���� Ű ������ left() ����
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) { // �����ϰ� ���� ���� �� ���� Ű ������ jump() ����
						player.jump();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
