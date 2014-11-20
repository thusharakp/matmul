import java.io.*;
public class Matrix implements Serializable
{
int[][] c,a,b;
public static void main(String args[])throws IOException
{
	

	InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

}

	public int[][] read()throws IOException
	{
	InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
	System.out.println("enter the number of rows:");
	int row=Integer.parseInt(br.readLine());
	System.out.println("enter the number of columns");
	int col=Integer.parseInt(br.readLine());
	int[][]a=new int[row][col];
	System.out.println("enter the matrix A:");
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			a[i][j]=Integer.parseInt(br.readLine());
		} 
	}
	return a;
	}
	public static void display(int[][]c)
	{	
	if(c==null)
	{
		System.out.println("multiplication not possible");
	}
	else
	{
	int rowc=c.length;
	int colc=c[0].length;
	System.out.println("product of A and B:");
	for(int i=0;i<rowc;i++)
	{
		for(int j=0;j<colc;j++)
		{
			//System.out.println("test");
			System.out.print(c[i][j]+" ");
		}
		System.out.println();
	}
	}
	/*catch(Exception e)
	{
		System.out.println(e);
	}*/
       }
	public int[][] multiply(int[][]a,int[][]b)throws IOException
	//public static void mupltiply(int[][]a,int[][]b)
	{
		//try
		//{
			int rowa=a.length;
			int cola=a[0].length;
			int rowb=b.length;
			int colb=b[0].length;
			int [][]c=new int[rowa][colb];
			if(cola!=rowb)
			{
			
				return null;
			}	//int [][]c=new int[nk][mc];
			else
			{
			for(int i=0;i<rowa;i++)
			{
				for(int j=0;j<colb;j++)
				{
					//c[i][j]=0;
					for(int k=0;k<cola;k++)
					{
						c[i][j]=c[i][j]+a[i][k]*b[k][j];
					}
				}
			}
			//return c;
			}
			return c;
		//}*/
		//catch(Exception e)
		//{
			//System.out.println(e);
		//}	
	}
}
