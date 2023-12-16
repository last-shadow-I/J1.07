import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GenericImplementationTest {

  @Test
  public void GenericImplementationConstructorTest() {
    LocalDate localDate = LocalDate.now();
    GenericImplementation<LocalDate> genericImplementation = new GenericImplementation<>(localDate);
    GenericImplementation<LocalDate> genericImplementation1 = new GenericImplementation<>(localDate);
    assertFalse(genericImplementation.equals(genericImplementation1));
    assertTrue(genericImplementation.equals(genericImplementation));
  }

}