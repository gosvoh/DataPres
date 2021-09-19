package FirstLab;

public interface IList {
    void insert(IPos pos, char[] name, char[] address);

    IPos first();

    IPos end();

    IPos locate(INode node);

    INode retrieve(IPos pos);

    void delete(IPos pos);

    IPos next(IPos pos);

    IPos previous(IPos pos);

    void makeNull();

    void printList();
}
