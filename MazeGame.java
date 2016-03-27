import java.util.*;
import java.io.*;
public class MazeGame
{
	public static void main(String[] args) throws Exception
	{
		
		int count=0;
		String line="";
		String line1="";
		FileReader file=new FileReader("CreateMaze.txt");
		BufferedReader read=new BufferedReader(file);
		FileReader file1=new FileReader("CreateMaze.txt");
		BufferedReader reader1=new BufferedReader(file1);
		while(line1!=null)
		{
			line1=read.readLine();
			count=count+1;	
		}
		String[][] maze=new String[count][4];
		maze[0][0]="0";
		maze[0][1]="0";
		maze[0][2]="0";
		maze[0][3]="0";
		int i=1;	
		String a[]=new String[5];
		while(i<count)
		{
			line=reader1.readLine();
			a=line.split(" ");
			maze[i][0]=a[1];
			maze[i][1]=a[2];
			maze[i][2]=a[3];
			maze[i][3]=a[4];
			i++;
		}			
		FileReader file2=new FileReader("TraverseMaze.txt");
		BufferedReader reader2=new BufferedReader(file2);
		FileReader file3=new FileReader("TraverseMaze.txt");
		BufferedReader reader3=new BufferedReader(file3);
		
		int c=-1;
		String line2="";
		String line3="";
		while(line2!=null)
		{
			line2=reader2.readLine();
			c=c+1;	
		}
		int j=0;
		String[] b;
		String d[]=new String[c];
		while(j<c)
		{
			line3=reader3.readLine();
			b=line3.split(" ");
			int t=0;
			int x=Integer.parseInt(b[0]);
			int z=1;
			int y=0;
			while((t<count)&&(z<b.length))
			{
				int e=Integer.parseInt(b[z]);
				y=Integer.parseInt(maze[x][e]);
				if(y==0)
				{
					x=x;
				}
				else
				{
					x=y;
				}
				z++;
			}
			String string=Integer.toString(x);
			d[j]=string;
			j++;
		}			
		
		File f=new File("Destinations.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		for(String s:d)
		{
			bw.write(s);
			bw.newLine();	
		}			
		bw.close();		
	}		
}
