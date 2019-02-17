
public class RemoveDuplicate {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		removeDups(s);
	}

	private static void removeDups(String str) {

		if (null == str) {

			System.out.println("null input");

			return;

		}

		boolean[] check = new boolean[256];

		for (char ch : str.toCharArray()) {

			if (check[(int) ch])

				continue;

			System.out.println(ch);

			check[(int) ch] = true;

		}

	}

}
