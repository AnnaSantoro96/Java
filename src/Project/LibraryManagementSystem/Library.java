package Project.LibraryManagementSystem;

import JavaBase.Exercices.LeapYear;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Member> members;
    private ArrayList<Loan> loans;

    public Library(){
        books = new HashMap<>();
        members = new HashMap<>();
        loans = new ArrayList<>();
    }

    public void addBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("Invalid book");
        }

        if(books.containsKey(book.getIsbn())){
            throw new IllegalArgumentException("The ISBN is already present");
        }

        books.put(book.getIsbn(), book);
    }

    public void addMember(Member member){
        if(member == null){
            throw new IllegalArgumentException("Invalid member");
        }

        if(members.containsKey(member.getId())){
            throw new IllegalArgumentException("The member is already present");
        }

        members.put(member.getId(), member);
    }

    public Book findBookByIsbn(String isbn){
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Invalid isbn");
        }

        return books.get(isbn);
    }

    public void removeBook(String isbn){
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Invalid isbn");
        }

        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found");
        }

        books.remove(isbn);
    }

    public void printAllBooks(){
        if (books.isEmpty()){
            System.out.println("The catalog is empty");
            return;
        }

        for (Book book :books.values()){
            System.out.println(book);
        }
    }

    public void borrowBook(String isbn, String memberId){
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Invalid isbn");
        }

        if(memberId == null || memberId.isBlank()){
            throw new IllegalArgumentException("Invalid member");
        }

        Book book = books.get(isbn);
        Member member = members.get(memberId);

        if(book == null){
            throw new IllegalArgumentException("The book doesn't exist");
        }

        if(member == null){
            throw new IllegalArgumentException("The member doesn't exist");
        }

        if (!book.isAvailable()) {
            throw new IllegalArgumentException("The book is not available");
        }

        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = loanDate.plusDays(30);
        Loan loan = new Loan(book, member, loanDate, dueDate);
        loans.add(loan);

        book.setAvailable(false);
    }

    public void returnBook(String isbn){
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Invalid isbn");
        }

        Book book = findBookByIsbn(isbn);
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }

        if(book.isAvailable()){
            throw new IllegalArgumentException("The book is not borrowed");
        }

        for(Loan loan : loans){
            if(loan.getBook().getIsbn().equals(isbn) && !loan.isReturned()){
                loan.setReturned(true);
                break;
            }
        }
        book.setAvailable(true);
    }

    public void printAllLoans() {
        if (loans.isEmpty()) {
            System.out.println("There are no active loans");
            return;
        }

        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    public void printLoansByMember(String memberId){
        if(memberId == null || memberId.isBlank()){
            throw new IllegalArgumentException("Invalid member");
        }

        boolean found = false;

        for(Loan loan : loans){
            if (loan.getMember().getId().equals(memberId)){
                found = true;
                System.out.println(loan);
            }
        }

        if(!found){
            System.out.println("No loans found for this member");
        }
    }

    public int countActiveLoans(){
        int count = 0;

      for (Loan loan : loans){
          if (!loan.isReturned())
              count++;
      }
      return count;
    }

    public int countLoansByMember(String memberId){
        if(memberId == null || memberId.isBlank()){
            throw new IllegalArgumentException("Invalid member id");
        }

        if (!members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member not found");
        }

        int count = 0;

        for(Loan loan : loans){
            if(loan.getMember().getId().equals(memberId)){
                count++;
            }
        }
        return count;
    }

    public void printOverdueLoans(){
        boolean found = false;

        for(Loan loan : loans){
            if(!loan.isReturned() && loan.getDueDate().isBefore(LocalDate.now())){
                found = true;
                System.out.println(loan);
            }
        }

        if(!found){
            System.out.println("No overdue loans found");
        }
    }

    public void printLoansDueSoon(){
        boolean found = false;

        for(Loan loan : loans){
            if(!loan.isReturned() && (!loan.getDueDate().isBefore(LocalDate.now()) && !loan.getDueDate().isAfter(LocalDate.now().plusDays(7)))){
                found = true;
                System.out.println(loan);
            }
        }
        if(!found){
            System.out.println("No loans due soon");
        }
    }

    public int countOverdueLoans(){
        int count = 0;

        for (Loan loan : loans){
            if(!loan.isReturned() && loan.getDueDate().isBefore(LocalDate.now())){
                count++;
            }
        }
        return count;
    }

    public Loan findActiveLoanByIsbn(String isbn){
        if (isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Invalid isbn");
        }

        for(Loan loan : loans){
            if(loan.getBook().getIsbn().equals(isbn) && !loan.isReturned()){
                return loan;
            }
        }
        return null;
    }

    public void removeMember(String memberId){
        if(memberId == null || memberId.isBlank()){
            throw new IllegalArgumentException("Invalid member id");
        }

        if(!members.containsKey(memberId)){
            throw new IllegalArgumentException("Member not present");
        }

        boolean hasActiveLoans = false;

        for(Loan loan : loans){
            if(loan.getMember().getId().equals(memberId) && !loan.isReturned()){
                hasActiveLoans = true;
                break;
            }
        }
            if(hasActiveLoans){
                throw new IllegalArgumentException("Acive Loans");
            }

            members.remove(memberId);
    }

    public void updateMember(String memberId, String newName, String newLastName){
        if(newName == null || newName.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        if(newLastName == null || newLastName.isBlank()){
            throw new IllegalArgumentException("Invalid last name");
        }

        if(memberId == null || memberId.isBlank()){
            throw new IllegalArgumentException("Invalid member id");
        }

        if(!members.containsKey(memberId)){
            throw new IllegalArgumentException("The member is not present");
        }

        Member member = members.get(memberId);
        member.setName(newName);
        member.setLastName(newLastName);
    }

    public int countAvailableBooks(){
        int count = 0;

        for(Book book : books.values()){
            if(book.isAvailable()){
                count++;
            }
        }

        return count;
    }

    public int countBooksByCategory(String category){
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("Invalid category");
        }

        int count = 0;

        for(Book book : books.values()){
            if(book.getCategory().equalsIgnoreCase(category)){
                count++;
            }
        }
        return count;
    }
}
