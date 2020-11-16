//문제 2) 백준 10845

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int[] queue = new int[10000];
		int head = 0;
		int tail = 0;
		int size = 1000;
		
		System.out.print("Enter n : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			
			String com = scan.next();
			
			switch(com) {
			
			case "push":
				int num = scan.nextInt();
				queue[tail] = num;
				tail = (tail+1)%size;
				break;
				
			case "pop":
				if(head == tail) {
					System.out.println(-1);
					continue;
				}
				int v = queue[head];
				head = (head+1)%size;
				System.out.println(v);
				break;
				
			case "size":
				System.out.println((tail-head+size)%size);
				break;
				
			case "empty":
				if(head == tail) {
					System.out.println(1);
					continue;
				}
				System.out.println(0);
				break;
				
			case "front":
				if(head == tail) {
					System.out.println(-1);
					continue;
				}
				System.out.println(queue[head]);
				break;
				
			case "back":
				if(head == tail) {
					System.out.println(-1);
					continue;
				}
				System.out.println(queue[tail-1]);
				break;
			}
		
		}

		scan.close();
	}

}
