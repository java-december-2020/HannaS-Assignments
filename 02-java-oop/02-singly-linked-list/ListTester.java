public class ListTester {
    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.displayList();
        System.out.println(sll.searchList(10));
        System.out.println(sll.searchList(88));
        sll.removeAt(2);
        sll.displayList();
        //sll.remove();
        
    }
}