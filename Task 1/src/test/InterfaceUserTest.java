import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InterfaceUserTest {

  @Test
  public void InterfaceUserConstructorTest() {
    String string = "12.12.2021";
    GenericImplementation<String> genericImplementation = new GenericImplementation<>(string);
    InterfaceUser interfaceUser = new InterfaceUser(genericImplementation);

    assertNotNull(interfaceUser);
    assertNotNull(interfaceUser.inUse);
    assertTrue(interfaceUser.inUse instanceof SomeInterface);

    SomeInterface<String> stringSomeInterface = new GenericImplementation<>(string);
    interfaceUser = new InterfaceUser(stringSomeInterface);

    assertNotNull(stringSomeInterface);
    assertNotNull(interfaceUser.inUse);
    assertTrue(interfaceUser.inUse instanceof SomeInterface);

  }
}