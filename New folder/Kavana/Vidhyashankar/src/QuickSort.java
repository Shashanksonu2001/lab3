
import java.util.Scanner;
import java.util.Random;
import java.util.*;
public class QuickSort {
	public static int [] a=new int[5000];
			public static void main(String args[])
			{
				Scanner sc=new Scanner(System.in);
			Random r=new Random();
			System.out.println("enter the array size: ");
			int n=sc.nextInt();
			System.out.println("enter the array elements: ");
			for(int i=0;i<n;i++)
				a[i]=r.nextInt(1000);
			System.out.println("unsorted array: ");
			for(int i=0;i<n;i++)
				System.out.println(a[i]);
			long start=System.nanoTime();
			Quicksort(0,n-1);
			long stop=System.nanoTime();
			long elapsed =stop-start;
			System.out.println("sorted array: ");
			for(int i=0;i<n;i++)
				System.out.println(a[i]);
			System.out.println("time complexity for n=" + n +" is: "+(double)elapsed);
			
			}
	public static void Quicksort(int low,int high)
	{
		if(low<high)
		{
			int j=partition(low,high+1);
			Quicksort(low,j-1);
			Quicksort(j+1,high);
		}
	}
	
	public static int partition(int low,int high)
	{
		int i=low;
		int j=high;
		int pivot=a[low];
		while(i<j)
		{
			do {
				i++;
				
			}while(a[i]<pivot && i<high);
			
			do {
				j--;
			}while(a[j]>pivot && j>low);
			
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