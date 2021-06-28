import java.util.Scanner;

public class Program {

	public static int sqrt(int num) {
		int i = 1;

		while ((i + 1) * (i + 1) <= num)
			i++;
		return (i);
	}

	private static int getSum(int num) {
		int res = 0;

		while (num > 0)
		{
			res += num % 10;
			num = num / 10;
		}
		return (res);
	}

	private static boolean isPrime(int num) {
		double rt = sqrt(num);
		for (int div = 2; div <= rt; div++)
		{
			if (num % div == 0) {
				return (false);
			}
		}
		return (true);
	}

    public static void main(String[] args) {
		
		int coffeeCount = 0;

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int num = sc.nextInt();
			if (num == 42)
				break;
			if (isPrime(getSum(num)) == true)
				coffeeCount++;
		}
		
		System.out.println("Count of coffee-request – " + coffeeCount);
		System.exit(0);
	}
}