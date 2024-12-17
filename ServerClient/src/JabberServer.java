import java.io.*;
import java.net.*;

public class JabberServer 
{
	// Choose a port outside of the range 1-1024:
	public static final int PORT = 80;
	public static void main(String[] args) throws IOException 
	{
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Started: " + s);
		try 
		{
			// Blocks until a connection occurs:
			Socket socket = s.accept();
			System.out.println ("Connection from : " +
			socket.getInetAddress().getHostAddress() + ':' + socket.getPort());
			try 
			{
				System.out.println(
				"Connection accepted: "+ socket);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// Output is automatically flushed
				// by PrintWriter:
				PrintWriter out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
				
				int i = 0;
				while (i < 9) 
				{
					String str = in.readLine();
					if (str.equals("END")) break;
					System.out.println(str);
					out.println(str);
					i++;
				}
				// Always close the two sockets...
			} 
			finally 
			{
				System.out.println("closing...");
				socket.close();
				System.out.println("closed");
			}
		} 
		finally 
		{
			s.close();
		}
	}
}