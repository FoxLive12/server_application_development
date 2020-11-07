import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class IntermediateClient {

    private static InetAddress address;
    private static byte[] buffer;
    private static DatagramPacket packet;
    private static String str;
    private static String str1 = "";
    private static MulticastSocket socket;
    private DatagramSocket socket_client;

    public static void main(String[] args) throws Exception {
        System.out.println("Ожидание сообщения от сервера");
        try {
            socket = new MulticastSocket(1501);
            address = InetAddress.getByName("233.0.0.1");
            socket.joinGroup(address);
            while (true) {
                buffer = new byte[256];
                packet = new DatagramPacket(
                        buffer, buffer.length);
                // Получение данных от сервера
                socket.receive(packet);
                str = new String(packet.getData());
                if (str1 != str){
                    System.out.println(
                            "Получено сообщение: " + str.trim());
                    new IntermediateClient();
                }else{
                    new IntermediateClient();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Удаление клиента из группы
                socket.leaveGroup(address);
                // Закрытие сокета
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public IntermediateClient() throws IOException{

        socket_client = new DatagramSocket();
        System.out.println("Sending messages");
        transmit();

    }

    public void transmit() {
        try {
            while (true) {
                buffer = str.getBytes();
                address = InetAddress.getByName("233.0.0.1");
                packet = new DatagramPacket(
                        buffer,
                        buffer.length,
                        address,
                        1502);
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
