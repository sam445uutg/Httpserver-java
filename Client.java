import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] agr)throws IOException{
        Socket socket = new Socket("127.0.0.1", 8001);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String res = in.readLine();
        System.out.println(res);
        socket.close();

    }

}
