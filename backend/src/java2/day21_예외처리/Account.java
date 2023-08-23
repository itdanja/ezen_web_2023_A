package java2.day21_예외처리;

public class Account {
	// 필드 
	private long balance; // 잔고
	// 생성자
	public Account() { }
	// 메소드 
	public long getBalance() { return balance; }
	// 예금 메소드 
	public void deposit( int money ) {
		balance += money;
	}
	// 출금 메소드 
	public void withdraw( int money ) throws 잔고부족예외 {
		if( this.balance < money ) {
			// 예금액이 부족하면 출금 금지... // 고의적으로 예외 발생!!!
			throw new 잔고부족예외("잔고부족 : "+( money-this.balance)+" 만큼 부족");
		}
		this.balance -= money;
	}
	
}
