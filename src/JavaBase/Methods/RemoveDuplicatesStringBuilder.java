package JavaBase.Methods;

public class RemoveDuplicatesStringBuilder {
    static String removeDuplicatesConsecutive(String str){
        StringBuilder sb = new StringBuilder();
        String result = "";

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                sb.append(str.charAt(i));
            } else {
                if (str.charAt(i) != str.charAt(i - 1)) {
                    sb.append(str.charAt(i));
                }
            }
        }

        result = sb.toString();
        return result;
    }

    static String removeAllDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        String result = "";

        for(int i = 0; i < str.length(); i++){
            boolean found = false;

            for(int j = 0; j < sb.length(); j++){
                if(str.charAt(i) == sb.charAt(j)){
                    found = true;
                    break;
                }
            }
            if(!found){
                sb.append(str.charAt(i));
            }
        }
        result = sb.toString();
        return result;

    }

    static void main() {
        System.out.println("REMOVE DUPLICATES CONSECUTIVE");
        String str = removeDuplicatesConsecutive("aaabbcddd");
        System.out.println(str);

        String str2 = removeDuplicatesConsecutive("aabbbaa");
        System.out.println(str2);

        String str3 = removeDuplicatesConsecutive("programmazione");
        System.out.println(str3);

        System.out.println();
        System.out.println("REMOVE ALL THE DUPLICATES IN THE STRING");
        String s1 = removeAllDuplicates("programmazione");
        System.out.println(s1);

    }
}
