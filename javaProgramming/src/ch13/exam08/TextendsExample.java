package ch13.exam08;

public class TextendsExample {
	public void method1(C1<String>arg){}
	public void method2(C1<? extends Number>arg){}
	public C1<? extends Number> method3(){return null;}
	//public C1<T extends Number> method4(){return null;}(X)
}


class C1<T>{}
class C2<T extends Number>{}
class C3{
	public <T> void method(T t){} //�̰͵� T�� ���� �����Ѱ�
	public <T extends Number> void method(T t){}
	//public <? extends Number> void method(T t){}(X)
}

