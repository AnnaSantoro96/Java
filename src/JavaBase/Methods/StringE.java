package JavaBase.Methods;

public class StringE {

    static boolean stringE(String str){
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'e')
                count++;
        }

        if(count >= 1 && count <= 3){
            return true;
        }

        return false;
    }

    static void main() {
        boolean str1 = stringE("Hello");
        boolean str2 = stringE("Heelle");
        boolean str3 = stringE("Heelele");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println();
    }
}
