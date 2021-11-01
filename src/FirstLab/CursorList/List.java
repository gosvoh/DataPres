package FirstLab.CursorList;

import FirstLab.IList;
import FirstLab.IPos;
import FirstLab.ListData;
import FirstLab.NullPosException;

public class List implements IList {
    private static final int          MAX_SIZE = 10;
    private static final MemoryCell[] objects  = new MemoryCell[MAX_SIZE];
    private static       int          SPACE    = 0;
    private              int          head;

    static {
        for (int i = 1; i < objects.length; i++) {
            objects[i] = new MemoryCell();
            objects[i].next = i + 1;
        }
        objects[MAX_SIZE - 1].next = -1;
    }

    public List() {
        head = -1;
    }

    @Override public void insert(IPos pos, ListData li) {
        ListData listData = li.copy();
        /*if (head == -1) {
            int tmp = allocate();
            head = tmp;
            objects[head].setListObj(listObj);
            objects[head].setNext(-1);
        } else if (((Pos) pos).getNext() == -1) {
            Pos last = getLast();
            int tmp = allocate();
            last.setNext(SPACE);
            Pos newObj = objects[SPACE];
            SPACE = objects[SPACE].getNext();
            newObj.setListObj(listObj);
            newObj.setNext(-1);
        } else {
            Pos prev = getPrev((Pos) pos);
            Pos next = objects[prev.getNext()];
            prev.setNext(SPACE);
            SPACE = objects[SPACE].getNext();
            prev.setListObj(listObj);
            objects[prev.getNext()].setNext(next.getNext());
        }*/
        /*int p = allocate();
        Pos prev = getPrev((Pos) pos);
        Pos next;
        if (head == -1) {

        } else if (pos == objects[head]) {
            next = objects[head];
        } else if (((Pos) pos).getNext() == -1) {

        }*/
    }

    private int allocate() {
        int p = SPACE;
        if (p == -1) throw new NullPosException("Out of memory");
        SPACE = objects[SPACE].next;
        return p;
    }

    private void swapMem(int pointer1, Pos pos1, int pointer2, Pos pos2) {
        //TODO
        /*
         * insert - выделение памяти
         * delete - возвращение памяти
         * head -> elem1
         * elem1 -> elem2
         * elem2 -> -1
         * 0
         *
         * insert(elem1, elem3):
         * head -> elem1
         * elem1 -> elem3
         * elem2 -> -1
         * elem3 -> elem2
         *
         * delete(elem1):
         * head -> elem3
         * 0
         * elem2 -> -1
         * elem3 -> elem2
         */
    }

    private MemoryCell getPrev(MemoryCell ld) {
        MemoryCell cur = objects[head];
        MemoryCell prev = null;
        while (cur.next != -1) {
            if (ld == cur) return prev;
            prev = cur;
            cur = objects[cur.next];
        }
        return prev;
    }

    private MemoryCell getLast() {
        MemoryCell mc = objects[head];
        if (mc.next == -1) return mc;
        MemoryCell prev = null;
        while (mc.next != -1) {
            mc = objects[mc.next];
            prev = mc;
        }
        return prev;
    }

    @Override public Pos first() {
        return head == -1 ? end() : new Pos(objects[head]);
    }

    /** @return позиция после последнего элемента */
    @Override public Pos end() {
        return new Pos(new MemoryCell(-1));
    }

    @Override public Pos locate(ListData data) {
        if (head == -1 || data == null) return null;
        int h = head;
        while (h != -1) {
            if (data.equals(objects[h].listData)) return new Pos(objects[h]);
            else h = objects[h].next;
        }
        return null;
    }

    @Override public ListData retrieve(IPos pos) {
        if (head == -1 || ((Pos) pos).cell == null) throw new NullPosException("List is empty or wrong position!");
        int h = head;
        while (h != -1) {
            if (objects[h] == ((Pos) pos).cell) return objects[h].listData;
            h = objects[h].next;
        }
        throw new NullPosException("No such element!");
    }

    private void free(int pos) {
        objects[pos].listData = null;
        objects[pos].next = SPACE;
        SPACE = pos;
    }

    @Override public void delete(IPos pos) {
        if (head == -1 || ((Pos) pos).cell == null) return;
        MemoryCell prev = getPrev(((Pos) pos).cell);
        int p;
        if (prev == null && ((Pos) pos).cell == objects[head]) {
            p = head;
            head = objects[p].next;
        } else {
            if (prev == null) throw new NullPosException("Empty previous");
            p = prev.next;
            prev.next = objects[p].next;
        }
        free(p);
    }

    @Override public Pos next(IPos pos) {
        if (head == -1 || ((Pos) pos).cell == null || ((Pos) pos).cell.next == -1)
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(objects[((Pos) pos).cell.next]);
    }

    @Override public Pos previous(IPos pos) {
        if (head == -1 || ((Pos) pos).cell == null || ((Pos) pos).cell == objects[head])
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(getPrev(((Pos) pos).cell));
    }

    @Override public void makeNull() {
        int oldSpace = SPACE;
        SPACE = head;
        while (head != -1) {
            objects[head].listData = null;
            int tmp = objects[head].next;
            objects[head].next = tmp == -1 ? oldSpace : tmp;
            head = tmp;
        }
    }

    @Override public void printList() {
        System.out.println(this);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName()).append(":").append(System.lineSeparator());
        int h = head;
        if (h == -1) return sb.append("List is empty!").toString();
        while (h != -1) {
            MemoryCell cell = objects[h];
            sb.append(cell.listData);
            if (cell.next != -1) sb.append(",").append(System.lineSeparator());
            h = cell.next;
        }
        return sb.toString();
    }
}
