package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author �̼���
 *
 */
// 1. �÷��̾�� �¿� �̵��� �����ϴ�. (x, y ��ǥ �ʿ�)
// 2. ������ �����ϴ�.
// 3. ��� �߻� (���߿� ��������)

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR, playerL; // �޸��� �ѹ��� �߰� ����

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // up, down

	private static final int JUMPSPEED = 2; // ������ �� �̵��ϴ� ��. ����
	private static final int SPEED = 4; // �¿�� �̵��ϴ� ��. ����

	// getter
	public boolean isJump() {
		return isJump;
	}

	// setter
	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	// getter
	public boolean isRight() {
		return isRight;
	}

	// setter
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	// getter
	public boolean isLeft() {
		return isLeft;
	}

	// setter
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}

	// new �ϴ� ��
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png"); // �÷��̾ �������� ��
		playerL = new ImageIcon("image/playerL.png"); // �÷��̾ ������ ��
	}

	// ���� ��� ����
	private void initSetting() {
		x = 70; // ���� �⺻ ��ġ
		y = 535; // ���� �⺻ ��ġ
		setIcon(playerR); // ���� �⺻ �̹���
		setSize(50, 50); // �⺻ �̹��� size ���� ���� 50
		setLocation(x, y); // Location ���ο��� paintComponent()�� ȣ����. Player�� ȣ�� �� ������ x, y�� ���� ����

		isRight = false; // ���� �⺻ ��. ���������� �������� ����
		isLeft = false; // ���� �⺻ ��. �������� �������� ����
		isJump = false; // ���� �⺻ ��. �������� ����
	}

	public void left() {
		isLeft = true; // �������� �����̴� ��
		setIcon(playerL);
		System.out.println("���� �̵�");

		// ���� �����尡 �ʹ� �ٺ��� �����̴� ��! ���ο� ������ ���� �� ��Ű��
		new Thread(() -> { // ���ٽ�
			while (isLeft) { // isLeft = true
				x = x - SPEED; // SPEED��ŭ �̵�
				setLocation(x, y); // Location ���ο��� paintComponent()�� ȣ����. Player�� ȣ�� �� ������ x, y�� ���� ����
				try { // ������� ������ Ʈ���� ĳġ�� ���α�
					Thread.sleep(10); // ������� ���� ����̶� �ھ� ��. left �޼��尡 ����Ǵ� ����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start(); // ������ �����Ű��
	}

	public void right() {
		isRight = true; // ���������� �����̴� ��
		System.out.println("������ �̵�");
		setIcon(playerR);

		// ���� �����尡 �ʹ� �ٺ��� �����̴� ��! ���ο� ������ ���� �� ��Ű��
		new Thread(() -> { // ���ٽ�
			while (isRight) { // isRight = true
				x = x + SPEED; // SPEED��ŭ �̵�
				setLocation(x, y); // Location ���ο��� paintComponent()�� ȣ����. Player�� ȣ�� �� ������ x, y�� ���� ����
				try { // ������� ������ Ʈ���� ĳġ�� ���α�
					Thread.sleep(10); // ������� ���� ����̶� �ھ� ��. right �޼��尡 ����Ǵ� ����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start(); // ������ �����Ű��
	}

	// Ű���� ������Ű
	public void jump() {
		System.out.println("����");
		isJump = true; // �����ϴ� ��

		// ���� �����尡 �ʹ� �ٺ��� �ѹ��� ó���Ǿ �����̵��ϴ� ��! ���ο� ������ ���� �� ��Ű��
		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // Location ���ο��� paintComponent()�� ȣ����. Player�� ȣ�� �� ������ x, y�� ���� ����

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // Location ���ο��� paintComponent()�� ȣ����. Player�� ȣ�� �� ������ x, y�� ���� ����

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// ������ �ٱ����� false�ϸ� ���� ����Ǳ⵵ ���� ���� �����尡 �����Ű�� ������ ������ �ȿ��� ����
			isJump = false;
		}).start();
	}
}
