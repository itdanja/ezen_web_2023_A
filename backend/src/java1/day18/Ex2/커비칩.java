package java1.day18.Ex2;

public class 커비칩 implements 게임패드 {
	@Override
	public void A버튼() { System.out.println("공격"); }
	@Override
	public void B버튼() { System.out.println("방어"); }
	@Override
	public void X버튼() { System.out.println("교체"); }
	@Override
	public void Y버튼() { System.out.println("스킬");}
}

