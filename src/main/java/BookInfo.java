public class BookInfo extends Exception {

    public int bookID;
    public String bookName;

    public BookInfo(int bookID,String bookName){
        this.bookID = bookID;
        this.bookName = bookName;
    }
    public BookInfo(String message){
        super(message);
    }

    public void Book_Info(){
        System.out.println(bookID +"    ,   "+ bookName);
    }

}
