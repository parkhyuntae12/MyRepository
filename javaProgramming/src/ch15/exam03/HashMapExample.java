package ch15.exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map �迭 �÷��� ����
		Map <String,Integer>map = new HashMap<String,Integer>();
		
		//��Ʈ�� �߰�
		map.put("ȫ�浿",85);//85 Integer�� AutoBoxing
		map.put("�߰���",90);
		map.put("ȫ�浿", 95);//�����
		map.put("���ڹ�",81);
		System.out.println(map.size());
		
		//��ü(��) ���
		int score = map.get("ȫ�浿");
		System.out.println(score);
		
		//��� ��Ʈ�� �ϰ�ó��
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer>  entry  : set){
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key +":"+value);
		}
		System.out.println();
		
		Set<String> set2 = map.keySet();
		for(String key : set2){
			int value = map.get(key);
			System.out.println(key + ":"+value);
		}
		System.out.println();
		
		//��ü ����
		map.remove("ȫ�浿");//��Ʈ����ü�� ������
		Set<String> set3 = map.keySet();
		for(String key : set3){
			int value = map.get(key);
			System.out.println(key + ":"+value);
		}
	}
}