package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Level2 {
	public static void main(String[] args) {
	List<Employee> employees = Data.employees();

	           System.out.println("Retourner le nombre des employ�s dont le nom commence avec n ");
	long nbr = employees.stream().filter(e->e.getName().charAt(0)=='n').count();
            System.out.println(nbr);
				
	System.out.println("Retourner la somme des salaires de tous les employ�s (hint: mapToInt)");	
	long sum = employees.stream().mapToInt(e ->e.getSalary()).sum();
	           System.out.println(sum);	
	System.out.println("Retourner la moyenne des salaires des employ�s dont le nom commence avec s");	
	    OptionalDouble average = employees.stream().filter(e->e.getName().charAt(0)=='s').mapToDouble(e->e.getSalary()).average();
		          System.out.println(average);
		
	System.out.println("Retourner la liste de tous les employ�s");	
	List<Employee> emps = employees.stream().collect(Collectors.toList());
		          System.out.println(emps);
		System.out.println("Retourner la liste des employ�s dont le nom commence par s");	
		List<Employee> emps2 = employees.stream().filter(e->e.getName().startsWith("s")).collect(Collectors.toList());
		          System.out.println(emps2);
		
	System.out.println("Retourner true si il y a au min un employ�s dont le salaire > 1000, false si non");
	boolean test = employees.stream().filter(e->e.getSalary()>0).count()!=0;
				        System.out.println(test);
	System.out.println("Afficher le premier employ� dont le nom commence avec s avec deux mani�res diff�rentes First way");
	employees.stream().filter(e->e.getName().charAt(0)=='s').findFirst().ifPresent(e->System.out.println(e));
	System.out.println("Second way");
	           employees.stream().filter(e->e.getName().startsWith("s")).limit(1).forEach(e->System.out.println(e));
		
	System.out.println("Afficher le second employ� dont le nom commence avec s ");
	employees.stream().filter(e->e.getName().startsWith("s")).skip(1).findAny().ifPresent(e->System.out.println(e));
		
		 System.out.println(" Afficher n'importe quel employé dont le nom commence avec n ");    
        employees.stream().filter(e->e.getName().startsWith("n")).findAny().ifPresent(e->System.out.println(e));
        System.out.println(" vérifier l'existance d'un employé dont le nom commence par a ");
        boolean x = employees.stream().filter(e->e.getName().startsWith("a")).findAny().isPresent();
            System.out.println(x);
        System.out.println("Afficher les employés sans redondance");
        employees.stream().distinct().forEach(e->System.out.println(e));
        
        System.out.println(" Afficher l'employé ayant le salaire max");
          
        employees.stream().max((o1, o2) -> o1.getSalary()-o2.getSalary()).ifPresent(e->System.out.println(e));

	}
}
