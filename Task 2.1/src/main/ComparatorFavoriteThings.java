import java.util.*;

public class ComparatorFavoriteThings {

  private HashMap<String, List<String>> usersFavoriteThings;

  private ComparatorFavoriteThings(HashMap<String, List<String>> usersFavoriteThings) {
    this.usersFavoriteThings = usersFavoriteThings;
  }

  public static boolean isUsersFavoriteThings(String str){
    return str.matches("([а-я]+:((\\s+[а-я]+)*,)*(\\s+[а-я]+)+)");
  }

  public static ComparatorFavoriteThings getFavoriteThings(ArrayList<String> usersFavoriteThings){
    HashMap<String, List<String>> favoriteThings = new HashMap<>();
    List<String> stringList;
    for (String str: usersFavoriteThings){
      String[] userFavoriteThings = str.toLowerCase().split(":");
      stringList = Arrays.stream(userFavoriteThings[1].split(","))
              .map(String::trim)
              .sorted(String::compareTo)
              .toList();
      favoriteThings.put(userFavoriteThings[0], stringList);
    }

    return new ComparatorFavoriteThings(favoriteThings);
  }

  public String[] everyoneFavoriteThings(){
    Set<String> set = null;
    for (var v : usersFavoriteThings.values()) {
      Set<String> stringSet = new HashSet<>(v);
      if (set == null){
        set = stringSet;
      } else {
        set.retainAll(stringSet);
      }
    }
    return set.stream()
            .sorted(String::compareTo)
            .toArray(String[]::new);
  }

  public String[] allFavoriteThings(){
    Set<String> set = null;
    for (var v : usersFavoriteThings.values()) {
      Set<String> stringSet = new HashSet<>(v);
      if (set == null){
        set = stringSet;
      } else {
        set.addAll(stringSet);
      }
    }
    return set.stream()
            .sorted(String::compareTo)
            .toArray(String[]::new);
  }

  public HashMap<String,List<String>> uniqueFavoriteThings(){
    HashMap<String,List<String>> output = new HashMap<>();
    for (var i : usersFavoriteThings.entrySet()){
      Set<String> set = new HashSet<>(i.getValue());
      for (var j : usersFavoriteThings.entrySet()) {
        if(!i.getKey().equals(j.getKey())){
          Set<String> stringSet = new HashSet<>(j.getValue());
          set.removeAll(stringSet);
        }
      }
      output.put(i.getKey(), set.stream().sorted(String::compareTo).toList());
    }
    return output;
  }

  public String[] numberFavoriteThings(){
    HashMap<String, Integer> output = new HashMap<>();
    Integer number;
    for (var v : usersFavoriteThings.values()) {
      Set<String> stringSet = new HashSet<>(v);
      for (String value: stringSet){
        number = output.getOrDefault(value, 0);
        output.put(value, number + 1);
      }
    }
    return output.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(val -> val.getKey() + " = " + val.getValue())
            .toArray(String[]::new);
  }

  public HashMap<String, List<String>> getUsersFavoriteThings() {
    return usersFavoriteThings;
  }

  public void setUsersFavoriteThings(HashMap<String, List<String>> usersFavoriteThings) {
    this.usersFavoriteThings = usersFavoriteThings;
  }
}
