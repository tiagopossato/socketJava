import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ServidorMulticast {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        byte[] b = new byte[1024];
        DatagramPacket dgram;
        int i = 0;
        while (true) {
            i++;            
            String s = "Ola " + Integer.toString(i) + " a todos";
            b = s.getBytes();
            dgram = new DatagramPacket(b, b.length, InetAddress.getByName("224.0.0.1"), 6666);
            System.err.println("Sending " + b.length + " bytes to " + dgram.getAddress() + ':' + dgram.getPort());
            socket.send(dgram);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.print(ex);

            }
        }

    }

}