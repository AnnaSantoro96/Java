package JavaBase.String.StringBuilder;

public class BuildSentence {
    public static String buildSentence(String[] words){
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }

    public static String reverseString(String text){
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();

    }

    public static String removeDuplicates(String text) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            if (sb.indexOf(String.valueOf(current)) == -1) {
                sb.append(current);
            }

        }

        return sb.toString();
    }

    public static boolean isPalindrome(String text) {
        StringBuilder sb = new StringBuilder(text);

        return sb.reverse().toString().equals(text);
    }

    static void main() {

        String[] words = {
                "Sto",
                "imparando",
                "Java",
                "con",
                "costanza"
        };

        String result = buildSentence(words);
        IO.println(result);

        IO.println();
        IO.println("Reverse String");
        String reverse = reverseString("Text");
        IO.println(reverse);

        IO.println();
        IO.println("Remove duplicates");
        String duplicates = removeDuplicates("programmazione");
        IO.println(duplicates);

        IO.println();
        IO.println("The word is palindrome?");
        boolean isPalindrome = isPalindrome("anna");
        System.out.println(isPalindrome);
    }
}
