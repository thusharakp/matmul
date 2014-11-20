import java.io.*;
import java.io.EOFException;
import java.net.*;
import java.util.*;
import java.net.ServerSocket;
public class Tcpser implements Runnable
{

	int load=0;
	ServerSocket s;
         Socket s1;
	Thread t1,t2;//,t3;
	int port;
	PriorityQueue <Matrix> pq=new PriorityQueue <Matrix> ();

	public Tcpser(int port)
	{
		try
		{
		 s= new ServerSocket(port);
                //s.setSoTimeout(60000);        
//		 s.setReuseAddress(true);
       		 //Socket s1=s.accept();

		this.port=port;
		t1=new Thread(this);
		t2=new Thread(this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
	while(true)
	{

		 if(Thread.currentThread()==t1)
		{
			 try
                {
                        //s=new ServerSocket(port);
                        //s.setReuseAddress(true);
                        s1=s.accept();
                        //s1.close();
                }
                catch(Exception e)
                {
                        System.out.println(e);
                }

			recData(port);
		}
		else
		{
			try
                {
                        Thread.sleep(1000);
                }catch(Exception e){
                        System.out.println(e);
                }
			sendData();
		}
	}
	}
	public void recData(int port)
	{
	try
	{
		//ServerSocket s= new ServerSocket(port);
		 //Socket s1=s.accept();
		 ObjectInputStream objin=new ObjectInputStream(s1.getInputStream());
		Object ob=(Matrix) objin.readObject();
		Matrix temp=(Matrix) ob;
		//a1=temp.a;
		//b1=temp.b;
	//	 PriorityQueue <Matrix> pq=new PriorityQueue <Matrix> ();
		pq.add(temp);
	}
	catch(EOFException ex)
	{
			
	}
	catch(Exception e)
	{
		//System.out.println("123"+e);
		e.printStackTrace();
	}
	try
	{
//	s1.close();
	}
	catch(Exception e)
	{
		System.out.println("qwqwq"+e);
	}
	}
	public void sendData()
	{
		try
		{
		if(pq.size()>=1)
	        {
		Matrix  head=pq.poll();
		//pq.poll();
		//temp.c=temp.multiply(temp.a,temp.b);
		load++;
		head.c=head.multiply(head.a,head.b);
		ObjectOutputStream obj=new ObjectOutputStream(s1.getOutputStream());
	//obj.writeObject(temp);
	obj.writeObject(head);
	  System.out.println("load on server:"+load);
		 try
                {
                        //s=new ServerSocket(port);
                        //s.setReuseAddress(true);
                        s1.close();
                        //s1.close();
                }
                catch(Exception e)
                {
                        System.out.println(e);
                }

//	if(pq.size()>=1)
//	{
	//	System.out.println("load on server:"+pq.size());
	}
		}
		catch(EOFException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception e)
		{
			//System.out.println(e);
			e.printStackTrace();
		}

		
	}
public static void main(String args[])throws IOException
{
	int port=Integer.parseInt(args[0]);
	try
	{
	Tcpser ser=new Tcpser(port);
	ser.t1.start();
	ser.t2.start();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
