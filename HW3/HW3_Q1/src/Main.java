//���� 1)

import java.util.Random;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		
		//ť ����
		int[] queue = new int[10000];
		int head = 0;
		int tail = 0;
		
		//���� ����
		int[] stack = new int[10000];
		int top = -1;
		
		//���� n �Է¹ޱ�
		System.out.print("Enter n : ");
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		//ť�� n���� ���� ���� �ֱ�
		Random rand = new Random();
		for(int i=0; i<n; i++) {
			queue[tail] = rand.nextInt(10000);
			tail = (tail+1)%10000;
		}
		
		//Ȯ��
		System.out.println("ť�� ������ Ȯ��");
		for(int i=head; i<tail; i++) {
			System.out.println("queue["+i+"] : "+queue[i]);
		}
		
		System.out.println("head: "+head +", tail: "+ tail);
		
		
		
		while(head != tail) {
			//ť���� ���� �ϳ� ������
			int j = queue[head];
			head = (head+1)%10000;
			
			
			while(top != -1 && stack[top]<j) {
				queue[tail] = stack[top--];
				tail = (tail+1)%10000;
			}
			
			stack[++top] = j;
			
		}

		
		System.out.println("������ ���ĵ� ������ ���");
		for(int i=top; i>=0; i--) {
			System.out.println("stack["+i+"] : "+stack[i]);
		}
		
		scan.close();
	}
}