package JavaBase.Methods;

public class StringSplosion {

    /*static String stringSplocion(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            sb.append(str.substring(0,i+1));
        }

        return sb.toString();
    }*/

    static String stringSplocion(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j < i+1; j++){
                sb.append(str.charAt(j));
            }
        }

        return sb.toString();
    }

    static void main() {
        System.out.println(stringSplocion("code"));
        System.out.println(stringSplocion("abc"));
    }
}
