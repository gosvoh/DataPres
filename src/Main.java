import FirstLab.ArrayList.List;
import FirstLab.IList;
import FirstLab.IPos;
import FirstLab.Node;

public class Main {
	public static void main(String[] args) {
		List list = new List();
		Node node1 = new Node("gosvoh".toCharArray(), "gosvoh@gosvoh.ga".toCharArray());
		Node node2 = new Node("Alex".toCharArray(), "vohmina2011@yandex.ru".toCharArray());
		list.insert(list.end(), node1.getName(), node1.getAddress());
		list.insert(list.end(), node1.getName(), node1.getAddress());
		list.insert(list.end(), node1.getName(), node1.getAddress());
		list.insert(list.end(), node1.getName(), node1.getAddress());
		list.insert(list.end(), node2.getName(), node2.getAddress());
		list.insert(list.end(), node2.getName(), node2.getAddress());
		list.insert(list.end(), node2.getName(), node2.getAddress());
		list.insert(list.end(), node2.getName(), node2.getAddress());
		list.printList();
		deleteDupes(list);
		list.printList();
		System.out.println("First: " + list.retrieve(list.first()));
		System.out.println("Locate: " + list.locate(node2));
		list.delete(list.first());
		list.printList();
		list.makeNull();
		list.printList();
	}

	private static void deleteDupes(IList list) {
		IPos pos1 = list.first();
		while (!pos1.equals(list.end())) {
			Node node1 = list.retrieve(pos1);
			IPos pos2 = pos1;
			while (!pos2.equals(list.end())) {
				Node node2 = list.retrieve(pos2);
				if (node1 != node2 && node1.equals(node2))
					list.delete(pos2);
				else pos2 = list.next(pos2);
			}
			pos1 = list.next(pos1);
		}
	}
}