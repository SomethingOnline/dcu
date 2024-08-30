import java.util.*;
class Book{
	String title;
	String author;
	int numCopies;
	int year;


	public String getTitle(){
		return title;
	}
}

class BookStore{

	List<Book> bookList;
	List<Collection> collections;
	Map<String, Integer> getCollectionSummary(){
		Map<String, Integer> summary = new HashMap<>();
		for (Collections collection : this.collections){
			summary.put(collection.name, colleciton.books.size());
		}
	}

	public void assignCollection(Book b, Collection c){
		if(!c.books.contains(b)){
			c.add(b);

		}
	}

	public void removeCollection(Book b, Collection c){
		if (c.books.contains(b)){
			c.remove(b);
		}
	}

	public int checkBook(String title, String author, int year) throws BookNotFound{
		for (Book book : bookList){
			if (book.title.equals(title) && book.author.equals(author) && book.year == year){
				return book.numCopies;
			} else{
				return 0;
			}
		}
	}

	Map<String,List<Book>> shelvingAssignment() {
		Map<String,List<Book>> shelves = new Map<>(); // if using custom object, replace this
			// if there was no requirement to suffix the label with an index
			// we could also have done a Map<String,List<List<Books>>>
			// i.e. list of list of books and let the calling code
			// do the suffixing on the key/string when it is iterating
		for (Collection collection: this.collections) {
			int shelfLabelCounter = 1; // suffix for shelf
			List<Book> shelfBooks = new ArrayList<>(); // list of books in the shelf
			// iterate through the list of books
			for(Book book: collection.books) {
				shelfBooks.add(book);
				if (shelfBooks.size() == 5) { // shelf is at max capacity
					// for every 5th book, the 'shelf' is completely full
					// so add it to the return Map
					shelves.put(collection.name + shelfLabelCounter, shelfBooks);
					shelfLabelCounter +=1 ; // increment the suffix
					shelfBooks = new ArrayList<>(); // reset the list of books on shelf
				}
			}
			if (shelfBooks.size() > 0) {
				// there are books on the last shelf created
				shelves.put(collection.name + shelfLabelCounter, shelfBooks);
				// to avoid adding a suffix when there is only 1 shelf
				// e.g. for 3 books in a collection, check the shelfLabelCounter
				// if still 1 - don't add it as a suffix in this case
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

	List<Book> getBooks(List<Book> bookList){
		List<Book> sortedBooks = new LinkedList<>(bookList);
		Collections.sort(sortedBooks, new Comparator<Book>(){
			public int compare(Book b1, Book b2){
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});

	}

}


// book not present in the store inventory
class BookNotFound extends Exception{
	BookNotFound(){
		super();
	}
	BookNotFound(String message){
		super(message);
	}
}

// Book not assigned to any collection 
class UnsortedBook extends Exception{
	UnsortedBook(){
		super();
	}
	UnsortedBook(String message){
		super(message);
	}
}

interface StoreTemplate {
    Map<String, Integer> getCollectionSummary();
    void assignCollection(Book book, Collection collection);
    void removeCollection(Book book, Collection collection);
    int checkBook(String title, String author, int yearPublication);
    Map<String,List<Book>> shelvingAssignment();

    // getters and setters
    List<Book> getInventory();
    void addBook(Book book);
    void addBook(Book book, int copies);
    void removeBook(Book book);
    List<Collection> getCollections();
    void addCollection(String name);
    void removeCollection(String name);
}


class BookException extends Exception { // parent class of our custom exceptions
    Book book;
    BookException(Book book) {
        this.book = book;
    }
}
class BookNotFound extends BookException {
    BookNotFound(Book book) {
        super(book);
    }
}
class UnsortedBook extends BookException {
    UnsortedBook(Book book) {
        super(book);
    }
}

// Note that this method is to be declared inside BookStore
// The sample solution is focusing only on the implementation
// This applise to all methods in the sample solution
// - they sould be in their appropriate classes
List<BookException> validateInventory() {
    List<BookException> issues = new ArrayList<>();
    // for books with no copies
    for(Book book: this.books) {
        if (book.copies == 0) { // assuming the setter keep 0 as minimum
            issues.add(new BookNotFound(book));
        }
        // for books not in any collections
        // in this case, if there are 0 copies, and you don't want to -
        // check for it being unsorted - use appropriate if-else or flag
        boolean found = false;
        for (Collection collection: collections) {
            if (collection.contains(book)) {
                found = true;
                break;
            }
        }
        if (!found) {
            issues.add(new UnsortedBook(book));
        }
    }
}