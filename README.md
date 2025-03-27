# Übung 01

## Library Management System

```
Deadline: March 13 , 202 5 , 10:
```
```
To be submitted via Moodle: Java program code in zip file & Java program code as a PDF
file
```
## Objective:

The goal of this assignment is to help you understand and apply the concepts of classes,
methods, and objects in Java by building a **Library Management System**. You will
implement a system that manages books, members, and their interactions while handling
complex scenarios like book reservations, fines, and search functionality.

## Tasks:

The **Library Management System** supports the following features:

- **Book Management** : [4 points]
  Create a Book class. Each book has a unique bookId, title, author, and a status
  indicating whether it is borrowed or available (isIssued). A book can be reserved by a
  member if it is already borrowed which can be represented by the aUributes:
  reservedBy for the ID of the member who reserved the book (null if not reserved), and
  issuedDate for the date when the book was borrowed (null if not borrowed). You also
  need to define the methods: A method issueBook() for marking the book as borrowed
  and sets the issuedDate, method returnBook() for marking the book as returned and
  clears reservedBy and issuedDate, method reserveBook(memberId) which takes
  memberId and reserves the book for a member, method isReserved() which returns
  true if the book is reserved and getBookDetails() for returning a string with book
  details (include status and reservedBy information).
- **Member Management** : [4 points]
  Create a Member class. Each member has a unique memberId, name, and a list of books
  they have borrowed. A member can borrow a maximum of 3 books at a time. You also
  need to define the methods to: issueBook(Book book) which takes a book object and
  adds the book to the member's borrowed books list, returnBook(Book book) which
  takes a book object and removes the book from the member's borrowed books list, a
  method canIssueBook() which returns true if the member can borrow more books
  (limit: 3), a method calculateFine(LocalDate returnDate) to calculate the fine if
  any book is returned late and a method getMemberDetails() which returns a string
  with member details (include the number of books borrowed).
- **Library Operations** : [8 points]
  Create a Library class. This class is used to add books and members to the library, issue
  books to members, and return books, calculate fines if the book is returned after10 days
  (fine: 1 Euro per day), and reserve a book for a member if it is already borrowed. All the


books in the library can be represented by an LinkedList of books. All the members in
the library can be represented by an LinkedList of members. You also need to define the
methods to: addBook(Book book) which takes a book object and adds the book to the
library, addMember(Member member) which takes a member object and adds a member
to the library, issueBook(memberId, bookId) which takes memberId and bookId and
issues the book to the member if possible, returnBook(memberId, bookId,
LocalDate returnDate) which takes memberId, bookId, and returnDate and returns
a book and calculates fine if applicable, reserveBook(memberId, bookId) which takes
memberId and bookId and reserves the book for the member if possible,
displayBooks() to displays all books in the library, and displayMembers() to displays
all members in the library.

- **Main Class** : [8 points]
  Create a Main class to test your implementation.
  § Add at least 3 books and 2 members to the library.
  § Perform the following operations:
  - Issue books to members.
  - Reserve a book that is already borrowed.
  - Return a book after 15 days and check the fine.
  - Display all books and members after each operation.
- **Edge Cases and Error Handling** :
  § Handle invalid bookId or memberId.
  § Prevent issuing a book that is already issued or reserved.
  § Prevent reserving a book that is available.
  § Ensure a member cannot borrow more than 3 books.
- **Hint** :
  § Use LocalDate for managing dates (e.g., issued date and return date).
  § Calculate fines based on the difference between the return date and the issued
  date.
- **Output:**

Books in Library:
Book ID: B001, Title: Java Programming, Author: John Doe, Status:
Available, Reserved By: None
Book ID: B002, Title: Python Basics, Author: Jane Smith, Status:
Available, Reserved By: None

Members in Library:
Member ID: M001, Name: Alice, Books Issued: 0
Member ID: M002, Name: Bob, Books Issued: 0
Book issued successfully!
Book issued successfully!

After issuing books:
Book ID: B001, Title: Java Programming, Author: John Doe, Status:
Issued, Reserved By: None


Book ID: B002, Title: Python Basics, Author: Jane Smith, Status:
Issued, Reserved By: None
Member ID: M001, Name: Alice, Books Issued: 1
Member ID: M002, Name: Bob, Books Issued: 1
Book reserved successfully!

After reserving book:
Book ID: B001, Title: Java Programming, Author: John Doe, Status:
Issued, Reserved By: None
Book ID: B002, Title: Python Basics, Author: Jane Smith, Status:
Issued, Reserved By: M
Fine for late return: $5.
Book returned successfully!

After returning book:
Book ID: B001, Title: Java Programming, Author: John Doe, Status:
Issued, Reserved By: None
Book ID: B002, Title: Python Basics, Author: Jane Smith, Status:
Available, Reserved By: None
Member ID: M001, Name: Alice, Books Issued: 1
Member ID: M002, Name: Bob, Books Issued: 0


