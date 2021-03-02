import java.io.*;
import java.net.Socket;



public class Cliente {
    public static void main(String[] args){
        try{
            System.out.println("CLIENTE INICIANDO\n");
            Socket socket = new Socket("localhost",9806);
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("INGRESE UN MENSAJE\n");
            String mensaje = entradaUsuario.readLine();
            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);
            salida.println(mensaje);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(entrada.readLine());
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}