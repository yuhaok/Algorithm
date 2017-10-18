import java.util.*;


public class sortstack {

	public static void main(String[] args) {
		int[] number = new int[] {34,1,1,1,37, 3, 3,3,3,3,3, 98, 92, 23, 1, 2, 100};

		Deque<Integer> s1 = new LinkedList<>();
		Deque<Integer> s2 = new LinkedList<>();
		for(int i = 0; i < number.length; i++){
			s1.offerFirst(number[i]);
		}
		System.out.println(abc(s1, s2));
	}
	private static Deque<Integer> abc(Deque<Integer> s1, Deque<Integer> s2){
		//List<Integer> result = new ArrayList<>();
		if(s1 == null || s1.size() == 0){
			return s1;
		}
		//Complexity O(n^2) 
		while(!s1.isEmpty()){
			int temp = s1.removeFirst();
			int count = 0;
			
			while(!s2.isEmpty() && s2.peekFirst() > temp){
				s1.offerFirst(s2.removeFirst());
				count++;
			}
			s2.offerFirst(temp);
						
			for(int i = 0; i < count; i++){
				s2.offerFirst(s1.removeFirst());
			}
		}
		/*
		while(!s2.isEmpty()){
			result.add(s2.removeFirst());
		}
		*/
		return s2;
	}

}
