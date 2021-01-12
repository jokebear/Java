import java.util.Scanner;

public class Main_B_2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		int a,b;
		
		a = Math.max(input1,input2);
		b = Math.min(input1,input2);
		
		int x=1;
		int num = 2;
		while(num<=a) {
			if(a%num==0&&b%num==0) {
				x*=num;
				a/=num;
				b/=num;
			}
			else
				num++;
		}
		System.out.println(x);
		System.out.println(input1*input2/x);		
	}
}
