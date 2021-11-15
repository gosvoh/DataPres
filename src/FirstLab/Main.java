package FirstLab;

public class Main {
	public static void main(String[] args) {
		runCode(new FirstLab.ArrayList.List());
		runCode(new FirstLab.LinkedList.List());
		runCode(new FirstLab.CursorList.List());
		runCode(new FirstLab.DoublyLinkedList.List());
	}

	private static void runCode(IList list) {
		ListData node1 = new ListData("gosvoh".toCharArray(), "gosvoh@gosvoh.ga".toCharArray());
		ListData node2 = new ListData("Alex".toCharArray(), "vohmina2011@yandex.ru".toCharArray());
		list.insert(list.end(), node1);
		list.insert(list.end(), node1);
		list.insert(list.end(), node1);
		list.insert(list.end(), node1);
		list.insert(list.end(), node2);
		list.insert(list.end(), node2);
		list.insert(list.end(), node2);
		list.insert(list.end(), node2);
		list.printList();
		System.out.println("First: " + list.first());
		System.out.println("End: " + list.end());
		System.out.println("Retrieve: " + list.retrieve(list.first()));
		System.out.println("Locate: " + list.locate(node2));
		list.delete(list.first());
		list.printList();
		list.makeNull();
		list.printList();
		System.out.println("----------------------------------------------");
	}

	private static void deleteDupes(IList list) {
		IPos pos1 = list.first();
		while (!pos1.equals(list.end())) {
			ListData node1 = list.retrieve(pos1);
			IPos pos2 = pos1;
			while (!pos2.equals(list.end())) {
				ListData node2 = list.retrieve(pos2);
				if (node1 != node2 && node1.equals(node2))
					list.delete(pos2);
				else pos2 = list.next(pos2);
			}
			pos1 = list.next(pos1);
		}
	}
}