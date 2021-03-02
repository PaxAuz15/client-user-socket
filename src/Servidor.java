import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args){
        try{
            System.out.println("Esperando por el cliente...");
            ServerSocket socketServidor = new ServerSocket(9806);
            Socket socket = socketServidor.accept();
            System.out.println("Conexión establecida");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            String filtro_para_obtener_posibles_numeros = mensaje.replaceAll("\\D+","");
            System.out.println(mensaje);
            System.out.println(filtro_para_obtener_posibles_numeros);

            // if( mensaje == filtro_para_obtener_posibles_numeros){
            //     PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            //     salida.println("Servidor no acepta digitos en su mensaje");
            // }else {
            //     PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            //     salida.println("Servidor ha recibido un mensaje de Cliente=> " + mensaje);    
            // }

            if (filtro_para_obtener_posibles_numeros.isEmpty()){
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                salida.println("Servidor ha recibido un mensaje de Cliente=> " + mensaje);
            }
            
            if(mensaje != filtro_para_obtener_posibles_numeros){
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                salida.println("Servidor no acepta digitos en su mensaje");
            }
        }catch(Exception e){

        }
    }
}
