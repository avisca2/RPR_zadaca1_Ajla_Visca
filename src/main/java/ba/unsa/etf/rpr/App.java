package ba.unsa.etf.rpr;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String function;
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        System.out.println("Unesite izraz: ");
        Scanner unos = new Scanner(System.in);
        function = unos.nextLine();
        System.out.println(evaluator.evaluate(function));
    }
}