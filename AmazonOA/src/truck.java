import java.util.*;

public class truck {
	public static void main (String [] args){
	    	List<List<Integer>> input = new ArrayList<>();
	    	input.add(Arrays.asList(1,1));
	    	input.add(Arrays.asList(1,2));
	    	input.add(Arrays.asList(1,3));
	    	input.add(Arrays.asList(1,4));
	    	input.add(Arrays.asList(1,5));
	    	input.add(Arrays.asList(3,5));
	    	int n = 6; // n的地點
	    	int m = 3; // 選三個
		System.out.println(topk(input,n,m));
	}
	
	private static List<List<Integer>> topk(List<List<Integer>> input, int n, int m){
		//use max heap to save space so we dont have to appen everytime;
		List<List<Integer>> result = new ArrayList<>();
		if(input.size() == 0 || input == null){
			return result;
		}
		
		Queue<List<Integer>> maxheap = new PriorityQueue<>(m, new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> e1, List<Integer> e2){
				return e2.get(0) * e2.get(0) +  e2.get(1) * e2.get(1) - e1.get(0) *e1.get(0) - e1.get(1) *e1.get(1); 
			}
		});
		
    		for(List<Integer> temp:input){
    			if(maxheap.size() < m){
        			maxheap.add(temp);
    			}else if(check(maxheap.peek(), temp)){
    				maxheap.poll();
    				maxheap.add(temp);
    			}
    		}
		
		while(!maxheap.isEmpty()){
			result.add(maxheap.poll());
		}
		Collections.reverse(result);
		return result;
	}
	
	private static boolean check(List<Integer> e1, List<Integer> e2){
		int temp1 = e1.get(0) * e1.get(0) + e1.get(1) * e1.get(1);
		int temp2 = e2.get(0) * e2.get(0) + e2.get(1) * e2.get(1);
		if(temp1 > temp2){
			return true;
		}
		return false;
	}
}
