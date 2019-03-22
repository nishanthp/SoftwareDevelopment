package com.accpeted.submissions;

import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// A classic dfs. They are becoming very popular as you need to discuss 
	// how the input would look like. The employee class below.
	public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<Integer,Employee>();
        for(Employee employee : employees){
            map.putIfAbsent(employee.id, employee);
        }
        
        return dfs(map, id);
    }
    
    public int dfs(HashMap<Integer, Employee> map, int id){
        Employee emp = map.get(id);
        if (emp == null)  return 0;
        int importance=0;
        for(int subID : emp.subordinates) {
            importance += dfs(map, subID);
        }
        importance += emp.importance;
        return importance;
    }

}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};