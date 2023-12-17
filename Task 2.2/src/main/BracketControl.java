import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class BracketControl {

  private static final char[] openBrackets = {'[', '{', '('};
  private static final char[] closeBrackets = {']', '}', ')'};

  public static int CheckBrackets(String inputStr){
    Stack<Character> bracketsStack = new Stack<>();

    List<Character> charsInputString = inputStr.chars()
            .mapToObj(e->(char)e)
            .toList();

    int indexClose;
    int i = 0;
    for (Character ch: charsInputString) {
      if(ch.equals(openBrackets[0]) || ch.equals(openBrackets[1]) || ch.equals(openBrackets[2])){
        bracketsStack.push(ch);
      }
      if(ch.equals(closeBrackets[0]) || ch.equals(closeBrackets[1]) || ch.equals(closeBrackets[2])){
        indexClose = indexOf(closeBrackets, ch);
        if(bracketsStack.size() > 0 && indexClose == indexOf(openBrackets, bracketsStack.peek())){
          bracketsStack.pop();
        } else {
          return i;
        }
      }
      i++;
    }
    if(bracketsStack.size() != 0){
      return inputStr.length();
    }

    return -1;
  }

  private static int indexOf(char[] arr, char val) {
    return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
  }

}
