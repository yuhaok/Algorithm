import java.util.*;

public class fruit {
    public static void main(String[] args){
        List<List<String>> fruitlist = new ArrayList<>();
        List<String> chart = new ArrayList<>();
        fruitlist.add(Arrays.asList("a", "a"));
        fruitlist.add(Arrays.asList("o", "anything","o"));
        List<List<String>> fruitlist2 = new ArrayList<>();
        //fruitlist.add(Arrays.asList("p", "o","g"));
        chart = Arrays.asList("o","a","a","o","b","o");
        List<String> chart2 = new ArrayList<>();
        chart2 = Arrays.asList("");
        System.out.println(checkWinner(fruitlist,chart));
        System.out.println(checkWinner(fruitlist2,chart));
        System.out.println(checkWinner(fruitlist,chart2));
    }
    
    public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {
    		if(codeList.size() == 0 || shoppingCart.size() == 0 || codeList == null || shoppingCart == null){
    			return 0;
    		}
    		int row = 0;
    		int col = 0;
    		int index = 0;
    		while(row < codeList.size()){
    			col = 0;
    			while(col < codeList.get(row).size() && index < shoppingCart.size()){
    				if(codeList.get(row).get(col) == shoppingCart.get(index) || codeList.get(row).get(col) == "anything"){
    					col++;
    					index++;
    				}else{
    					index++;
    				}
    			}
    			//if index has traverse the whole shopping list but row and col is not yet finiished return 0
    			//								if still has row || still has col
    			if(index == shoppingCart.size() && (row < codeList.size() - 1 || col < codeList.get(row).size())){
    				//no match;
    				return 0;
    			}
    			//go to the next row
    			row++;
    		}
    		return 1;
    }
}
