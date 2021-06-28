import java.util.Scanner;

public class Program {

	public static int sqrt(int num) {
		int i = 1;

		while ((i + 1) * (i + 1) <= num)
			i++;
		return (i);
	}

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		
		if (num <= 1) {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}
		
		double rt = sqrt(num);
		int i = 2;
		
		for (int div = 2; div <= rt; div++)
		{
			if (num % div == 0) {
				System.out.println("false " + (div - 1));
				System.exit(0);
			}
			i = div;
		}
		System.out.println("true " + i);
		System.exit(0);
	}
}