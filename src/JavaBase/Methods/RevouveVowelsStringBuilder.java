package JavaBase.Methods;

public class RevouveVowelsStringBuilder {
    static String remouveBuild(String str){
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for(int i = 0; i < str.length(); i++){
                 char c = str.charAt(i);

            if(vowels.indexOf(c) == -1){
                sb.append(c);
            }
        }

        String result = sb.toString();
        return result;
    }

    static void main() {

        String str = remouveBuild("programmazione");
        System.out.println(str);
    }
}
