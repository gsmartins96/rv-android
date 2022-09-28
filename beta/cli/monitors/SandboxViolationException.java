package mop;

public class SandboxViolationException extends RuntimeException{
  public SandboxViolationException(String mn){
    super("Invalid call to method: " + mn);
  }
}