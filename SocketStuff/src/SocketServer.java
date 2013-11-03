import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SocketServer {
public static void main(String[] args) throws IOException {
        
        

        int portNumber = 8888;

        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
        		
        		
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        		
            Scanner in = new Scanner(clientSocket.getInputStream());
        ) {
        
            String inputLine;
            

 

            while (in.hasNext()) {
                inputLine = in.nextLine();
                System.out.println(inputLine);
                out.print("server: " + clientSocket.getInetAddress().getHostAddress()+ " says: " + inputLine + "\n");
                out.flush();
                if (inputLine.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
