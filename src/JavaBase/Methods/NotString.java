package JavaBase.Methods;

import java.awt.*;

public class NotString {
    static String notString(String str){
        String newString = "";

        if(str.length() < 3) return "not " + str;

        String subString = str.substring(0, 3);


       if(!(subString.equalsIgnoreCase("not"))){
           newString = "not " + str;
       }else{
           newString = str;
       }

       return newString;
    }

    static void main() {
        String str = notString("candy");
        String str2 = notString("x");
        String str3 = notString("not bad");
        String str4 = notString("no");

        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

    }
}
