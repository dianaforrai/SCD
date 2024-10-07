import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

public static void main(String[] args) throws IOException {

ServerSocket ss=null;
Socket socket=null;

try{

String line="";
ss = new ServerSocket(1900);    //crează obiectul serversocket
            System.out.println("astept conexiuni…");
            socket = ss.accept(); //incepe aşteptarea pe portul 1900
//în momentul în care un client s-a conectat ss.accept() returnează
//un socket care identifică conexiunea
//crează fluxurile de intrare/ieşire
    BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream())),true);
    String input = "";
    Scanner scanner = new Scanner(System.in);
    while (!input.equals("END")) {
        if (!input.isEmpty()) {
            out.println("s: " + input);
        }
        String str = in.readLine();       //primeste mesaj
        System.out.println(str);         //aşteaptă răspuns
        System.out.print(">");
        input = scanner.next();
    }
}catch(Exception e){e.printStackTrace();}
finally{
ss.close();

if(socket!=null) socket.close();

}

}

}