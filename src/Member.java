import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Member {
    public String name;
    public String memberId;
    public LinkedList<Book> books;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.books = new LinkedList<>();
    }

    public void issueBook(Book book) {
        if (canIssueBook()) {
            books.add(book);
            book.issueBook();
            System.out.println("Book " + book.bookId + " issued to member " + memberId + ".");
        }
        else System.out.println("Error when issuing Book: Member with name " + name + " already has a maximum of " + books.size() + " books");
    }

    public void returnBook(Book book){
        books.remove(book);
        book.returnBook();
    }

    public boolean canIssueBook(){
        if(books.size()< 3) return true;
        else return false;
    }

    public int calculateFine (LocalDate issuedDate) {
        int daysBetween = (int) ChronoUnit.DAYS.between(issuedDate, LocalDate.now());
        if (daysBetween > 10){
            return daysBetween-10;
        }
        return 0;
    }

    public String getMemberDetails() {
        return "Member ID: " + memberId + ", Name: " + name + ", Books issued: " + books.size();

    }
}

