
public class Q1a{
    String title;
    int fieldnum;
    int fieldmarks;


    public Q1a(String title, int fieldnum, int fieldmarks){
        this.title = title;
        this.fieldmarks = fieldmarks;
        this.fieldnum = fieldnum;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getFieldNum(){
        return fieldnum;
    }
    public void setFieldNum(int fieldnum){
        this.fieldnum = fieldnum;
    }

    public int setFieldMarks(){
        return fieldmarks;
    }
    public void getFieldMarks(int fieldmarks){
        this.fieldmarks = fieldmarks;
    }
    public String toString(){
        System.out.println(fieldnum + " " + title + " (" + fieldmarks + ");");
    }
}


class Q1b{
    private String title;
    private int fieldnum;
    private int fieldmarks;

    public Q1b(){
        this.title = "untitled";
        this.fieldnum = 0;
        this.fieldmarks = 0;
    }
    public Q1b(String title, int fieldnum, int fieldmarks){
        this.title = title;
        this.fieldmarks = fieldmarks;
        this.fieldnum = fieldnum;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getFieldNum(){
        return fieldnum;
    }
    public void setFieldNum(int fieldnum){
        if (fieldnum < 0){
            this.fieldnum = 0;
        }
        this.fieldnum = fieldnum;
    }

    public int getFieldMarks(){
        return fieldmarks;
    }
    public void setFieldMarks(int fieldmarks){
        if (fieldmarks < 0){
            this.fieldmarks = 0;
        }
        this.fieldmarks = fieldmarks;
    }
    public String toString(){
        System.out.println(fieldnum + " " + title + " (" + fieldmarks + ");");
    }
}

class Q1c{
    private String title;
    private int fieldnum;
    private int fieldmarks;
    private static int MQUESTION_COUNT = 0;

    public Q1c(){
        this.title = "untitled";
        this.fieldnum = 0;
        this.fieldmarks = 0;
        MQUESTION_COUNT++;
    }
    public Q1c(String title, int fieldmarks, int MQUESTION_COUNT){
        this.title = title;
        this.fieldmarks = fieldmarks;
        this.fieldnum = MQUESTION_COUNT;
        MQUESTION_COUNT++;
    }

    public Q1c(String title, int fieldnum, int fieldmarks){
        this.title = title;
        this.fieldmarks = fieldmarks;
        this.fieldnum = fieldnum;
        MQUESTION_COUNT++;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getFieldNum(){
        return fieldnum;
    }
    public void setFieldNum(int fieldnum){
        if (fieldnum < 0){
            this.fieldnum = 0;
        }
        this.fieldnum = fieldnum;
    }

    public int getFieldMarks(){
        return fieldmarks;
    }
    public void setFieldMarks(int fieldmarks){
        if (fieldmarks < 0){
            this.fieldmarks = 0;
        }
        this.fieldmarks = fieldmarks;
    }
    public String toString(){
        System.out.println(fieldnum + " " + title + " (" + fieldmarks + ");");
    }
}