import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Employee> empList = new ArrayList<>();
		
		int n = 0;
		
		System.out.print("How Many employees will be registred? ");
		n = sc.nextInt();
		
		for(int i = 0; i < n ; i++) {
			System.out.println();
			System.out.println("Employee #"+(i+1)+": ");
			System.out.print("ID: ");
			int id = sc.nextInt();
			
			while(hasId(empList, id)) {
				System.out.println("Id already taken. Try again: ");
				id = sc.nextInt();
				
			}
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salary: ");
			double salario = sc.nextDouble();
			
			empList.add(new Employee(id, nome, salario));
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase : ");
		int id = sc.nextInt();
		Employee emp = empList.stream().filter(x -> x.getId() == id ).findFirst().orElse(null);
		if(emp != null) {
			System.out.print("Enter the percentage: ");
			double porcentagem = sc.nextDouble();
			emp.aumento(porcentagem);
		}else {
			System.out.println("This id does not exist! ");
		}
		
		System.out.println();
		for (Employee itens : empList) {
			System.out.println(itens);
		}
		sc.close();
	}
	

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

