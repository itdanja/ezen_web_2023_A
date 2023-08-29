package java2.day28_컬렉션프레임워크3.Ex4_스택과큐;

public class Coin {
	// 필드 
	private int value;
	// 생성자 
	public Coin(int value) { super(); this.value = value; }
	// 메소드 get,set 
	public int getValue() { return value; }
	public void setValue(int value) { this.value = value;}
	@Override
	public String toString() {return "Coin [value=" + value + "]"; 	}
	
}
