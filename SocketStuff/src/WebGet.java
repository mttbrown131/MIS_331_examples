import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class WebGet {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "textfiles.com";
		//String resource = "/";
		Socket s = new Socket(host,80);
		
		
		InputStream input = s.getInputStream();
		OutputStream output = s.getOutputStream();
		
		
		Scanner scanner = new Scanner(input);
		PrintWriter printWriter = new PrintWriter(output);
		
		//String cmd = "GET " + resource + " HTTP/1.1/n" + "Host: " + host + "/n/n";
		//http://textfiles.com/computers/144meg.txt
		String query = "";
		query += "GET /computers/144meg.txt HTTP/1.1\r\n";
		query += "Host: " + host + "\r\n";
		query += "\r\n";
		
		
		printWriter.print(query);
		printWriter.flush();
		
		while(scanner.hasNextLine()){
			String x = scanner.nextLine();
			System.out.println(x);
			
		}
		s.close();
		
	}
}
