import LinkedList.List;
import LinkedList.Node;

public class Main {
	public static void main(String[] args) {
		List list = new List();
		Node node1 = new Node("gosvoh".toCharArray(), "gosvoh@gosvoh.ga".toCharArray());
		Node node2 = new Node("Alex".toCharArray(), "vohmina2011@yandex.ru".toCharArray());
		list.insert(list.end(), node1);
		list.insert(list.end(), node2);
		list.printList();
		System.out.println(list.retrieve(list.first()));
		System.out.println(list.locate(node2));
		list.delete(list.first());
		list.printList();
		list.makeNull();
		list.printList();
	}
}