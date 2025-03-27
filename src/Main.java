import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("b1", "Rick and Morty", "Jerry");
        Book book2 = new Book("b2", "Severance", "James");
        Book book3 = new Book("b3", "Inception", "Christopher Nolan");

        Member member1 = new Member("Alex", "m1");
        Member member2 = new Member("Fabian", "m2");

        Library hetzellibrary= new Library();


        hetzellibrary.addBook(book1);
        hetzellibrary.addBook(book2);
        hetzellibrary.addBook(book3);
        hetzellibrary.addMember(member1);
        hetzellibrary.addMember(member2);

        hetzellibrary.displayBooks();
        System.out.println();
        hetzellibrary.displayMembers();
        System.out.println();
        hetzellibrary.issueBook(member1.memberId, book1.bookId);
        hetzellibrary.issueBook(member2.memberId, book2.bookId);
        hetzellibrary.issueBook(member1.memberId, book3.bookId);
        System.out.println();
        hetzellibrary.displayBooks();
        System.out.println();
        hetzellibrary.displayMembers();
        System.out.println();
        hetzellibrary.reserveBook(member1.memberId, book2.bookId);
        System.out.println();
        hetzellibrary.displayBooks();
        System.out.println();
        hetzellibrary.displayMembers();
        System.out.println();
        hetzellibrary.returnBook(member2.memberId, book2.bookId, book2.issuedDate.minusDays(15));
        System.out.println();
        hetzellibrary.displayBooks();
        System.out.println();
        hetzellibrary.displayMembers();
    }
}
