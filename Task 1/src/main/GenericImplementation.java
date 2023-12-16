public class GenericImplementation<T> implements SomeInterface<T> {

  protected T data;

  public GenericImplementation(T data) {
    this.data = data;
  }

  @Override
  public T getData() {
    return null;
  }

  @Override
  public boolean validate(T date) {
    return false;
  }
}
