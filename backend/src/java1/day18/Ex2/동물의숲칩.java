package java1.day18.Ex2;

public class 동물의숲칩 implements 게임패드 {
	@Override
	public void A버튼() { System.out.println("줍기"); }
	@Override
	public void B버튼() { System.out.println("치기");}
	@Override
	public void X버튼() { System.out.println("달리기");}
	@Override
	public void Y버튼() { System.out.println("가방보기"); }
}
