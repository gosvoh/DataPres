package FirstLab.CursorList;

import FirstLab.IList;
import FirstLab.IPos;
import FirstLab.ListData;
import FirstLab.NullPosException;

public class List implements IList {
    private static final int          MAX_SIZE = 10;
    private static final MemoryCell[] objects  = new MemoryCell[MAX_SIZE];
    private static       int          SPACE    = 0;

    static {
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new MemoryCell();
            objects[i].next = i + 1;
        }
        objects[MAX_SIZE - 1].next = -1;
    }

    private              int          head;

    public List() {
        head = -1;
    }

    @Override public void insert(IPos pos, ListData ld) {
        int pointer = allocate();
        if (pointer == -1) return;
        ListData listData = ld.copy();
        MemoryCell prev = head == -1 ? null : getPrev(((Pos) pos).cell);

        MemoryCell pMem = ((Pos) pos).cell;
        MemoryCell next = objects[pointer];
        next.listData = listData;
        if (head == -1 || pMem == objects[head]) {
            next.next = head;
            head = pointer;
        } else {
            next.next = prev.next;
            prev.next = pointer;
        }
    }

    /**
     *
     * @return
     */
    private int allocate() {
        int pointer = SPACE;
        if (pointer == -1) return -1;
        SPACE = objects[SPACE].next;
        return pointer;
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

    private MemoryCell getPrev(MemoryCell mc) {
        MemoryCell curr = objects[head];
        MemoryCell prev = new MemoryCell();
        int h = head;
        while (h != -1) {
            if (curr.listData == mc.listData) return prev;
            h = curr.next;
            prev = curr;
            if (mc.listData == null && h == -1) return prev;
            curr = objects[h];
        }
        return new MemoryCell();
    }

    private MemoryCell getLast() {
        MemoryCell curr = objects[head];
        MemoryCell prev = curr;
        while (curr.next != -1) {
            curr = objects[curr.next];
            prev = curr;
        }
        return prev;
    }

    @Override public Pos first() {
        return head == -1 ? end() : new Pos(objects[head]);
    }

    /** @return позиция после последнего элемента */
    @Override public Pos end() {
        return new Pos(new MemoryCell());
    }

    @Override public Pos locate(ListData data) {
        if (head == -1 || data == null) return null;
        int h = head;
        while (h != -1) {
            if (data.equals(objects[h].listData)) return new Pos(objects[h]);
            h = objects[h].next;
        }
        return new Pos(new MemoryCell());
    }

    @Override public ListData retrieve(IPos pos) {
        if (head == -1 || ((Pos) pos).cell == null)
            throw new NullPosException("List is empty or wrong position!");
        int h = ((Pos) pos).cell == objects[head] ? head : getPrev(((Pos) pos).cell).next;
        if (h == -1) throw new NullPosException("No such element!");
        return objects[h].listData;
    }

    private void free(int pos) {
        objects[pos].listData = null;
        objects[pos].next = SPACE;
        SPACE = pos;
    }

    @Override public void delete(IPos pos) {
        if (head == -1 || ((Pos) pos).cell == null) return;
        MemoryCell prev = getPrev(((Pos) pos).cell);
        int pointer;
        if (prev.listData == null && ((Pos) pos).cell == objects[head]) {
            pointer = head;
            head = objects[pointer].next;
        } else {
            if (prev.listData == null) throw new NullPosException("Empty previous");
            pointer = prev.next;
            prev.next = objects[pointer].next;
        }
        free(pointer);
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
