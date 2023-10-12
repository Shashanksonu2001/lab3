package ci012;
import java.util.*;
public class mergesort {
static final int max=10005;
static int[] a=new int[max];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("merge sort");
		System.out.println("enter array max size: ");
		int n=sc.nextInt();
		Random ran =new Random();
		for(int i=0;i<n;i++) 
			a[i]=ran.nextInt(1000);
		long starttime=System.nanoTime();
		mergesortalgorithm(0,n-1);
		long stoptime=System.nanoTime();
		long elapsedtime=stoptime-starttime;
		System.out.println("time complexity for n="+n+"is: "+(double)elapsedtime);

	}
	public static void mergesortalgorithm(int low,int high) {
		int mid;
		if(low<high) {
			mid=(low+high)/2;
			mergesortalgorithm(low, mid);
			mergesortalgorithm(mid+1, high);
			merge(low,mid,high);
		}
	}
	public static void merge(int low,int mid,int high) {
		int[] b=new int[max];
		int i,h,j,k;
		h=i=low;
		j=mid+1;
		while((h<=mid)&&(j<=high))
			if(a[h]<a[j])
				b[i++]=a[h++];
			else
				b[i++]=a[j++];
		if(h>mid)
			for(k=j;k<=high;k++)
				b[i++]=a[k];
		else 
			for(k=h;k<=mid;k++)
				b[i++]=a[k];
		for(k=low;k<=high;k++)
			a[k]=b[k];
	}
}
