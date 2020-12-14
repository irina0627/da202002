import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//org
	static void minmaxsum(int[] v, int n, int[] a, int[] b, int k,
			int[] rmin, int[] rmax, long[] rsum) {
		for(int t = 0; t<k; t++) {
			int min = v[a[t]-1];
			int max = v[a[t]-1];
			long sum = v[a[t]-1];
			for(int i = a[t]; i<b[t]; i++) {
				if(min>v[i]) min = v[i];
				if(max<v[i]) max = v[i];
				sum += v[i];
			}
			rmin[t] = min;
			rmax[t] = max;
			rsum[t] = sum;
		}
	}
		
	//new
	static int init (int[] nums, int[] tree, int node, int start, int end) {
		if(start == end) return tree[node] = nums[start];
		
		int mid = (start+end)/2;
		
		return tree[node] = init(nums, tree, node*2, start, mid) + init(nums,tree,node*2+1, mid+1, end);
	}
	
	
	static int sum(int[] tree, int node, int start, int end, int left, int right) {
		if(left>end || right<start) return 0;
		if(left<=start && end <= right) return tree[node];
		int mid = (start+end)/2;
		return sum(tree, node*2, start, mid, left, right) +sum(tree, node*2+1, mid+1, end, left,right);
	}


	static void minmaxsum2(int[] v, int n, int[] a, int[] b, int k,
			int[] rmin, int[] rmax, long[] rsum) {

		for(int t = 0; t<k; t++) {
			
			int[] tree;
			tree = new int[n*4];
			
			rsum[t] = sum(tree, 0, 0, n-1, a[t], b[t]);
			rmin[t] = init(tree,);
			rmax[t] = tree[tree.length-1];
		}
	}
	
//////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(1000);
		
		int n = scan.nextInt();
		int[] v = new int[n];
		
		for(int i=0; i<n; i++) v[i] = rand.nextInt();
		
		int k = scan.nextInt();
		
		int[] a = new int[k];
		int[] b = new int[k];
		
		for(int i=0; i<k; i++) {
			int x = rand.nextInt(n);
			int y = rand.nextInt(n);
			if(x<y) {
				a[i] = x; b[i]=y;
			}
			else {
				a[i] = y; b[i]=x;
			}
		}
		
		int[] min = new int[k];
		int[] max = new int[k];
		long[] sum = new long[k];
		
		long t = System.currentTimeMillis();
		minmaxsum(v, n, a, b, k, min, max, sum);
		t = System.currentTimeMillis()-t;
		System.out.println("org: elapsed time is "+t);
		
		long t1 = System.currentTimeMillis();
		minmaxsum2(v, n, a, b, k, min, max, sum);
		t1 = System.currentTimeMillis()-t1;
		System.out.println("new: elapsed time is "+t1);
		
		scan.close();
	}
}
