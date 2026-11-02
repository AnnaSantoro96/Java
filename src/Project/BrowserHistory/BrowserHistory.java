package Project.BrowserHistory;
import java.util.Deque;
import java.util.LinkedList;

public class BrowserHistory {

    private Deque<String> browserPages;

    public BrowserHistory(){
        browserPages = new LinkedList<>();
    }

    public void visitPage(String url){
        if(url == null || url.isBlank()){
            throw new IllegalArgumentException("Invalid input");
        }

        browserPages.addLast(url);
    }

    public void goBack(){
        if(browserPages.isEmpty()){
            IO.println("The list is empty");
            return;
        }

        browserPages.pollLast();
    }

    public void goToFirstPage(){
        if(browserPages.isEmpty()){
            IO.println("The list is empty");
            return;
        }

        browserPages.pollFirst();
    }

    public String showCurrentPage(){
       return  browserPages.peekLast();
    }

    public void printHistory(){
        for(String url : browserPages){
            System.out.println(url);
        }
    }
}
