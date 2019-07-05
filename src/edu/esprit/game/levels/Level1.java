package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;

public class Level1 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();
                System.out.println("*******1********");

		/* TO DO 1: Afficher tous les employ�s */
		employees.stream().forEach(e->System.out.println(e));
                System.out.println("*******2********");

		/*
		 * TO DO 2: Afficher les employ�s dont le nom commence par la lettre n
		 */
		employees.stream().filter(e->e.getName().charAt(0)=='n').forEach(e->System.out.println(e));

		/*
		 * TO DO 3: Afficher les employ�s dont le nom commence par la lettre n
		 * et le salaire> 1000
		 */
                System.out.println("*******3********");
		employees.stream().filter(e->e.getName().charAt(0)=='n').filter(e->e.getSalary()>1000)
                        .forEach(e->System.out.println(e));
		/*
		 * TO DO 4: Afficher les employ�s dont le nom commence par la lettre s
		 * tri�s par salaire
		 */
                System.out.println("*******4********");
		employees.stream().filter(e->e.getName().charAt(0)=='s').sorted((o1, o2) -> {
                    return o1.getSalary()-o2.getSalary(); //To change body of generated lambdas, choose Tools | Templates.
                }).forEach(e->System.out.println(e.toString()));

		/*
		 * TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2
		 * mani�res diff�rentes
		 */
		/* First Way */
                System.out.println("*******5A********");
		employees.stream().filter(e->e.getSalary()>600).forEach(e->System.out.println(e.getName()));
		/* Second Way */
                System.out.println("*******5B********");
		employees.stream().filter(e->e.getSalary()>600).map(e->e.getName())
				.forEach(e->System.out.println(e));

		/*
		 * TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m
		 * et les affich�s ensuite
		 */
                System.out.println("*******6********");
		employees.stream().filter(e->e.getName().charAt(0)=='m').forEach(e->{
                    e.setSalary(e.getSalary()+200);
                    System.out.println(e);
                });

	}
}
