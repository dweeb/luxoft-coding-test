package pl.luxoft.codingtest.rule;

public interface Rule<T> {

    boolean isValid(T t);
    String getErrorMessage();

}
