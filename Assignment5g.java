/*
 * @author : Vaishakhi Kulkarni
 * Net Id  : vpk140230
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Assignment4f {

	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;

	static LinkedList<Integer> L1 = new LinkedList<Integer>();
	static TreeSet<Integer> T1 = new TreeSet<Integer>();
	static HashSet<Integer> H1 = new HashSet<Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in, in1, in2;
		if (args.length > 0) {
			in = new Scanner(new File(args[0]));
			in1 = new Scanner(new File(args[0]));
			in2 = new Scanner(new File(args[0]));
		} else {
			in = new Scanner(System.in);
			in1 = new Scanner(System.in);
			in2 = new Scanner(System.in);
		}

		System.out.println("TreeSet");
		timer();
		TreesSet(in);
		timer();

		System.out.println("HashSet");
		timer();
		HashsSet(in1);
		timer();

		System.out.println("LinkedList");
		timer();
		arrayList(in2);
		timer();

	}

	// operations performed on LinkedList
	public static void arrayList(Scanner in2) {
		int s;
		while (in2.hasNext()) {
			s = in2.nextInt();
			int numbers = in2.nextInt();
			if (s == 0) { // Perform insert operation
				if (!L1.contains(numbers))
					L1.add(numbers);
			} else if (s == 1) { // Check whether element is present if yes then
									// perform delete operation in LinkedList
				if (L1.contains(numbers)) {
					int x = L1.indexOf(numbers); // find the index of the
													// element
					L1.remove(x);
				}
			} else if (s == 2) { // Perform Contains check
				L1.contains(numbers);

			}
		}
	}

	// Operations performed on TreeSet
	public static void TreesSet(Scanner in) {
		int s;
		while (in.hasNext()) {
			s = in.nextInt();
			int numbers = in.nextInt();
			if (s == 0) { // Perform Insert
				T1.add(numbers);
			} else if (s == 1) { // Check whether element is present in the
									// TreeSet.If yes then delete
				if (T1.contains(numbers)) {
					T1.remove(numbers);
				}
			} else if (s == 2) { // Perform contains check
				T1.contains(numbers);
			}
		}
	}

	// Operations performed on HashSet
	public static void HashsSet(Scanner in1) {
		int s;
		while (in1.hasNext()) {
			s = in1.nextInt();
			int numbers = in1.nextInt();
			if (s == 0) { // Perform insert
				H1.add(s);
			} else if (s == 1) { // Perform remove but before that check whether
									// element is present in the HashSet
				if (H1.contains(numbers)) {
					H1.remove(numbers);
				}
			} else if (s == 2) { // Perform Contains check
				H1.contains(numbers);
			}
		}
	}

	// To find the time
	public static void timer() {
		if (phase == 0) {
			startTime = System.currentTimeMillis();
			phase = 1;
		} else {
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("Time: " + elapsedTime + " msec.");
			memory();
			phase = 0;
		}
	}

	// Memory usage
	public static void memory() {
		long memAvailable = Runtime.getRuntime().totalMemory();
		long memUsed = memAvailable - Runtime.getRuntime().freeMemory();
		System.out.println("Memory: " + memUsed / 1000000 + " MB / "
				+ memAvailable / 1000000 + " MB.");
	}

}
