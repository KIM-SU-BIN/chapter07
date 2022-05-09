package echo01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		// 서버에서 소켓을 만들어내는 것
		// 2번째 serverSocket은 변수 이름
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.58", 10001)); // ip, port번호 기입

		System.out.println("<서버시작>");
		System.out.println("===============================");
		System.out.println("[연결을 기다리고 있습니다.]");

		
		// 반복시작*******************************************
		
		while (true) {

			Socket socket = serverSocket.accept();

			// 쓰레드 출장보내기 (출장가서 스트림 보강하고 대화해라)
			Thread thread = new ServerThread(socket);
			thread.start();

		}

		// 쓰레드 

		// 반복종료

		/*System.out.println("===============================");
		System.out.println("<서버종료>");

		br.close();
		socket.close();
		serverSocket.close();
		*/
	}

}
