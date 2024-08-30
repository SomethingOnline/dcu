
public class R23N1 {
    private int volume;
    private String title;
    private String author;
    private boolean proofRead;


	public R23N1(){
		this.title = "Untitled Article";
		this.author = "Anonymous";
		this.volume = 0;
		this.proofRead = false;
	}
	public R23N1(String title, String author){
		this();
		this.title = title;
		this.author = author;
	}
    // Getters
    public int getVolume() {
        return volume;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isProofRead() {
        return proofRead;
    }

    // Setters
    public void setVolume(int volume) {
        if(volume < 0){
			;
		} else{
			this.volume = volume;
		}
    }

    public void setTitle(String title) {
        if(title.length() < 3 || title.length() > 25){
			;
		} else{
			this.title = title;
		}
    }

    public void setAuthor(String author) {
        if(author.length() < 2){
			;
		} else{
			this.author = author;
		}
    }

    public void setProofRead(boolean proofRead) {
        this.proofRead = proofRead;
    }

	public boolean checkProof(){
		return this.volume > 0 && !this.title.equals("Untitled Article") && !this.author.equals("Anonymous") && this.proofRead;
	}

	public String toString(){
		return this.title + "(" + this.author + ") in Vol." + this.volume;
	}
}
