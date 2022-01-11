package SecondLab;

import java.util.Random;

public class MapMain {
    public static void main(String[] args) {
//        runCode(new SecondLab.Array.Map());
        runCode(new SecondLab.ATDList.Map());
//        runCode(new SecondLab.LinkedList.Map());
    }

    private static void runCode(AMap map) {
        char a = AMap.RangeType.FIRST, z = AMap.RangeType.LAST;
        AMap.RangeType r = new AMap.RangeType(AMap.RangeType.NODEF);
        Random random = new Random();
        int i, size = z - a + 1;
        while (a <= z) {
            i = Math.abs(random.nextInt() % size);
            if (!map.compute(i, r)) map.assign(i, a++);
        }
        System.out.println(map);
        System.out.println();

        a = AMap.RangeType.FIRST;
        for (i = 0; i < size; i++) map.assign(i, a++);
        System.out.println(map);
        System.out.println();

        map.makeNull();
        System.out.println(map);
        System.out.println("--------------------------------------------------------------");
    }
}
