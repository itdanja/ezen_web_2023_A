package java2.day22.Ex2;

public class 작업스레드2 extends Thread { // 상속
	@Override
	public void run() {
		try {
			int count = 1;
			while(true) {
				Thread.sleep(10000); // 3초간 일시정지 [ 예외처리필수 ]
				System.out.println( Thread.currentThread().getName() +"[작업2 Thread] output : " + count);
				count++;
			}
		}catch (Exception e) {System.out.println(e);}
	}
}
