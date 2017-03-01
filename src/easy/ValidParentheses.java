package easy;

import java.util.Stack;

/**
 * Created by novas on 2016/10/26.
 */
public class ValidParentheses {
    public static void main(String[] args)
    {
        String str="()[]{}";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] array=s.toCharArray();
        for (int i=0;i<array.length;i++)
        {
            if(stack.empty())
            {
                stack.push(array[i]);
            }
            else
            {
                Character character=stack.peek();
                if((array[i]==')'&&character=='(')||(array[i]==']'&&character=='[')||(array[i]=='}'&&character=='{'))
                {
                    stack.pop();
                }
                else
                {
                    stack.push(array[i]);
                }
            }
        }
        return stack.isEmpty();
    }
}
