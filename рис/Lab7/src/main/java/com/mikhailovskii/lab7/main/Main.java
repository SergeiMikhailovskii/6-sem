package com.mikhailovskii.lab7.main;

import com.mikhailovskii.lab7.generator.EquationSolverIF;
import com.mikhailovskii.lab7.service.EquationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    private static final String CONFIGURATION_PATH = "strings.xml";

    public static void main(String[] args) {
        // ApplicationContext - содержит информацию о приложении
        ApplicationContext context = new ClassPathXmlApplicationContext(CONFIGURATION_PATH);

        // При помощи контекста из strings.xml получаем необходимый для решения уравнения бин
        EquationService service = (EquationService) context.getBean("equationService");

        System.out.println("1 - solve linear equation");
        System.out.println("2 - solve square equation ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter A coef:");
            int a = scanner.nextInt();
            System.out.println("Enter B coef:");
            int b = scanner.nextInt();
            System.out.println("Enter Y coef:");
            int y = scanner.nextInt();
            service.setEquationSolver((EquationSolverIF) context.getBean("linearEquationSolver"));
            service.setArguments(new int[]{a, b, y});
        } else if (choice == 2) {
            System.out.println("Enter A coef: ");
            int a = scanner.nextInt();
            System.out.println("Enter B coef: ");
            int b = scanner.nextInt();
            System.out.println("Enter C coef: ");
            int c = scanner.nextInt();
            service.setEquationSolver((EquationSolverIF) context.getBean("squareEquationSolver"));
            service.setArguments(new int[]{a, b, c});
        }

        double[] result = service.solveEquation();
        if (result != null) {
            for (double root : result) {
                System.out.println("Root: " + root);
            }
        } else {
            System.out.println("There are no roots!");
        }

    }

}
