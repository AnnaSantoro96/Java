package JavaBase.Decision;

public class AccessControl {
    static void main() {
        boolean isLoggedIn = true;
        boolean isAdmin = false;
        int securityLevel = 3;

        if(isLoggedIn && (isAdmin || securityLevel <= 2)){
            System.out.println("Access granted");
        }else{
            System.out.println("Access denied");
        }
    }
}
