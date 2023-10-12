import java.util.*;

public class Prims {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n=sc.nextInt();
		int [][] costMatrix=new int[n][n];
		boolean[] visited=new boolean[n];
		System.out.println("Enter the cost adjacency matrix: ");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				costMatrix[i][j]=sc.nextInt();
			}
		for(int i=0;i<n;i++)
			visited[i]=false;
		System.out.println("Enter source vertex: ");
		int srcVertex=sc.nextInt();
		visited[srcVertex]=true;
		int source=0,cost=0,target=0;
		System.out.println("Edges: ");
		for(int i=1;i<n;i++)
		{
			int min=Integer.MAX_VALUE;
			for(int j=0;j<n;j++)
			{
				if(visited[j])
				{
					for(int k=0;k<n;k++)
					{
						if(!visited[k] && min>costMatrix[j][k])
						{
							min=costMatrix[j][k];
							source=j;
							target=k;
						}
					}
				}
			}
			visited[target]=true;
			System.out.println("("+(source+1)+","+(target+1)+")"+cost);
			cost+=min;
		}
		System.out.println("\nMinimum cost of spanning tree: "+cost);
	}

}
