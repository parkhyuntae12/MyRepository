package ch13.exam03;

public class ProductExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product<String,String> p1 = new Product<>();
		p1.setKind("TV");
		p1.setModel("����Ʈ");
		String kind = p1.getKind();
		String model1 = p1.getModel(); 
		
		Product<Tv,String> p2 = new Product<>();
		
		p2.setKind(new Tv());
		p2.setModel("��ȭ��");
		Tv kind2 = p2.getKind();
		String model2 = p2.getModel();
	}
}