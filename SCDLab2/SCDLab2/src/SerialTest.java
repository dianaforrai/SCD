import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SerialTest extends Thread{ 

public void run(){ 

try{ 

ServerSocket ss = new ServerSocket(1977); 

Socket s = ss.accept(); 

ObjectInputStream ois = new ObjectInputStream(s.getInputStream()); 

    Pers p = (Pers) ois.readObject(); 

  System.out.println(p); 

 s.close(); 
 
ss.close(); 

     }catch(Exception e){e.printStackTrace();} 

} 

public static void main(String[] args) throws Exception{ 

//trimite obiect prin socket 

(new SerialTest()).start(); 


Socket s = new Socket(InetAddress.getByName("localhost"),1977); 

ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()); 

Pers p = new Pers("Alin",14); 

oos.writeObject(p); 

s.close();

}

}
