package longestVParantheses;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        SolutionValidP solutionValidP = new SolutionValidP();
        String s="((())";
        int i = solutionValidP.longestValidParentheses(s);
        System.out.println(i);
    }
}

class SolutionValidP {
    public int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()[0]==0){
                    stack.pop();
                    result = Math.max(result, i-(stack.isEmpty()?-1:stack.peek()[1]));
                }else{
                    stack.push(new int[]{1, i});
                }
            }else{
                stack.push(new int[]{0, i});
            }
        }

        return result;
    }

    public int longestValidParentheses2(String s) {
        Pattern pattern = Pattern.compile("\\(\\)");
        Matcher matcher = pattern.matcher(s);
        int count=0;
        while (matcher.find()) {
            count++;
        }
        return count;
        //if you want to get the number of single (
        // return count*2;
    }
}
