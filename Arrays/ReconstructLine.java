public class ReconstructLine {

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
		//Sort the number of tall people in ascending order
		//Sort the height according to descending order
		public static Comparator<Person> cmp = new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				if(p1.height != p2.height){
					return p2.height - p1.height;
				}
				return p1.tallCount - p2.tallCount;
			}
		};


		public static List<Person> orderByHeightAndTaller(Person[] people){
			Arrays.sort(people, cmp);
			List<Person> list = new LinkedList<>();
			for(Person p:people){
				list.add(p.tallCount, p);
			}
			return list;
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


