
public class R23N1{
    private int volume;
    private String title;
    private String author;
    private boolean proofread;


    R23N1(){
        this.title = "Untitled Article";
        this.author = "Anonymous";
        this.volume = 0;
        this.proofread = false;
    }
    R23N1(String title, String author){
        this();
        this.title = title;
        this.author = author;
    }
    public int getVolume(){
        return this.volume;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public boolean getProofRead(){
        return this.proofread;
    }

    // setters
    public void setVolume(int volume){
        if (volume > 0){
            this.volume = volume;
        }
    }
    public void setTitle(String title){
        if (title.length() > 3 && title.length < 25){
            this.title = title;
        }
    }
    public void setAuthor(String author){
        if (author.length() < 2){
            this.author = author;
        }
    }
    public void setProofRead(boolean proofread){
        this.proofread = proofread;
    }
    
    public void checkProof() {
        if (title.equals("Untitled")) {
            proofread = false;
            return;
        }
        if (author.equals("Anonymous")) {
            proofread = false;
            return;
        }
        if (volume == 0) {
            proofread = false;
            return;
        }
        proofread = true;
    }

    @Override
    public String toString(){
        return this.title + " (" + this.author + ") in Vol." + this.volume;
    }
}