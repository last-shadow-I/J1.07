import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorFavoriteThingsTest {
  String trueString = "степан: программирование";
  String trueString1 = "степан: программирование, зеленый чай, осень, иней, гулять";
  String trueString2 = "оля: программирование, осень, чай";
  String trueString3 = "лиза: коты, осень, иней, программирование";

  String falseString = "степан:   ";
  String falseString1 = "оля: программирование, осень, чай,";
  String falseString2 = "степан: программирование,";

  @Test
  void isUsersFavoriteThingsTest() {
    assertTrue(ComparatorFavoriteThings.isUsersFavoriteThings(trueString));
    assertTrue(ComparatorFavoriteThings.isUsersFavoriteThings(trueString1));
    assertTrue(ComparatorFavoriteThings.isUsersFavoriteThings(trueString2));
    assertTrue(ComparatorFavoriteThings.isUsersFavoriteThings(trueString3));

    assertFalse(ComparatorFavoriteThings.isUsersFavoriteThings(falseString));
    assertFalse(ComparatorFavoriteThings.isUsersFavoriteThings(falseString1));
    assertFalse(ComparatorFavoriteThings.isUsersFavoriteThings(falseString2));
  }

  @Test
  void getFavoriteThings() {
    ArrayList<String> stringArrayList = new ArrayList<>();

    ComparatorFavoriteThings comparatorFavoriteThings;
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);

    assertEquals(0, comparatorFavoriteThings.getUsersFavoriteThings().entrySet().size());

    stringArrayList.add(trueString);
    stringArrayList.add(trueString1);
    stringArrayList.add(trueString2);
    stringArrayList.add(trueString3);

    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);

    assertEquals(3, comparatorFavoriteThings.getUsersFavoriteThings().entrySet().size());

    Set<String> names = new HashSet<>(List.of(new String[]{"степан", "оля", "лиза"}));
    assertEquals(names, comparatorFavoriteThings.getUsersFavoriteThings().keySet());
  }

  @Test
  void everyoneFavoriteThings() {

    String string = "степан: программирование";
    String string1 = "оля: осень";

    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add(string);
    stringArrayList.add(string1);

    ComparatorFavoriteThings comparatorFavoriteThings;

    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(0, comparatorFavoriteThings.everyoneFavoriteThings().length);

    stringArrayList = new ArrayList<>();
    String string2 = "степан: программирование";
    String string3 = "оля: программирование";
    stringArrayList.add(string2);
    stringArrayList.add(string3);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(1, comparatorFavoriteThings.everyoneFavoriteThings().length);

    stringArrayList = new ArrayList<>();
    String string4 = "степан: программирование, осень, чай";
    String string5 = "оля: программирование, осень";
    stringArrayList.add(string4);
    stringArrayList.add(string5);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(2, comparatorFavoriteThings.everyoneFavoriteThings().length);

    assertArrayEquals(new String[] {"осень", "программирование"}, comparatorFavoriteThings.everyoneFavoriteThings());
  }

  @Test
  void allFavoriteThings() {
    String string = "степан: программирование";
    String string1 = "оля: осень";

    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add(string);
    stringArrayList.add(string1);

    ComparatorFavoriteThings comparatorFavoriteThings;

    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(2, comparatorFavoriteThings.allFavoriteThings().length);

    stringArrayList = new ArrayList<>();
    String string2 = "степан: программирование";
    String string3 = "оля: программирование";
    stringArrayList.add(string2);
    stringArrayList.add(string3);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(1, comparatorFavoriteThings.allFavoriteThings().length);

    stringArrayList = new ArrayList<>();
    String string4 = "степан: программирование, осень, чай";
    String string5 = "оля: программирование, осень";
    stringArrayList.add(string4);
    stringArrayList.add(string5);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(3, comparatorFavoriteThings.allFavoriteThings().length);

    assertArrayEquals(new String[] {"осень", "программирование", "чай"}, comparatorFavoriteThings.allFavoriteThings());
  }

  @Test
  void uniqueFavoriteThings() {
    String string = "степан: программирование";
    String string1 = "оля: осень";

    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add(string);
    stringArrayList.add(string1);

    ComparatorFavoriteThings comparatorFavoriteThings;

    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals(2, comparatorFavoriteThings.uniqueFavoriteThings().values().size());

    for (var v: comparatorFavoriteThings.uniqueFavoriteThings().entrySet()) {
      if (v.getKey().equals("степан")){
        assertEquals("[программирование]", v.getValue().toString());
      } else {
        assertEquals("[осень]", v.getValue().toString());
      }
    }

    stringArrayList = new ArrayList<>();
    String string2 = "степан: программирование";
    String string3 = "оля: программирование";
    stringArrayList.add(string2);
    stringArrayList.add(string3);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertEquals("[[], []]", comparatorFavoriteThings.uniqueFavoriteThings().values().toString());

    stringArrayList = new ArrayList<>();
    String string4 = "степан: программирование, осень, чай";
    String string5 = "оля: программирование, осень";
    stringArrayList.add(string4);
    stringArrayList.add(string5);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);

    assertEquals("[[], [чай]]", comparatorFavoriteThings.uniqueFavoriteThings().values().toString());
  }

  @Test
  void numberFavoriteThings() {
    String string = "степан: программирование";
    String string1 = "оля: осень";

    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add(string);
    stringArrayList.add(string1);

    ComparatorFavoriteThings comparatorFavoriteThings;

    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertArrayEquals(new String[]{"осень = 1", "программирование = 1"}, comparatorFavoriteThings.numberFavoriteThings());

    stringArrayList = new ArrayList<>();
    String string2 = "степан: программирование";
    String string3 = "оля: программирование";
    stringArrayList.add(string2);
    stringArrayList.add(string3);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);
    assertArrayEquals(new String[]{"программирование = 2"}, comparatorFavoriteThings.numberFavoriteThings());

    stringArrayList = new ArrayList<>();
    String string4 = "степан: программирование, осень, чай";
    String string5 = "оля: программирование, осень";
    stringArrayList.add(string4);
    stringArrayList.add(string5);
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);

    assertArrayEquals(new String[]{"осень = 2", "программирование = 2", "чай = 1"}, comparatorFavoriteThings.numberFavoriteThings());
  }
}