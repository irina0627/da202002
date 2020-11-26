// TermProject2: 구간이 여러 개 주어졌을 때 문제

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(100); //seed값 100으로 설정
		
		
		// 데이터 개수 N 입력받기
		System.out.print("N: ");
		int N = scan.nextInt();
		
		// 구간 개수 K 입력받기
		System.out.print("K: ");
		int K = scan.nextInt();
		
		// 크기가 N인 배열 생성
		int[] stack = new int[N];
		
		
		// 현재 시간 측정
		long t = System.currentTimeMillis();
		
		
		// N개 데이터 랜덤 생성
		for(int i=0; i<N; i++) {
			stack[i] = rand.nextInt(N)+1;
			
			// 중복인지 아닌지 확인
			for(int j=0; j<i; j++) { 
				if(stack[i] == stack[j]) {
					i--;
					break;
				}
			}
		}
		
		
		// K개 구간 랜덤 생성 (
		for(int i=0; i<K; i++) {
			
			int a = rand.nextInt(N)+1;
			int b = rand.nextInt(N)+1;
			int tmp;
			
			// b가 a보다 큰 경우 서로 바꿔줌
			if(b<a) {
				tmp = b;
				b = a;
				a = tmp;
			}
			
			/*
			//이건 참고용(구간별 스택에 저장된 값 확인하기)
			for(int k=a; k<=b; k++) {
				System.out.println(stack[k-1]);
			}
			*/
			
			// a~b 구간에서 최대값, 최소값 구하기
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
			
			// 최대 최소의 합계 구하기
			System.out.println(a+"~"+b+"번째 구간의 최소값 최대값 합계: "+(max+min));
			
		}
		
		// 걸린 시간 측정
		long elapsed = System.currentTimeMillis()-t;
		System.out.println("Elapsed : "+elapsed+"ms");
		
		scan.close();

	}
}
