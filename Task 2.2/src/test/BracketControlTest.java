import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketControlTest {

  String str1 = "";
  String str2 = "()[]{}";
  String str3 = ")";
  String str4 = "[";
  String str5 = "{}}";
  String str6 = "[fkv}";
  String str7 = "(12 + A[0]) / ((b{0, 1} - c {6, n}) * 2)";
  String str8 = "(((((()[[]]){()})())[[[]]]){[][]})";
  String str9 = "{[(])}";
  String str10 = "{a[b(c)b}a";
  String string = "123)";
  String string1 = "((123)";

  @Test
  void checkBrackets() {
    assertEquals(-1, BracketControl.CheckBrackets(str1));
    assertEquals(-1, BracketControl.CheckBrackets(str2));
    assertEquals(0, BracketControl.CheckBrackets(str3));
    assertEquals(1, BracketControl.CheckBrackets(str4));
    assertEquals(2, BracketControl.CheckBrackets(str5));
    assertEquals(4, BracketControl.CheckBrackets(str6));
    assertEquals(-1, BracketControl.CheckBrackets(str7));
    assertEquals(-1, BracketControl.CheckBrackets(str8));
    assertEquals(3, BracketControl.CheckBrackets(str9));
    assertEquals(8, BracketControl.CheckBrackets(str10));
    assertEquals(3, BracketControl.CheckBrackets(string));
    assertEquals(6, BracketControl.CheckBrackets(string1));
  }
}