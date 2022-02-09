package site.metacoding.bubble.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author �̼��� �÷��̾�� �¿� �̵��� �����ϴ�. (x, y ��ǥ �ʿ�) ������ �����ϴ�. ��� �߻� (���߿� ��������)
 *
 */

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������
	}

	public void left() {
		System.out.println("���� �̵�");
		x = x - 10;
		setLocation(x, y); // paintComponent �ϴ� ��
		setIcon(playerL);
	}

	public void right() {
		System.out.println("������ �̵�");
		x = x + 10;
		setLocation(x, y); // paintComponent �ϴ� ��
		setIcon(playerR);
	}
}
