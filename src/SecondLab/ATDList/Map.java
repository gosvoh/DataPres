package SecondLab.ATDList;

import FirstLab.LinkedList.List;
import FirstLab.IPos;
import FirstLab.ListData;
import SecondLab.AMap;

public class Map extends AMap {

    List list;

    public Map() {
        list = new List();
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++)
            list.insert(list.end(),
                    new ListData(new char[]{(char) (i - RangeType.FIRST)}, new char[]{RangeType.NODEF}));
    }

    private char[] getData(int key) {
        IPos pos = list.first();
        while (!pos.equals(list.end())) {
            ListData ld = list.retrieve(pos);
            if (ld.getName()[0] == key) return ld.getAddress();
            pos = list.next(pos);
        }
        return null;
    }

    @Override public void makeNull() {
        IPos pos = list.first();
        while (!pos.equals(list.end())) {
            list.retrieve(pos).getAddress()[0] = RangeType.NODEF;
            pos = list.next(pos);
        }
    }

    @Override public void assign(int key, char value) {
        char[] data = getData(key);
        if (data != null) data[0] = value;
    }

    @Override public boolean compute(int key, RangeType r) {
        char[] data = getData(key);
        if (data == null || data[0] == RangeType.NODEF) return false;
        r.setC(data[0]);
        return true;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        IPos pos = list.first();
        while (!pos.equals(list.end())) {
            sb.append(String.format("%3d", (int) list.retrieve(pos).getName()[0]));
            pos = list.next(pos);
        }
        sb.append("\n");
        pos = list.first();
        while (!pos.equals(list.end())) {
            sb.append(String.format("%3c", list.retrieve(pos).getAddress()[0]));
            pos = list.next(pos);
        }
        return sb.toString();
    }
}
