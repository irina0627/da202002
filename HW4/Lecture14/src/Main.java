//	Lecture 14 ������׷����� ���� ū ���簢�� ���� ���ϱ�
//	������׷��� ������ �׷����� �׸� ���Դϴ�.
//	�̶� ��������� ������׷� �׷������� ���� ���� ���簢���� ���̸� ���ϴ� ������
//	�������� �˰����� ��ǥ�� �����Դϴ�.
//	�Է��� ������ ��(N)�� �Է¹ް� �� ������ ������ �Է¹޽��ϴ�.
//	{3, 1, 4, 3}�� ������ ���� ����� �Է�����
//	4 3 1 4 3
//	�� �˴ϴ�.
//	����� ���� ū ���簢�� ���̸� ����ϸ� �˴ϴ�.
//	6
import java.util.Scanner;
public class Main {
	//	���������� ���� histo �Լ�
	static int histo(int[] v, int a, int b) {
		if (a==b) return v[a];
		int c = (a+b)/2;
		int r = 2;
		int min =0;
		if (v[c]<v[c+1]) {
			min = v[c];
		}
		else {
			min = v[c+1];
		}
		int max = min*r;
		
		int i = c-1;
		int j = c+2;
		
		while(i>=a && j<=b) {
			if(v[i]<v[j]) {
				if(v[i]<min) min = v[i];
				i--;
			}
			else {
				if(v[j]<min) min = v[j];
				j++;
			}
			if(max < min*(++r)) {
				max = min*r;
			}
		}
		while(i>=a) {
			if(v[i] < min) {
				min = v[i];
				i--;
			}
			if(max < min*(++r)) {
				max = min*r;
			}
		}
		while(j<=b) {
			if(v[j] < min) {
				min = v[j];
				j++;
			}
			if(max < min*(++r)) {
				max = min*r;
			}
		}
	
		// ������ ��ü ������׷� �����鼭 max�� �����ϸ鼭 �ִ� ���̸� �� ���ߴٰ� �����ߴµ�
		// �� ���⿡�� �ٷ� return max�� �ϸ� �� �Ǵ��� �𸣰ڽ��ϴ٤Ф�
		
		return max;
		
	}
	//	���� ū ���簢���� ���̸� ��ȯ�մϴ�.
	//	n : ������ ��
	//	v : n���� ���õ��� ����
	//	��ȯ : ���簢���� ����
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	public static void main(String[] args) {
		//	��ĳ�� ������Ʈ ����
		Scanner scan = new Scanner(System.in);
		//	������ �� �Է�
		int n = scan.nextInt();
		// ������ ������ �迭 ����
		int[] v = new int[n];
		//	n���� ������ �Է¹޾� �迭 v�� ����
		for(int i = 0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		//	���� ū ���簢���� ���� ���
		int r = histo(v, n);
		//	���
		System.out.println(r);
		
		scan.close();
	}
}
