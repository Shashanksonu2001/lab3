import java.util.*;
public class Mergesort {
	static final int MAX=10005;
	static int[] a=new int[MAX];

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the max array size:");
		int n=input.nextInt();
		Random ran=new Random();
		for(int i=0;i<n;i++)
		{
			a[i]=ran.nextInt(1000);
		}
		System.out.println("Unsorted Array:");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]+"");
		}
		long startTime=System.nanoTime();
		mergesort(0,n-1);
		long stopTime=System.nanoTime();
		long elapsedTime=stopTime-startTime;
		System.out.println("Sorted Array");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]+"");
		}
		System.out.println("The Time complexity in (ns) for n= "+n+" is: "+(double)elapsedTime);
		input.close();
	}
	public static void mergesort(int low, int high)
	{
		int mid;
		if(low<high)
		{
			mid=(low+high)/2;
			mergesort(low,mid);
			mergesort(mid+1,high);
			merge(low,mid,high);
		}
	}
	public static void merge(int low,int mid,int high)
	{
		int [] b=new int[MAX];
		int i,j,k,h;
		h=i=low;
		j=mid+1;
		while((h<=mid)&&(j<=high))
		{
			if(a[h]<a[j])
			{
				b[i++]=a[h++];
			}
			else
			{
				b[i++]=a[j++];
			}
		}
			if(h>mid)
			{
				for(k=j;k<=high;k++)
				{
					b[i++]=a[k];
				}
			}
			else
			{
				for(k=h;k<=mid;k++)
				{
					b[i++]=a[k];
				}
				for(k=low;k<=high;k++)
				{
					a[k]=b[k];
				}
			}
		
	
	}

}
