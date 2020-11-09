//Term Project(1): 구간에서 최소값 최대값 합계 구하기

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //데이터 개수 N 입력받기
		
		int a= scan.nextInt(); //a,b구간 입력받기
		int b= scan.nextInt(); //a,b구간 입력받기
		
		int[] stack = new int[N];
		
		//N개 데이터 랜덤함수로 생성
		for(int i=0; i<N; i++) {
			Random rand = new Random();
			stack[i] = rand.nextInt(N)+1;
			
			//중복인지 아닌지 확인
			for(int j=0; j<i; j++) { 
				if(stack[i] == stack[j]) {
					i--;
					break;
				}
			}
		}
		
		//이건 참고용(스택 확인하기)
		for(int i=0; i<N; i++) {
			System.out.println(stack[i]);
		}
		
		int max = stack[a-1];
		int min = stack[a-1];
		
		//최대 최소 구하기
		for(int i=(a-1); i<=(b-1); i++) {
			if(max<stack[i]) {
				max = stack[i];
			}
			if(stack[i]<min) {
				min = stack[i];
			}
		}
		
		System.out.println(a+"~"+b+"번째 구간의 최소값 최대값 합계: "+(max+min));
		
		scan.close();
	}
}
