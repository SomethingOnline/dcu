/**
 * Book.java - Assignment 01
 * @author Jack Egan 22404362
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

    BookRating(int rating) { 
        this.rating = rating; 
    }
    public int getValue(){
        return rating;
    }
}

public class Book {
    // fields are private
    private String title;
    private String author;
    private int publishedDate;
    private int readDate;
    private BookMedium readMedium;
    private BookGenre genre;
    private BookRating rating;

    /**
     * Default constructor takes title, author, and genre
     */
    public Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    /**
     * Additional constructor also takes published date
     */
    public Book(String title, String author, BookGenre genre, int publishedDate) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedDate = publishedDate;
    }

    /**
     * Additional constructor also takes published date,
     * read date, read medium, and rating
     */
    public Book(String title, String author, BookGenre genre, int publishedDate, int readDate, BookMedium readMedium, BookRating rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedDate = publishedDate;
        this.readDate = readDate;
        this.readMedium = readMedium;
        this.rating = rating;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public int getReadDate() {
        return readDate;
    }

    public BookMedium getMedium() {
        return readMedium;
    }

    public BookRating getRating() {
        return rating;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public void setPublishedDate(int publishedDate) {
        if (publishedDate > 0) {
            this.publishedDate = publishedDate;
        }
    }

    public void setReadDate(int readDate) {
        if (readDate > 0) {
            this.readDate = readDate;
        }
    }

    public void setMedium(BookMedium readMedium) {
        this.readMedium = readMedium;
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
    public String toString() {
        StringBuilder result = new StringBuilder(title + " by " + author);

        if (publishedDate != 0) {
            result.append(" (" + publishedDate + ")");
        }
        if (readDate != 0 && readMedium != null && rating != null) {
            result.append(" - read in " + readDate + ", rated " + rating.getValue() + "/5");
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
