import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Sender {
	public static void main(String[] args) throws UnknownHostException, IOException {

        InetAddress dstIp = Inet4Address.getByName("127.0.0.1");
        Socket s = new Socket(dstIp,8888);
        Scanner userInput = new Scanner(System.in);
        InputStream input = s.getInputStream();
        OutputStream output = s.getOutputStream();
          
          
        Scanner in = new Scanner(input);
        PrintWriter out = new PrintWriter(output);
        
        String message = null;  
        while(userInput.hasNext()){
        	message = userInput.nextLine();
        	out.print(message + "\n");
            out.flush();
            if(in.hasNext()){
            	System.out.println(in.nextLine());
            }
            if(message.equals("exit")){
            	break;
            }
        }
        
        s.close();
          
    }
}
