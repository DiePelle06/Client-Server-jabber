import java.io.*;
import java.net.*;

public class JabberClient 
{
	public static void main(String[] args) throws IOException 
	{
	    // Passing null to getByName() produces the
	    // special "Local Loopback" IP address, for
	    // testing on one machine w/o a network:
		//InetAddress addr = InetAddress.getByName("10.130.1.131");
	    //InetAddress addr = InetAddress.getByName("127.0.0.1");
		InetAddress addr = InetAddress.getByName("8.8.8.8");
	    // Alternatively, you can use
	    // the address or name:
	    // InetAddress addr =
	    //    InetAddress.getByName("127.0.0.1");
	    // InetAddress addr =
	    //    InetAddress.getByName("localhost");
	    System.out.println("addr = " + addr);
	    Socket socket = new Socket(addr, 80);
	    // Guard everything in a try-finally to make
	    // sure that the socket is closed:
	    try 
	    {
	    	System.out.println("socket = " + socket);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// Output is automatically flushed
			// by PrintWriter:
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			/*out.println("GET /index.html HTTP/1.1");
			out.println("Accept: image/gif, image/xxbitmap, image/jpeg, image/pjpeg,\r\n" + "Accept-Language: en-gb,en-us;q=0.5");
			out.println("Host:10.130.1.123");
			out.println("");*/
			out.println("GET / HTTP/1.1");
			out.println("Host: 10.130.1.124");
			out.println("Connection: keep-alive");
			out.println("Upgrade-Insecure-Requests: 1");
			out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36");
			out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
			out.println("Accept-Encoding: gzip, deflate");
			out.println("Accept-Language: it-IT,it;q=0.9,en-US;q=0.8,en;q=0.7");
			out.println("");
			for(int i = 0; i < 100; i ++) 
			{
				out.println("howdy " + i);
			    String str = in.readLine();
			    System.out.println(str);
			}
		//out.println("END");
	    } 
	    finally 
	    {
	    	System.out.println("closing...");
	    	socket.close();
	    	System.out.println("closed");
	    }
	}
} ///:~