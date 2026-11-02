package Project.BrowserHistory;

public class Main {
    static void main() {
        BrowserHistory browserHistory = new BrowserHistory();

        browserHistory.visitPage("Google");
        browserHistory.visitPage("Youtube");
        browserHistory.visitPage("ChtaGPT");
        browserHistory.visitPage("GitHub");

        IO.println("List of the page");
        browserHistory.printHistory();
        IO.println();

        System.out.println("Go Back - Remove the last visit page");
        browserHistory.goBack();
        IO.println("List of the page");
        browserHistory.printHistory();
        IO.println();

        System.out.println("Remove the first page");
        browserHistory.goToFirstPage();
        IO.println("List of the page");
        browserHistory.printHistory();
        IO.println();

        System.out.println("View the last page");
        IO.println(browserHistory.showCurrentPage());
    }
}
