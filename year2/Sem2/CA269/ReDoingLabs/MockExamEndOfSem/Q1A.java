import java.util.*;
class Book{
	String title;
	String author;
	int year;
	int copies;

	public String getTitle(){
		return title;
	}
}

class BookStore{

	List<Book> inventory;
	List<Collection> collections;

	Map<String, Integer> getCollectionSummary(){
		Map<String, Integer> summary = new HashMap<>();
		for (Collection collection : collections){
			summary.put(collection.name, collection.books.size());
		}
	}

	public void assignCollection(Book book, Collection collection){
		if(!collections.books.contains(book)){
			collections.add(book);
		}
	}

	public void removeCollection(Book book, Collection collection){
		if(collection.books.contains(book)){
			colleciton.remove(book);
		}
	}



	public int checkBook(String title, String author, int year){
		for (Book book : inventory){
			if (book.title.equals(title) && book.author.equals(author) && book.year == year){
				return book.copies;
			} else{
				return 0;
			}
		}
		
	}

}

class Collection{
	String name;
	List<Book> books;
	Collection(){
		this.books = new ArrayList<>();
	}

	List<Book> getBooks(){
		List<Book> sortedBooks = new LinkedList(this.books);
		Collections.sort(sortedBooks, new Comparator<Book>(){
			@Override
			public int compare(Book b1, Book b2){
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		return sortedBooks;
	}
}

