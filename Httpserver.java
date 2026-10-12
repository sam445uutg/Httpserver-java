import java.io.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;



public class Httpserver{
    public static void main(String arg[]) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8001),0);
        server.createContext("/hello",new Myhandler());
        server.createContext("/", new Myhome());
        server.setExecutor(null);
        server.start();
    }
    static class Myhandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String response = "Hello, this is a simple HTTP server response!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    static class Myhome implements HttpHandler{
        @Override 
        public void handle(HttpExchange exchange)throws IOException{
            String response = "Home!!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}