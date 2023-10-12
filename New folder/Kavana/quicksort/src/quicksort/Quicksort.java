package quicksort;
import java.util.Random;
import java.util.Scanner;
public class Quicksort {

static int[]a=new int[500000];
static int n;
private static Scanner s;
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    	Random r=new Random();
    	s=new Scanner(System.in);
    	System.out.print("enter max array size:");
    	int n=s.nextInt();
    	Random random=new Random();
    	System.out.println("enter the array elements:");
    	for(int i=0;i<n;i++)
    	{
    		a[i]=random.nextInt(1000);
    	}
    	System.out.println("input array:");
    	for(int i=0;i<n;i++)
    	{
    		System.out.print(a[i]+"\t");
    	}
    	long startTime=System.nanoTime();
    	quicksort(0,n-1);
    	long stopTime=System.nanoTime();
		long elapsedTime=stopTime-startTime;
    	System.out.println("\n sorted array:"); 
    	for(int i=0;i<n;i++)
    	{
    		System.out.println();
    		System.out.println("\nTime complexity in ns for n= "+n+"is: "+(double)elapsedTime/1000000);}
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
    	public static int partition (int low,int high)
    	{
    		int pivot=a[low];
    		int i=low;
    		int j=high;
    		while(i<j) {
    			do {
    				i++;
    			}
    			while(a[j]>pivot&&i<high);
    			do {
    				j--;
    			}
    			while(a[j]>pivot&&j>low);
    			if(i<j) {
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
    		
