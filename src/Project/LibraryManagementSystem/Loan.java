package Project.LibraryManagementSystem;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    public Loan(Book book, Member member, LocalDate loanDate, LocalDate dueDate){
        setBook(book);
        setMember(member);
        setLoanDate(loanDate);
        setDueDate(dueDate);
        this.returned = false;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if(book == null){
            throw new IllegalArgumentException("Invalid book");
        }
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if(member == null){
            throw new IllegalArgumentException("Invalid member");
        }
        this.member = member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        if(loanDate == null){
            throw new IllegalArgumentException("Invalid loanDate");
        }

        if (dueDate != null && dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("The due date cannot be before the loan date");
        }

        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        if(dueDate == null){
            throw new IllegalArgumentException("Invalid dueDate");
        }

        if (dueDate.isBefore(loanDate)){
            throw new IllegalArgumentException("The due date cannot be before the loan date");
        }
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "\nBook: " + getBook() + "\nMember: " + getMember() + "\nLoan Date: " + getLoanDate() + "\nDue Date: " + getDueDate() + "\nReturned: " + returned;
    }
}
