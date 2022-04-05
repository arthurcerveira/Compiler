import java.io.*;
import java.util.*;

class MaquinaPilha {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("PUSH")) {
                    String numStr = line.split(" ")[1];
                    int num = Integer.parseInt(numStr);

                    stack.push(num);
                    continue;
                }

                if (line.startsWith("MUL")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();

                    int mult = num1 * num2;

                    stack.push(mult);
                    continue;
                }

                if (line.startsWith("DIV")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();

                    int div = num2 / num1;

                    stack.push(div);
                    continue;
                }

                if (line.startsWith("SUM")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();

                    int sum = num1 + num2;

                    stack.push(sum);
                    continue;
                }

                if (line.startsWith("SUB")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();

                    int sub = num2 - num1;

                    stack.push(sub);
                    continue;
                }

                if (line.startsWith("PRINT")){
                    int num = stack.pop();
                    System.out.println(num);

                    continue;
                }

                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Erro de compilação:\n" + e);
            e.printStackTrace();
        }
    }
}
