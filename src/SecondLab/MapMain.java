package SecondLab;

import java.util.Random;

public class MapMain {
    public static void main(String[] args) {
        Map map = new Map();
        char a = Map.RangeType.FIRST, z = Map.RangeType.LAST;
        Map.RangeType r = new Map.RangeType(Map.RangeType.NODEF);
        Random random = new Random();
        int i, size = z - a + 1;
        while (a <= z) {
            i = Math.abs(random.nextInt() % size);
            if (!map.compute(i, r)) map.assign(i, a++);
        }
        System.out.println(map);
        System.out.println();

        a = Map.RangeType.FIRST;
        for (i = 0; i < size; i++) map.assign(i, a++);
        System.out.println(map);
        System.out.println();

        map.makeNull();
        System.out.println(map);
    }
}
