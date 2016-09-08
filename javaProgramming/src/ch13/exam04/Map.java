package ch13.exam04;

public interface Map <K,V>{
	void add(K k,V v);//제네릭 메소드
	V get(K k);
}