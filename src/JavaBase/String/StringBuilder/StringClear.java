package JavaBase.String.StringBuilder;

public class StringClear {
    static String clean(String identifier) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < identifier.length(); i++){
            char current = identifier.charAt(i);

            if (current == ' ') {
                sb.append('_');
            }else
            if(current == '-'){
                if(i+1 < identifier.length()){
                    sb.append(Character.toUpperCase(identifier.charAt(i + 1)));
                    i++;
                }
            }else{


                switch(current){
                    case '4':
                        sb.append('a');
                        break;

                    case '3':
                        sb.append('e');
                        break;

                    case '0':
                        sb.append('o');
                        break;

                    case '1':
                        sb.append('l');
                        break;

                    case '7':
                        sb.append('t');
                        break;

                    default:
                        if (Character.isLetter(current)) {
                            sb.append(current);
                        }
                        break;
                }
            }
        }
        return sb.toString();
    }

    static void main() {
        String clear = clean("a$#.b");
        IO.println(clear);
    }
}
