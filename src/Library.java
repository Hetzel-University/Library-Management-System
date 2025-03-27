import java.time.LocalDate;
import java.util.LinkedList;

public class Library {

    public LinkedList<Book> books;
    public LinkedList<Member> members;

    public Library() {
        this.books = new LinkedList<>();
        this.members = new LinkedList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void issueBook(String memberId, String bookId) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);
        if (book == null || member == null) {
            System.out.println("Error when issuing Book: Book or Member not found.");
            return;
        }
        if(book.isIssued) {
            System.out.println("Error when issuing Book: Book is already issued.");
            return;
        }

        member.issueBook(book);
    }

    public void returnBook(String memberId, String bookId, LocalDate issuedDate) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);
        if (book == null || member == null) {
            System.out.println("Error when returning Book: Buch oder Member nicht gefunden");
            return;
        }
        if (!member.books.contains(book)) {
            System.out.println("Error when returning Book: Book " + bookId + " is not issued to member " + member.memberId + ".");
            return;
        }

        int fine = member.calculateFine(issuedDate);
        member.returnBook(book);

        if (fine>0) {
            System.out.println("Book " + bookId + " got returned late! Fine is " + fine + "€.");
        } else {
            System.out.println("Book " + bookId + " got returned!");
        }
    }

    public void reserveBook(String memberId, String bookId) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);
        if (book == null || member == null) {
            System.out.println("Error when reserving Book: Book or Member not found.");
            return;
        }
        if (book.isReserved()){
            System.out.println("Error when reserving Book: Book " + bookId + " is already reserved.");
            return;
        }
        if (!book.isIssued){
            System.out.println("Error when reserving Book: Book " + bookId + " is not issued, therefore cannot be reserved.");
            return;
        }
        book.reserveBook(memberId);
        System.out.println("Book " + bookId + " has been reserved for member " + member.memberId + ".");
    }

    public void displayBooks(){
        System.out.println("Books in Library:");
        for(Book book : books) {
            System.out.println(book.getBookDetails());
        }
    }

    public void displayMembers(){
        System.out.println("Members in Library:");
        for(Member member : members) {
            System.out.println(member.getMemberDetails());
        }
    }

    public Member getMember(String memberId) {
        for (Member m : members)
            if (m.memberId.equals(memberId)){
                return m;
            }
        return null;
    }
    public Book getBook(String bookId) {
        for (Book b : books)
            if (b.bookId.equals(bookId)){
                return b;
            }
        return null;
    }






}
