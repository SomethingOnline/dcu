
// class represents news articles or items
// string title
// string published for date
// int field called num to represent the number of news items
// boolean field approved

// write getters and setters
// constructor - with default values
// constructor that takes only title, rest as default

// Q1 DONE
public class E23NI{
    private String title;
    private String published;
    private int number;
    private boolean approvedForPublication;

    public E23NI(){
        this.title = "Untitled";
        this.published = "Not set";
        this.number = 0;
        this.approvedForPublication = false;
    }

    public E23NI(String title){
        this.title = title;
        this.published = "Not set";
        this.number = 0;
        this.approvedForPublication = false;
    }

    // getters
    public String getTitle(){
        return this.title;
    }
    public String getPublished(){
        return this.published;
    }
    public int getNumber(){
        return this.number;
    }
    public boolean getApprovedForPublication(){
        return this.approvedForPublication;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setPublished(String published){
        if (published.length() >= 6 && published.length() <= 10){
            for(int i = 0; i < published.length(); i++){
                int dashcount = 0;
                if (published.charAt(i) == '-'){
                    dashcount++;;
                }
                if (dashcount == 2){
                    this.published = published;
                }
            }
        }
    }
    public void setPublished(int day, int month, int year){
        String formattedDate = String.format("%02d-%02d-%04d", day, month, year);
        this.published = formattedDate;
    }
    public void setNumber(int number){
        if (number > 0){
            this.number = number;
        }
    }
    public void setApprovedForPublication(boolean approvedForPublication){
        this.approvedForPublication = approvedForPublication;
    }

    public boolean isCameraReady(){
        if(this.title != "Untitled" && this.published != "Not set" && this.number != 0 && this.approvedForPublication == true){
            return true;
        }
        return false;
    }

    // toString method
    @Override
    public String toString() {
        return "Title: " + this.title + ", Published: " + this.published + ", Number: " + this.number + ", Approved for Publication: " + this.approvedForPublication;
    }

}