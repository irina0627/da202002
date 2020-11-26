// TermProject2: ������ ���� �� �־����� �� ����

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(100); //seed�� 100���� ����
		
		
		// ������ ���� N �Է¹ޱ�
		System.out.print("N: ");
		int N = scan.nextInt();
		
		// ���� ���� K �Է¹ޱ�
		System.out.print("K: ");
		int K = scan.nextInt();
		
		// ũ�Ⱑ N�� �迭 ����
		int[] stack = new int[N];
		
		
		// ���� �ð� ����
		long t = System.currentTimeMillis();
		
		
		// N�� ������ ���� ����
		for(int i=0; i<N; i++) {
			stack[i] = rand.nextInt(N)+1;
			
			// �ߺ����� �ƴ��� Ȯ��
			for(int j=0; j<i; j++) { 
				if(stack[i] == stack[j]) {
					i--;
					break;
				}
			}
		}
		
		
		// K�� ���� ���� ���� (
		for(int i=0; i<K; i++) {
			
			int a = rand.nextInt(N)+1;
			int b = rand.nextInt(N)+1;
			int tmp;
			
			// b�� a���� ū ��� ���� �ٲ���
			if(b<a) {
				tmp = b;
				b = a;
				a = tmp;
			}
			
			/*
			//�̰� �����(������ ���ÿ� ����� �� Ȯ���ϱ�)
			for(int k=a; k<=b; k++) {
				System.out.println(stack[k-1]);
			}
			*/
			
			// a~b �������� �ִ밪, �ּҰ� ���ϱ�
			int max = stack[a-1];
			int min = stack[a-1];
			
			for(int j=(a-1); j<=(b-1); j++) {
				if(max<stack[j]) {
					max = stack[j];
				}
				if(stack[j]<min) {
					min = stack[j];
				}
			}
			
			// �ִ� �ּ��� �հ� ���ϱ�
			System.out.println(a+"~"+b+"��° ������ �ּҰ� �ִ밪 �հ�: "+(max+min));
			
		}
		
		// �ɸ� �ð� ����
		long elapsed = System.currentTimeMillis()-t;
		System.out.println("Elapsed : "+elapsed+"ms");
		
		scan.close();

	}
}
