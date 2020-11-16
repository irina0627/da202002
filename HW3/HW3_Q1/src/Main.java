//문제 1)

import java.util.Random;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		
		//큐 생성
		int[] queue = new int[10000];
		int head = 0;
		int tail = 0;
		
		//스택 생성
		int[] stack = new int[10000];
		int top = -1;
		
		//숫자 n 입력받기
		System.out.print("Enter n : ");
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		//큐에 n개의 랜덤 숫자 넣기
		Random rand = new Random();
		for(int i=0; i<n; i++) {
			queue[tail] = rand.nextInt(10000);
			tail = (tail+1)%10000;
		}
		
		//확인
		System.out.println("큐의 데이터 확인");
		for(int i=head; i<tail; i++) {
			System.out.println("queue["+i+"] : "+queue[i]);
		}
		
		System.out.println("head: "+head +", tail: "+ tail);
		
		
		
		while(head != tail) {
			//큐에서 숫자 하나 꺼내기
			int j = queue[head];
			head = (head+1)%10000;
			
			
			while(top != -1 && stack[top]<j) {
				queue[tail] = stack[top--];
				tail = (tail+1)%10000;
			}
			
			stack[++top] = j;
			
		}

		
		System.out.println("스택의 정렬된 데이터 출력");
		for(int i=top; i>=0; i--) {
			System.out.println("stack["+i+"] : "+stack[i]);
		}
		
		scan.close();
	}
}