package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorP {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 30, 18, 14, 11);
		
		list.sort(Comparator.comparingInt(value -> -value.intValue()));
		System.out.println(list);
		
		List<Integer> descList = list.stream().sorted((val1, val2) -> Integer.compare(val2, val1)).toList(); 
		System.out.println(descList);
		
		List<Integer> ascList = list.stream().sorted().toList(); //using natural sorting of Comparable with compareTo
		System.out.println(ascList);
		
		Comparator<Integer> comparatorD = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) return -1;
				else return 1;
			}
		};
		
		List<Integer> descList2 = list.stream().sorted(comparatorD).toList(); 	//using Comparator and compare() method for custom sorting
		System.out.println(descList2);
		
		List<String> students = Arrays.asList("Suresh", "Gopal", "Ravi", "Avi");
		
		Comparator<String> nameCom = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) return -1;
				else return 1;
			}};
		
		List<String> nameLen = students.stream().sorted(nameCom).toList();
		System.out.println(nameLen);
	}

}
