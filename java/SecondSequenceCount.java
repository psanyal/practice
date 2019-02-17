import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SecondSequenceCount {
	public static void main(String args[]) throws IOException {
		int i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = new String[n];
			HashMap<String, Integer> m = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (i = 0; i < n; i++) {
				s[i] = st.nextToken();
				if (m.containsKey(s[i])) {
					m.put(s[i], m.get(s[i]) + 1);
				} else {
					m.put(s[i], 1);
				}
			}
			Collection<Integer> c = m.values();
			ArrayList<Integer> al = new ArrayList<>(c);
			Collections.sort(al);
			int l = al.get(al.size() - 2);
			for (Map.Entry<String, Integer> e : m.entrySet()) {

				Integer value = e.getValue();
				if (value.equals(l)) {
					String key = e.getKey();
					System.out.println(key);
					break;
				}
			}
			t--;
		}
	}
}