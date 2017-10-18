import java.util.*;

public class Menu {

	public static void main(String[] args) {
		 List<List<String>> list1 = new ArrayList<>();
		 List<List<String>> list2 = new ArrayList<>();
		 list1.add(Arrays.asList("Zhang","Chinese"));
		 list1.add(Arrays.asList("Li","American"));
		 list1.add(Arrays.asList("Wang","Japanese"));
		 list1.add(Arrays.asList("Ming","*"));
		 list2.add(Arrays.asList("Chinese","Pork"));
		 list2.add(Arrays.asList("Chinese","fish"));
		 list2.add(Arrays.asList("Chinese","fack"));
		 list2.add(Arrays.asList("Chinese","f"));
		 list2.add(Arrays.asList("Chinese","e"));
		 list2.add(Arrays.asList("Chinese","g"));
		 list2.add(Arrays.asList("Chinese","t"));
		 list2.add(Arrays.asList("Chinese","e"));

		 list2.add(Arrays.asList("American","beef"));
		 System.out.println(menu(list1,list2));
	}
	
	
	private static List<List<String>> menu(List<List<String>> list1, List<List<String>> list2){
		List<List<String>> result = new ArrayList<>();
		if(list1.size() == 0 || list2.size() == 0 || list1 == null || list2 == null){
			return result;
		}
		
		Map<String, Set<String>> map = new HashMap<>();
		for(List<String> temp: list2){
			if(!map.containsKey(temp.get(0))){
				map.put(temp.get(0), new HashSet<String>(Arrays.asList(temp.get(1))));
			}else{
				map.get(temp.get(0)).add(temp.get(1));
			}
		}
		
		for(int i = 0; i < list1.size(); i++){
			if(map.containsKey(list1.get(i).get(1))){
				for(String dishes:map.get(list1.get(i).get(1))){
					result.add(Arrays.asList(list1.get(i).get(0), dishes));
				}
			}
			//if someone has no preference print all;
	   		if (list1.get(i).get(1) == "*"){
	   			for (Set<String> dishes:map.values()){
	   				for (String dish : dishes){
	   					result.add(Arrays.asList(list1.get(i).get(0),dish));
	   				}
				}
			}
   		 }
		return result;
	}

}
