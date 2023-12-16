public class InterfaceUser {

  SomeInterface<String> inUse;

  public InterfaceUser(SomeInterface<String> inUse) {
    this.inUse = inUse;
  }

  SomeInterface<String> getUsed(){
    return null;
  }

  void useInterface(SomeInterface<String> i) {

  }
}
