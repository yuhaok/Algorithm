import java.util.*;

public class itemassociation {

	public static void main(String[] args) {
	    	String[][] lists = {//{"1","5"},
	    			            //{"1","6"},
	    			            //{"1","99"},
	//	    			        {"1","7"},
	//	    			        {"2","1"},
	    			            {"b","c"},
	//	    			        {"6","2"},
	    			            {"b","d"},
	//	    		            {"3","5"},
	    			            {"b","e"},
	    			            {"a","x"},
	//	    		            {"4","9"},
	    			            {"a","y"},
	    						{"a","z"},
            					{"1","6"},
            					{"1","99"},
            					{"0","1234"},
            					{"0","444"},
            					{"0","5555"}};
	    	System.out.println(bigU(lists));
    }
	 
    public static Set<String> bigU (String[][] lists){
    		if(lists.length == 0 || lists == null){
    			return new HashSet<>();
    		}
    		if(lists[0].length == 0){
    		}
    		Map<String,Set<String>> map = new HashMap<>();
    			
    		for(String[] temp:lists){
    			if(temp == null || temp.length == 0){
    				continue;
    			}
    			if(!map.containsKey(temp[0])){
    				map.put(temp[0], new HashSet<String>(Arrays.asList(temp[1])));
    			}else{
    				map.get(temp[0]).add(temp[1]);
    			}
    			if(!map.containsKey(temp[1])){
    				map.put(temp[1], new HashSet<String>(Arrays.asList(temp[0])));
    			}else{
    				map.get(temp[1]).add(temp[0]);
    			}
    			
    		}

    		Queue<Set<String>> minheap = new PriorityQueue<Set<String>>(1,new Comparator<Set<String>>(){
    			@Override
    			public int compare(Set<String> s1, Set<String> s2){
    				return Integer.compare(s2.size(), s1.size());
    			}
    		});

    		for(String temp: map.keySet()){
    			boolean flag = false;
    			
    			//check if the set we compareing right now is already contains in the set if true break;
    			for(Set<String> set: minheap){
    				if(set.contains(temp)){
    					flag = true;
    					break;
    				}
    			}
    			if(flag == true){
    				continue;
    			}else{
    				//here we use treeset because we want to compare the element if the length is same;
    				Set<String> set = new TreeSet<String>();
    				Queue<String> queue = new LinkedList<>();
    				queue.offer(temp);
    				while(!queue.isEmpty()){
    					String qcurr = queue.poll();
    					if(!set.contains(qcurr)){
    						set.add(qcurr);
    					}
    					for(String x:map.get(qcurr)){
    						if(!set.contains(x) && !queue.contains(x)){
    							queue.offer(x);
    						}
    					}
    				}
    				if(minheap.size() < 1){
    					minheap.add(set);
    				}else if(minheap.peek().size() < set.size()){
    					minheap.poll();
    					minheap.add(set);
    				}else if(minheap.peek().size() == set.size()){
    					String a = minheap.peek().toString();
    					String b = set.toString();
    					if(a.compareTo(b) > 0){
    						minheap.poll();
    						minheap.add(set);
    					}
    				}
    			}
    		}
    		return minheap.poll();
    }
}
