package FirstLab;

public interface IList {
    void insert(IPos pos, ListData listData);

    IPos first();

    IPos end();

    IPos locate(ListData node);

    ListData retrieve(IPos pos);

    void delete(IPos pos);

    IPos next(IPos pos);

    IPos previous(IPos pos);

    void makeNull();

    void printList();
}
