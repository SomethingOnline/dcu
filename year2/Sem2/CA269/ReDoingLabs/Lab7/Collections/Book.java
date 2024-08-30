


class BookByTitle implements Comparator<Book>{
	public int compare(Book book1, Book book2){
		return book1.title.compareTo(book2.title);
	}
}

class BookByYear implements Comparator<Book>{
	public int compare(Book b1, Book b2){
		return Integer.compare(b1.year, b2.year);
	}
}

public class Book implements Comparable<Book>{
	private int year;
	private String title;

	public int compareTo(Book book){
		if (Integer.compare(this.year, book.year) == 0){
			return this.title.compareTo(book.title);
		} else{
			return Integer.compare(this.year, book.year);
		}
	}
}