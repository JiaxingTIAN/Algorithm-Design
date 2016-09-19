import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class OrderTallPeople {

	private static class Person {
		String name;
		int height;
		int tallCount;
		
		Person(int h, int t, String n){
			name = n;
			height = h;
			tallCount = t;
		}
		
		@Override
		public String toString() {
			return "<"+name+","+height+"," +tallCount+">";
		}
	}

	static class HeightComparator implements Comparator<Person> {
		public int compare(Person p1, Person p2){
			int ret  = p2.height - p1.height;
			return (ret == 0)?p1.tallCount - p2.tallCount:ret;
		}
	}


	public static List<Person> orderByHeightAndTaller(Person[] people){
		Arrays.sort(people, new HeightComparator());
		LinkedList<Person> ret = new LinkedList<>();
		for(Person p: people){
			ret.add(p.tallCount,p);
		}
		return ret;
	}

	public static void main(String[] args) {
		Person [] people = {
				new Person(6,2,"A"),
				new Person(1,4,"B"),
				new Person(11,0,"C"),
				new Person(5,1,"D"),
				new Person(5,3,"K"),
				new Person(10,0,"E"),
				new Person(4,0,"F")
				
				
		};
		System.out.println(orderByHeightAndTaller(people));
		
		
	}
	
	
}
