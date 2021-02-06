package util;

import java.util.Random;

public class Generate {

    public static String genFemaleName(){
        String[] names = {"Пенка", "Катрина", "Жана", "Сиси", "Ганка", "Гроздана", "Минка", "Моника", "Криси", "Ивана", "Мирела", "Венета"};
        return names[new Random().nextInt(names.length)];
    }
    public static String genMaleName(){
        String[] names = {"Пенко", "Борис", "Коста", "Жуан", "Патла Жан", "Реджеп", "Жоро", "Виктор", "Атанас", "Краси", "Констан", "Пиер", "Арон"};
        return names[new Random().nextInt(names.length)];
    }

    public static String name(){
        if(new Random().nextBoolean()){
            return genFemaleName();
        }
        else
            return genMaleName();
    }

    public static String tel(){
        return "08".concat(Integer.toString((new Random().nextInt(2) + 8))).concat(Integer.toString((new Random().nextInt(9000000) + 1000000)));
    }

    public static int number(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }

    public static boolean tossABoolean(){
        return new Random().nextBoolean();
    }

}
