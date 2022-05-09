package echo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	//private static OutputStream os;

	public static void main(String[] args) throws IOException {
		
		//태어날 때부터 소캣
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=========================");
		
		System.out.println("[서버에 연결을 요청합니다.]");
		//본인 ip주소 기입할 것(ip, 포트번호)
		socket.connect(new InetSocketAddress("192.168.0.58", 10001));
		
		
		//위의 과정 성공시(실행)
		System.out.println("[서버에 연결되었습니다.]");
		
		
		//메세지보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
			
		//스캐너
		Scanner sc = new Scanner (System.in);
		
		while(true) {
			//키보드 입력
			String str = sc.nextLine();		//입력받고
			
			if (str.equals("/q")) {
				break;
			}
			
			//메세지보내기 ->M받기까지는 계속 반복
			bw.write(str);		//보내기
			bw.newLine();
			bw.flush();
			
			//메세지 받기
			String reMsg = br.readLine();
			System.out.println("server : [" + reMsg + "]");
		}
		
		
		System.out.println("===============================");
		System.out.println("<클라이언트 종료>");
		
		sc.close();
		br.close();
		bw.close();
		socket.close();
		
		}

}
