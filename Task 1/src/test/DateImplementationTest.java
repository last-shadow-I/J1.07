import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateImplementationTest {

  @Test
  public void DateImplementationConstructorTest(){
    LocalDate localDate = LocalDate.now();
    DateImplementation dateImplementation = new DateImplementation(localDate);
    DateImplementation dateImplementation1 = new DateImplementation(localDate);
    assertFalse(dateImplementation.equals(dateImplementation1));
    assertTrue(dateImplementation.equals(dateImplementation));
  }

}