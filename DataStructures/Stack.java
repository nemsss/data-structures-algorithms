package DataStructures;

public class Stack {

    private char[] data;
    private int top = -1;

    Stack(int size){
        this.data = new char[size];
    }

    private char peek(){
        return data[top];
    }

    public int size(){
        return top+1;
    }

    private void push(char c){
        data[++top] = c;
    }

    private char pop(){
        return data[top--];
    }

    public boolean balanced(char[] chars){
        for(char c : chars){
            if(isOpening(c)){
                push(c);
            } else {
                if(top == -1 || !corresponds(c)){
                    return false;
                }
                pop();
            }
        }
        return top == -1;
    }

    private boolean corresponds(char c) {
        switch (c){
            case ')':
                return peek() == '(';
            case ']':
                return peek() == '[';
            case '}':
                return peek() == '{';
            default:
                return false;
        }
    }

    private boolean isOpening(char c){
        return c=='(' || c=='{' || c=='[';
    }

    private char evaluatePostFix(char[] chars){
        for(char c : chars){
            if(Character.isDigit(c)){
                push(c);
            } else {
                char c1 = pop();
                char c2 = pop();
                char op = doOperation(c, c1, c2);
                push(op);
            }
        }

        return peek();
    }

    private char evaluateInFix(char[] chars){
        for(int i=chars.length-1; i>=0; i--){
            char c = chars[i];
            if(Character.isDigit(c)){
                push(c);
            } else {
                char c2 = pop();
                char c1 = pop();
                push(doOperation(c, c1, c2));
            }
        }

        return peek();
    }

    private char doOperation(char c, Character c1, Character c2) {
        switch (c){
            case '*':
                return Character.forDigit(charToInt(c1) * charToInt(c2), 10);
            case '+':
                return Character.forDigit(charToInt(c1) + charToInt(c2), 10);
            case '-':
                return Character.forDigit(charToInt(c1) - charToInt(c2), 10);
            default:
                return 0;
        }
    }

    private int charToInt(Character c){
        return c - '0';
    }

    private String infixToPostPix(char[] inFix){
        StringBuilder sb = new StringBuilder(inFix.length);
        for(char c : inFix){
            if(Character.isDigit(c)){
                sb.append(c);
            } else if(c== '*' || c== '/'){
                if(size() >0 && (peek()== '*' || peek()== '/')){
                    sb.append(pop());
                }
                push(c);
            } else {
                while (size() >0 ){
                    sb.append(pop());
                }
                push(c);
            }
        }
        while (size() >0 ){
            sb.append(pop());
        }
        return sb.toString();
    }

    public static void main(String [] args){
        Stack stack = new Stack(10);
//        System.out.println(stack.balanced(new char[]{'[', ']', '(', '{', ')', '}'}));
//        stack.popAll();
        char res = stack.evaluatePostFix(new char []{'2', '3', '*', '1', '2', '*', '+'});
        System.out.println(res);

        System.out.println(new Stack(15).balanced("{(([])[])[]}[]".toCharArray()));
//        stack.pop();
//
//        res = stack.evaluateInFix(new char []{'-', '+', '*', '1', '4', '*', '2', '2', '9'});
//        System.out.println(res);

//        Stack s2 = new Stack(10);
//        String postFix = s2.infixToPostPix("2*3*4*1-3".toCharArray());
//        System.out.println(postFix);
    }

}
