package site.metacoding.practice;

interface Knife {
	void attack();

	void cook();
}

abstract class �丮������ implements Knife {
	@Override
	public void attack() {
	}
}

abstract class �ο�۾���� implements Knife {
	@Override
	public void cook() {
	}
}

class ������ extends �丮������ {

	@Override
	public void cook() {
		// TODO Auto-generated method stub

	}

}

class ������ extends �ο�۾���� {

	@Override
	public void attack() {

	}

}

public class PattenTest {

}
