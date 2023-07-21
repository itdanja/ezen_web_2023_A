package java1.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_파일처리 {
	
	public static void main(String[] args) throws IOException {
	
		String str = "자바에서 작성된 파일";
		File file = new File("./src/java1/day07/전국관광지정보표준데이터.csv");
		System.out.println( file );
		
			//file.delete();
			System.out.println(file.getPath());
			System.out.println(file.exists());
			System.out.println(file.length());
		
		//FileOutputStream fileOutputStream  = new FileOutputStream("./src/java/day07/ex1.txt");
		FileOutputStream fileOutputStream  = new FileOutputStream("./src/java1/day07/ex1.txt",true);
		fileOutputStream.write( str.getBytes() );
		
		System.out.println("파일쓰기를 했습니다.");
		
		System.out.println("파일 호출 합니다.");
		
		FileInputStream fileInputStream  = new FileInputStream(file.getPath());
		byte[] bs = new byte[(int)file.length()];
		int readCount =  fileInputStream.read(bs);
		String readStr = new String( bs , 0 , readCount );
		System.out.println( readStr );
	}
}
