import java.io.*;
import java.net.*;
import java.io.EOFException;
import java.net.SocketTimeoutException;
//import java.lang.*;
import java.util.Random;
public class Tcpclient
{
public static void main(String args[])throws IOException
{
	//while(true)i
	//{
	try
	{
	String ip=args[0];
	int portf=Integer.parseInt(args[1]);
	int ports=Integer.parseInt(args[2]);
	Random rm=new Random();
	int head=0;
        int tail=1;
	int result=rm.nextInt(2);
	Socket s1=null;
	int load=0;
	Matrix mt=new Matrix();
	mt.a=mt.read();
	mt.b=mt.read();
	if(result==0)
        {
                 s1=new Socket(ip,portf);
                System.out.println("connected to:"+portf);
        }
        else
        {
                 s1=new Socket(ip,ports);
                 System.out.println("conected to:"+ports);
        }

	ObjectOutputStream obj=new ObjectOutputStream(s1.getOutputStream());
	obj.writeObject(mt);
	ObjectInputStream objin=new ObjectInputStream(s1.getInputStream());
	try
	{
		Object ob=(Matrix) objin.readObject();
		Matrix tempone=(Matrix) ob;
		tempone.display(tempone.c);
	}
	catch(EOFException ex)
	{
		System.out.println(ex);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	s1.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}	
