package aop;

public class HelloWorldImpl2 implements HelloWorld {

	@Override
	public void printHelloWorld() {
		System.out.println("HelloWorldImpl2 printHelloWorld");

	}

	@Override
	public void doPrint() {
		System.out.println("HelloWorldImpl2 doPrint");

	}

}
