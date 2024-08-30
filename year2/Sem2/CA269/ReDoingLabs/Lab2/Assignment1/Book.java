/**
 * Book.java - Assignment 01
 * @author Harshvardhan Pandit
 */

enum BookMedium {
	PhysicalBook, EBook, AudioBook
}

enum BookGenre {
	Fiction, NonFiction
}

enum BookRating {
	Rating1(1), Rating2(2), Rating3(3), Rating4(4), Rating5(5);
	private final int rating;
	BookRating(int rating){
		this.rating = rating;
	}
	public int getRating(){
		return rating;
	}

}

class Book {
    // fields are private
	private String title;
	private String author;
	private int publishedDate;
	private int readDate;
	private BookGenre genre;
	private BookMedium medium;
	private BookRating rating;
	public Book(String title, String author, BookGenre genre){
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

    /**
     * Additional constructor also takes published date
     */
		public Book(String title, String author, BookGenre genre, int publishedDate){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publishedDate = publishedDate;
	}

    /**
     * Additional constructor also takes published date,
     * read date, read medium, and rating
     */
	public Book(String title, String author, BookGenre genre, int publishedDate, int readDate, BookMedium medium, BookRating rating){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publishedDate = publishedDate;
		this.readDate = readDate;
		this.medium = medium;
		this.rating = rating;
	}

    // getters
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public BookGenre getGenre(){
		return genre;
	}
	public void setTitle(BookGenre genre){
		this.genre = genre;
	}
	public int getPublishedDate(){
		return publishedDate;
	}
	public void setPublishedDate(int publishedDate){
		this.publishedDate = publishedDate;
	}
	public int getReadDate(){
		return readDate;
	}
	public void setReadDate(int readDate){
		this.readDate = readDate;
	}
	public BookMedium getMedium(){
		return medium;
	}
	public void setMedium(BookMedium medium){
		this.medium = medium;
	}
	public BookRating getRating(){
		return rating;
	}
	public void setRating(BookRating rating){
		this.rating = rating;
	}

    /**
     * toString implementation
     * Depends on available information
     * For title, an author, and a genre - Title by Author
     * If publication date is present - Title by Author (Year of Publication)
     * If read date, read medium, and rating is present -
     * Title by Author (Year of Publication) - read in Year of Reading, rated rating/5
     */
	public String toString(){
		StringBuilder result = new StringBuilder(this.title + "by " + this.author);
		if (publishedDate != 0){
			result.append("(" + this.publishedDate + ")");
		}
		if (readDate != 0 && medium != null && rating != null){
			result.append(" - read in " + this.readDate + ", rated " + this.rating.getRating() + "/5");
		}

		return result.toString();

	}

    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville",
                BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}
