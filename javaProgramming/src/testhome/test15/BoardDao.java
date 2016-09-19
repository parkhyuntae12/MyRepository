package testhome.test15;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List<Board1> getBoardList(){
		List<Board1> list = new ArrayList<Board1>();
		list.add(new Board1("力格1", "郴侩1"));
		list.add(new Board1("力格2", "郴侩2"));
		list.add(new Board1("力格3", "郴侩3"));
		
		return list;
	}
}