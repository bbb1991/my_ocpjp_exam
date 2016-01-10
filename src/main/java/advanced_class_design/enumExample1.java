package advanced_class_design;


public class enumExample1 {
    public static void main(String[] args) {
        for (Seasons season : Seasons.values()) {
            System.out.println(season);
        }

        System.out.println();
        System.out.println(Seasons.valueOf("summer".toUpperCase()));
    }


}

enum Seasons {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}