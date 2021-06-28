import java.util.Scanner;

class Stat {
	private int weekNum;
	private int value;
	private Stat prev;
	private Stat next;

	public Stat(int weekNum, int value) {
		this.weekNum = weekNum;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
	
	public void setNext(Stat next) {
		this.next = next;
	}

	public Stat getNext() {
		return (this.next);
	}

	public void setPrev(Stat prev) {
		this.prev = prev;
	}

	public Stat getPrev() {
		return (this.prev);
	}

	public int getValue() {
		return (this.value);
	}

	public int getWeekNum() {
		return (this.weekNum);
	}
}

public class Program {

	private static Stat list;
	private static int prevWeekNum;

	private static String min(String a, String b)
	{
		return ((Integer.parseInt(a) < Integer.parseInt(b)) ? a : b);
	}

	private static boolean isEnd(String s)
	{
		try {
			int num = Integer.parseInt(s);
			if (num == 42)
				return (true);
		} catch (Exception e) {
			return (false);
		}
		return (true);
	}

	private static void newStat(int weekNum, String stats) {
		String[] v = stats.split(" ");

		Stat stat = new Stat(weekNum, Integer.parseInt(min(min(min(v[0], v[1]), min(v[2], v[3])), v[4])));
		if (list == null) {
			list = stat;
		} else {
			list.setNext(stat);
			list.getNext().setPrev(list);
			list = list.getNext();
		}
	}

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		prevWeekNum = 0;
		list = null;
		
		while (sc.hasNext() && i < 18) {
			String line = sc.nextLine();
			int weekNum = 0;
			if (isEnd(line))
				break;

			weekNum = Integer.parseInt(line.split(" ")[1]);
			if (weekNum - 1 != prevWeekNum) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
					
			prevWeekNum = weekNum;

			newStat(weekNum, sc.nextLine());
			i = i + 1;
		}
		
		while (list.getPrev() != null)
			list = list.getPrev();
		
		while (list != null) {
			System.out.print("Week " + list.getWeekNum() + " ");
			for (int j = 0; j < list.getValue(); j++)
				System.out.print("=");
			System.out.println(">");
			list = list.getNext();
		}
		System.exit(0);
	}
}