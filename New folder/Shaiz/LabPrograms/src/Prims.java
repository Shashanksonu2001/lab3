import java.util.*;

public class Prims {
	final static int MAX=20;
	static int n;
	static int cost[][];
	static Scanner sc=new Scanner(System.in);
			public static void main(String args[])
	{
		ReadMatrix();
		prims();
	}
			
			static void ReadMatrix()
			{
				int i,j;
				cost=new int[MAX][MAX];
				System.out.println("enter the number of nodes: ");
				n=sc.nextInt();
				System.out.println("enter the adjacency matrix: ");
				{
					for(i=1;i<=n;i++)
						for(j=1;j<=n;j++)
						{
							cost[i][j]=sc.nextInt();
							if(cost[i][j]==0)
								cost[i][j]=999;
						}
				}
			}
			
			static void prims()
			{
				int visited[]=new int[10];
				int ne=1,i,min,j,a=0,b=0,u=0,v=0;
				int mincost=0;
				visited[1]=1;
				while(ne<n)
				{
					for(i=1,min=999;i<=n;i++)
					{
						for(j=1;j<=n;j++)
						{
							if((cost[i][j]<min) && (visited[i]!=0))
							{
								min=cost[i][j];
								a=u=i;
								b=v=j;
							}
						}
					}
					
					if(visited[u]==0 || visited[v]==0)
					{
						System.out.println("Edge "+ne++ +":(" +a+","+b+")"+"cost:" +min);
						mincost+=min;
						visited[b]=1;
					}
					cost[a][b]=cost[b][a]=999;
				}
				System.out.println("\n minimum cost: "+mincost);
			}
}
