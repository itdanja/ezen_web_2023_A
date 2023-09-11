package controller.chatting;

import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dto.ClientDto;

@ServerEndpoint("/serversokcet/{mid}") // 서버소켓 URL 
public class ServerSocket {
	// 0. 접속된 클라이언트소켓들의 저장소 [ 세션 , 아이디 저장 => ClientDto  ]
	public static List< ClientDto > clientList = new Vector<>();
	
	// 1. 클라이언트소켓으로부터 접속받았을때. 
	@OnOpen 
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트 소켓이 입장했습니다."+ session );
		System.out.println("접속한 회원아이디 "+ mid );
		// 1-1 : 접속된 클라이언소켓을 리스트에 저장하자.
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add( clientDto );
		System.out.println("접속된 클라이언트들 : " + clientDto );
	}
	
}
/*
	* WebSocket 서버 소켓 라이브러리 제공
		1. 서버소켓 클래스 생성 
			- 클래스위에 서버소켓의 URL 만들기 
				@ServerEndpoint("/serversokcet")
			- 만약에 서버소켓의 URL 경로상의 매개변수를 받을때. 
				@ServerEndpoint("/serversokcet/{매개변수명1}/{매개변수명2}")
				
		2. 서버소켓 메소드 제공 
				- 메소드 매개변수의 규칙 존재 
				@OnOpen
						public void onOpen( Session session ) { }
							- Session : 서버소켓의 접속된 클라이언트소켓 정보
						public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ) { }
							
				@OnClose
				@OnError
				@OnMessage
 */









