package hackerearth.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicalNumberSorter {
	static class NumberSorter implements Comparator<Integer> {
		private static final Map<String, Character> map = new HashMap<>();
		static {

			char val[] = { 'O', 'T', 'T', 'F', 'F', 'S', 'S', 'E', 'N', 'T',
					'E', 'T', 'T', 'F', 'F', 'S', 'S', 'E', 'N', 'T' };
			Integer i = 1;
			for (char v : val) {
				map.put(i.toString(), v);
				i++;
			}
		}

		@Override
		public int compare(Integer f, Integer s) {
			String first = f.toString();
			System.out.println(first);
			String second = s.toString();
			System.out.println(second);
			String cF = first.charAt(0) + "";
			String cS = second.charAt(0) + "";
			if (first.length() % 3 == 2 && first.charAt(1) == '1') {
				cF += first.charAt(1);
			}
			if (second.length() % 3 == 2 && second.charAt(1) == '1') {
				cS += second.charAt(1);
			}
			System.out.println("compare :" + map.get(cF) + ":" + map.get(cS));
			if (map.get(cF) <= map.get(cS)) {
				return -1;
			}
			return 1;
		}

		public static void main(String args[]) {
			Integer array[] = { 711, 16, 8, 9, 32700, 97326, 1023161, 23161,
					11230, 161 };
			List<Integer> list=Arrays.asList(array);
			Collections.sort(list, new NumberSorter());
			System.out.println(list);
			
		}
		
		

	}
}
