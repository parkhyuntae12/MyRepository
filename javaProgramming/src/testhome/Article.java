package testhome;

public class Article {
		// Field
		int no;
		String title;
		String writer;
		int hit;
		String content;
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		// Constructor
		Article() {}
		Article(int no, String title, String writer, int hit, String content) {
			this.no = no;
			this.title = title;
			this.writer = writer;
			this.hit = hit;
			this.content = content;
		}
		
		// Method

	}
	
