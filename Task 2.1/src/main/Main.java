import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    ArrayList<String> stringArrayList = new ArrayList<>();

    String str;
    while (true){
      if (!(str = sc.nextLine()).trim().equals("")){
        // Степан: программирование
        // степан: программирование,
        // степан: программирование, зеленый чай
        // степан: программирование, зеленый чай, осень, иней, гулять
        // Оля: программирование, осень, чай
        // Лиза: коты, осень, иней, программирование

        if(ComparatorFavoriteThings.isUsersFavoriteThings(str.toLowerCase())){
          System.out.println("Правильный вид любимок: " + str);
          stringArrayList.add(str);
        } else {
          // Степан:
          // Оля: программирование, осень, чай,
          System.out.println("Неправильный вид любимок: " + str);
        }
      } else {
        break;
      }
    }

    ComparatorFavoriteThings comparatorFavoriteThings;
    comparatorFavoriteThings = ComparatorFavoriteThings.getFavoriteThings(stringArrayList);

    System.out.println("\nВсеобщие \"любимки\": ");
    for (String s : comparatorFavoriteThings.everyoneFavoriteThings()) {
      System.out.print(s + ", ");
    }

    System.out.println("\n\nВсе \"любимки\": ");
    for (String s : comparatorFavoriteThings.allFavoriteThings()) {
      System.out.print(s + ", ");
    }

    System.out.println("\n\nУникальные \"любимки\": ");
    for (var user: comparatorFavoriteThings.uniqueFavoriteThings().entrySet()) {
      System.out.print(user.getKey() + ": ");
      for (String s : user.getValue()) {
        System.out.print(s + ", ");
      }
      System.out.println();
    }

    System.out.println("\n\nКол-во \"любимок\": ");
    for (String s : comparatorFavoriteThings.numberFavoriteThings()) {
      System.out.print(s + ", ");
    }
  }
}