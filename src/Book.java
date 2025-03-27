import java.time.LocalDate;

public class Book {

    public String bookId;
    public String title;
    public String author;
    public boolean isIssued;

    public String reservedBy;
    public LocalDate issuedDate = null;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        reservedBy = null;
        issuedDate = null;
    }

    public void issueBook(){
        this.isIssued = true;
        this.issuedDate = LocalDate.now();
    }

    public void returnBook(){
        this.isIssued = false;
        this.issuedDate = null;
        this.reservedBy = null;
    }

    public void reserveBook(String memberId){
        reservedBy = memberId;
    }

    public boolean isReserved(){
        if (reservedBy == null) return false;
        else return true;
    }

    public String getBookDetails(){
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Status: " + (isIssued ? "Issued" : "Available") + ", Reserved By: " + (reservedBy != null ? reservedBy : "none");
    }
}
