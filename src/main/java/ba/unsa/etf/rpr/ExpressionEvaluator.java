package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {


    private Stack<String> operatori;
    private Stack<Double> vrijednsoti;

    public ExpressionEvaluator() {
        this.operatori = new Stack<String>();
        this.vrijednsoti = new Stack<Double>();
    }

    public Double evaluate(String izraz) throws Exception {
        izraz+=" ";
        String temp = "";
        List<String> operatori = new ArrayList<>();
        operatori.add("+");
        operatori.add("-");
        operatori.add("/");
        operatori.add("*");
        operatori.add("%");
        char[] expressionArray = izraz.toCharArray();
        for(char c: expressionArray) {
            if(c == ' ') {
                if(temp.matches("(([0-9]+)\\.([0-9]+))|([0-9]+)") && validation(temp)) {
                    this.vrijednsoti.push(Double.parseDouble(temp));
                } else if (temp.matches("[%|*|+|[-]|/]") && validation(temp)) {
                    this.operatori.push(temp);
                } else if(temp.matches("[)]") && validation(temp)) {
                    double var1 = this.vrijednsoti.pop();
                    double var2 = this.vrijednsoti.pop();
                    String operator = this.operatori.pop();
                    double rez = 0;
                    if(operatori.contains(operator)){
                        rez=racunaj(var1,var2,operator);
                    }
                    this.vrijednsoti.push(rez);
                } else {
                    temp = "";
                    continue;
                }
                temp = "";
            } else {
                temp += c;
            }
        }
        return this.vrijednsoti.pop();
    }

    private boolean validation(String izraz) throws Exception {
        if(!(izraz.matches("(([0-9]+)\\.([0-9]+))|([0-9]+)") || izraz.matches("[%|*|+|[-]|/]") || (izraz.matches("[)]")) || izraz.matches("[(]") )) {
            throw new RuntimeException("Neispravna funkcija");
        }
        return true;
    }

    private double racunaj(double var1, double var2, String operator){
        if(operator.equals("+")){
            return var2 +var1;
        }
        else if(operator.equals("-")){
            return var2 - var1;
        }
        else if(operator.equals("*")){
            return var2 * var1;
        }
        else if(operator.equals("/")){
            return var2 / var1;
        }
        return var2 % var1;

    }


}