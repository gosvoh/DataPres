package SecondLab.ATDList;

import FirstLab.LinkedList.List;
import FirstLab.LinkedList.Pos;
import FirstLab.ListData;
import SecondLab.AMap;

public class Map extends AMap {

    List list;

    public Map() {
        list = new List();
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++)
            list.insert(list.end(), new ListData(String.valueOf(i - RangeType.FIRST).toCharArray(), new char[]{RangeType.NODEF}));
    }

    @Override public void makeNull() {
        list.makeNull();
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++)
            list.insert(list.end(), new ListData(new char[]{RangeType.NODEF}, new char[0]));
    }

    @Override public void assign(int key, char value) {
        Pos pos = list.first();
        for (int i = 0; i < key; i++) pos = list.next(pos);
        list.insert(pos, new ListData(new char[]{value}, new char[0]));
        list.delete(pos);
    }

    @Override public boolean compute(int key, RangeType r) {
        Pos pos = list.first();
        for (int i = 0; i < key; i++) pos = list.next(pos);
        if (list.retrieve(pos).getName()[0] == RangeType.NODEF) return false;
        r.setC(list.retrieve(pos).getName()[0]);
        return true;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = RangeType.LAST - RangeType.FIRST + 1;
        for (int i = 0; i < size; i++) sb.append(String.format("%3d", i));
        sb.append("\n");
        Pos pos = list.first();
        while (pos != list.end() && pos != null) {
            sb.append(String.format("%3c", list.retrieve(pos).getName()[0]));
            pos = list.next(pos);
        }
        return sb.toString();
    }
}
