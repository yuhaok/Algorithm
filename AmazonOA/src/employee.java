import java.util.*;


public class employee {

	public static void main(String[] args) {
        Employee bill = new Employee(1, "Bill");
        Employee dom = new Employee(2, "Dom");
        Employee simar = new Employee(3, "Simar");
        Employee michael = new Employee(4, "Michael");
        Employee bob = new Employee(5, "Bob");
        Employee peter = new Employee(6, "Peter");
        Employee porter = new Employee(7, "Porter");
        Employee milton = new Employee(8, "Milton");
        Employee nina = new Employee(9, "Nina");
       
        bill.getReports().add(dom);
        bill.getReports().add(simar);
        bill.getReports().add(michael);
		
        dom.getReports().add(bob);
        dom.getReports().add(peter);
        dom.getReports().add(porter);

        peter.getReports().add(milton);
        peter.getReports().add(nina);
        Employee ccm = commonmanager(bill, milton, nina);
        if(ccm == peter){
        		System.out.println("peter: Suck dick nina");
        }
        if (ccm != peter){
            throw new RuntimeException("Peter expected");
        }

        ccm = commonmanager(bill, nina, porter);
        if(ccm == dom){
    			System.out.println("dom: Suck dick nina");
        }
        if (ccm != dom){
            throw new RuntimeException("Dom expected");
        }

        ccm = commonmanager(bill, nina, simar);
        if(ccm == bill){
			System.out.println("bill: Suck dick nina");
        }
        if (ccm != bill){
            throw new RuntimeException("Bill expected");
        }

        ccm = commonmanager(bill, nina, peter);
        if(ccm == peter){
			System.out.println("peter: Suck dick nina");
        }
        if (ccm != peter){
            throw new RuntimeException("Peter expected");
        }
	}
    public static class Employee{
        private final int id;
        private final String name;
        private List<Employee> reports;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<Employee>();
        }
        

        public String getName() {
            return name;
        }
        
	    	public int getId(){
	    		return id;
	    	}
	    	
	    	public void addReport(Employee emp){
	    		reports.add(emp);
	    	}
	    	public List<Employee> getReports(){
	    		return reports;
	    	}
    	}
	    	
    	public static Employee commonmanager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
        if (ceo == null || firstEmployee == null || secondEmployee == null){
            return null;
        }
    		Deque<Employee> first = new LinkedList<>();
    		Deque<Employee> second = new LinkedList<>();
    		Employee root = ceo;
    		dfs(root, firstEmployee, first);
    		dfs(root, secondEmployee, second);
    		if( (!first.isEmpty() && first.peek().getId() == firstEmployee.getId())
    				&& (!second.isEmpty() && second.peek().getId() == secondEmployee.getId())) {
    			int size1 = first.size();
    			int size2 = second.size();
    			int diff = Math.abs(size1-size2);
    			if(size1 > size2) {
    				// first stack pop element until size equals the second
    				moveUp(first, diff);
    			} else {
    				moveUp(second, diff);
    			}
    			while(first.peek().getId() != second.peek().getId()) {
    				first.removeFirst();
    				second.removeFirst();
    			}
    			if(first.size() > 0) {
    				return first.removeFirst();
    			}
    		}
    		return null;
    	}
    	public static void moveUp(Deque<Employee> stack, int diff) {
    		while(diff > 0 && !stack.isEmpty()) {
    			stack.removeFirst();
    			diff--;
    		}
    	}
    	public static boolean dfs(Employee root, Employee curr, Deque<Employee> stack) {
    		stack.offerFirst(root);
    		if(root.getId() == curr.getId()) {
    			return true;
    		}
    		for(Employee em : root.getReports()) {
    			boolean res = dfs(em, curr, stack);
    			if(res) {
    				return true;
    			}
    		}
    		stack.removeFirst();
    		return false;
    	}
}
