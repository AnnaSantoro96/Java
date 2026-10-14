package JavaBase.Methods;

public class FrontBack {

    static String frontBack(String str){
        if(str.length() < 2) return str;

        char firstCharacter = str.charAt(0);
        char lastCharacter = str.charAt(str.length()-1);

        if(str.length() == 2) return Character.toString(lastCharacter) + Character.toString(firstCharacter);

        String subString = str.substring(1, str.length()-1);

        return Character.toString(lastCharacter) + subString + Character.toString(firstCharacter);
    }

    static void main() {

        String word1 = frontBack("code");
        String word2 = frontBack("a");
        String word3 = frontBack("ab");

        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3);

    }
}
