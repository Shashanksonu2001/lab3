import java.util.*;

public class QuickSort {
	static int[] a=new int[500000];
	static int n;
	private static Scanner s;

	public static void main(String[] args) {
		s=new Scanner(System.in);
		System.out.println("Enter max array size: ");
		int n=s.nextInt();
		Random r=new Random();
		for(int i=0;i<n;i++)
			a[i]=r.nextInt(1000);
		System.out.println("Unorted array: ");
		for(int i=0;i<n;i++)
			System.out.println(a[i]+" ");
		long startTime=System.nanoTime();
		quicksort(0,n-1);
		long stopTime=System.nanoTime();
		long elapsedTime=stopTime-startTime;
		System.out.println("Sorted array: ");
		for(int i=0;i<n;i++)
			System.out.println(a[i]+" ");
		System.out.println("\nTime complexity in ns for n= "+n+"is: "+(double)elapsedTime/1000000);
	}
	
	public static void quicksort(int low,int high)
	{
		if(low<high)
		{
			int j=partition(low,high+1);
			quicksort(low,j-1);
			quicksort(j+1,high);
		}
	}
	
	public static int partition(int low,int high)
	{
		int pivot=a[low];
		int i=low;
		int j=high;
		while(i<j)
		{
			do
			{
				i++;
			}while(a[i]<=pivot && i<high);
			do
			{
				j--;
			}while(a[j]>=pivot && j>low);
			if(i<j)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		a[low]=a[j];
		a[j]=pivot;
		return j;
	}

}
