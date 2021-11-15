package FirstLab.CursorList;

import FirstLab.ListData;

class MemoryCell {
    public ListData listData;
    public int      next;

    public MemoryCell() {
        this(null, -1);
    }

    public MemoryCell(ListData listData) {
        this(listData, -1);
    }

    public MemoryCell(int next) {
        this(null, next);
    }

    public MemoryCell(ListData listData, int next) {
        this.listData = listData;
        this.next = next;
    }
}
