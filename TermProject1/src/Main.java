//Term Project(1): �������� �ּҰ� �ִ밪 �հ� ���ϱ�

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //������ ���� N �Է¹ޱ�
		
		int a= scan.nextInt(); //a,b���� �Է¹ޱ�
		int b= scan.nextInt(); //a,b���� �Է¹ޱ�
		
		int[] stack = new int[N];
		
		//N�� ������ �����Լ��� ����
		for(int i=0; i<N; i++) {
			Random rand = new Random();
			stack[i] = rand.nextInt(N)+1;
			
			//�ߺ����� �ƴ��� Ȯ��
			for(int j=0; j<i; j++) { 
				if(stack[i] == stack[j]) {
					i--;
					break;
				}
			}
		}
		
		//�̰� �����(���� Ȯ���ϱ�)
		for(int i=0; i<N; i++) {
			System.out.println(stack[i]);
		}
		
		int max = stack[a-1];
		int min = stack[a-1];
		
		//�ִ� �ּ� ���ϱ�
		for(int i=(a-1); i<=(b-1); i++) {
			if(max<stack[i]) {
				max = stack[i];
			}
			if(stack[i]<min) {
				min = stack[i];
			}
		}
		
		System.out.println(a+"~"+b+"��° ������ �ּҰ� �ִ밪 �հ�: "+(max+min));
		
		scan.close();
	}
}
