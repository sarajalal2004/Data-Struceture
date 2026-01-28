import java.util.Arrays;
import java.util.Stack;

public class main {
    ////////////////////////////////
    // Exercise 1: rotate the array
    ////////////////////////////////
    public static void rotate(char[] arr, int d, int n){
        char[] arrtemp = Arrays.copyOf(arr, n);
        for(int i = 0; i < arr.length; i++){
            arr[(i + d) % n] = arrtemp[i];
        }
    }

    public static void printArray(char[] arr){
        for( char element : arr){
            System.out.print(String.valueOf(element) + ' ');
        }
        System.out.println("");
    }


    //////////////////////////////////////////
    // Exercise 2: Expression balancing check
    //////////////////////////////////////////
    public static boolean expressionBalancingCheck(String exp) {
        if (exp == null || exp.isEmpty()) return false;
        SingleArrayStack stack = new SingleArrayStack(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else if (character == ')' || character == '}' || character == ']') {
                if(stack.isEmpty()) return false;
                if((character == ')' && stack.top() == '(')
                        || (character == '}' && stack.top() == '{')
                        || (character == ']' && stack.top() == '[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    ////////////////////////////////
    // Exercise 3: Reverse the stack
    ////////////////////////////////
    public static Stack reverseStack(Stack stack){
        Stack temp = new Stack();
        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("||||||||||||||| First question ||||||||||||");
        char[] array = {'A', 'D', '3', '9', '0'};
        printArray(array);
        int d =11;
        System.out.println("is rotated by " + d + " to ");
        rotate(array, d, array.length);
        printArray(array);

        System.out.println("||||||||||||||| Second question ||||||||||||");
        String[] exps = {"()", "[}]", "{2+4(7)}", "[(5){9]}"};

        for(String exp : exps){
            if(expressionBalancingCheck(exp)){
                System.out.println(exp + " is correct expression");
            }else {
                System.out.println(exp + " is not correct expression");
            }
        }

        System.out.println("||||||||||||||| Third question ||||||||||||");
        Stack original = new Stack();
        original.push("5");
        original.push("6");
        original.push("P");
        original.push("*");

        System.out.println(original.toString());
        System.out.println(reverseStack(original));
    }
}
