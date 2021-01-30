import java.util.Scanner;

public class Main2 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int N = sc.nextInt();
	int cnt = 0;
	
	while(N/7 !=0) {
		N=N/7;
		cnt++;
	}
	N = N+14;
	cnt = cnt-2;

}
	
	