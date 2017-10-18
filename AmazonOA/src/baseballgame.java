import java.util.*;

public class baseballgame {
	
	public static void main(String[] args){
		String[] testcase = new String[] {"5", "-2", "4", "Z","X", "9", "+", "+"};
		String[] testcase2 = new String[] {"Z", "Z", "Z", "Z","X", "Z", "1", "Z"};
		String[] testcase3 = new String[] {"X", "X", "X", "5","X", "+", "1", "1"};
		String[] testcase4 = new String[] {"+", "Z", "X", "1","X", "+", "1", "1"};
		String[] testcase5 = new String[] {};
		String[] testcase6 = new String[] {""};

		System.out.println(ball(testcase));
		System.out.println(ball(testcase2));
		System.out.println(ball(testcase3));
		System.out.println(ball(testcase4));
		System.out.println(ball(testcase5));
		System.out.println(ball(testcase6));

	}
	public static int ball (String[] scorelist) {
		int score = 0;
		if(scorelist == null || scorelist.length == 0){
			return score;
		}

		Deque<Integer> stack = new LinkedList<>();

		for(int i = 0; i < scorelist.length; i++){
			//to ensure a current index is not null if a current index 
			if(scorelist[i] == null){
				continue;
			}
			String temp = scorelist[i];
			if(isInteger(temp)){
				int curr = Integer.parseInt(scorelist[i]);
				stack.offerFirst(curr);
				score += curr;
			}else if(temp == "Z"){
				if(!stack.isEmpty()){
					int del = stack.removeFirst();
					score = score - del;
				}
			}else if(temp == "X"){
				if(!stack.isEmpty()){
					int multi = stack.peekFirst();
					score = score + (multi * 2);
					stack.offerFirst(multi * 2);
				}
			}else if(temp == "+"){
				if(!stack.isEmpty()){
					int addsecond = stack.removeFirst();
					if(!stack.isEmpty()){
						int addfirst = stack.removeFirst();
						score += addfirst;
						score += addsecond;
						stack.offerFirst(addfirst);
						stack.offerFirst(addsecond);
						stack.offerFirst(addfirst + addsecond);
					}else{
						score += addsecond;
						stack.offerFirst(addsecond);
						stack.offerFirst(addsecond); //curr;
					}
				}
			}//end+
		}//endfor;
		return score;
	}
	
	private static boolean isInteger(String number){
		try{
			Integer.parseInt(number);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
}
