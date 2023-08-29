package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

public class Fruit {
	
	// 필드
	public String name;
	public int price;

	// 생성자
	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + "]";
	}
	
}
