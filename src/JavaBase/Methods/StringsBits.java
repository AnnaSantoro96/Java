package JavaBase.Methods;

public class StringsBits {

    /*static String stringsBits(String str){
        String newString = "";

        //CASO BASE
        if(str.equals("")) return "";

        //CASO PRINCIPALE
        for(int i= 0; i < str.length(); i++){
            if(i % 2 == 0){
                newString += str.charAt(i);
            }
        }

        return newString;
    }*/

    static String stringsBits(String str){
        StringBuilder sb = new StringBuilder();

        if(str.equals("")) return "";

        for(int i = 0; i < str.length(); i++){
            if(i % 2 == 0){
                sb.append(str.charAt(i));
            }
        }

        String result = sb.toString();
        return result;
    }

    static void main() {
        String str1 = stringsBits("Hello");
        String str2 = stringsBits("Hi");
        String str3 = stringsBits("Heeololeo");

        IO.println(str1);
        IO.println(str2);
        IO.println(str3);
    }
}
