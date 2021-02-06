package util;

public class Validator {

    public static boolean string(String s){
        return s != null && s.length() > 0;
    }

    public static boolean name(String name){
        String s = name.toLowerCase().trim();
        for (int i = 0; i < name.length(); i++) {
            if((s.charAt(i) > 'z' || s.charAt(i) < 'a') && s.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }

    public static boolean tel(String number){
        return ((number.length() == 10) &&
                (number.charAt(0) == '0') &&
                (number.charAt(1) == '8'))
                ||
                (number.length() == 13 &&
                        number.charAt(0) == '+' &&
                        number.charAt(1) == '3' &&
                        number.charAt(2) == '5' &&
                        number.charAt(3) == '9' &&
                        number.charAt(4) == '8');
    }
}
