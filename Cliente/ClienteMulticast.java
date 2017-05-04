import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClienteMulticast {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[1024];
        DatagramPacket dgram = new DatagramPacket(b, b.length);
        MulticastSocket socket = new MulticastSocket(6666);
        socket.joinGroup(InetAddress.getByName("224.0.0.1"));
        while (true) {
            socket.receive(dgram);
            System.out.println("Received " + dgram.getLength() + " bytes from " + dgram.getAddress());
            System.out.println(new String(dgram.getData(), "UTF-8"));
            dgram.setLength(b.length);
        }
    }
}