public class SLL {
    public Node head;
    public int size; 
    public SLL() {
    this.head = null; 
    this.size = 0; 
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            System.out.println(value + " was added as head node");
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
            System.out.println(value + " was added to end of list.");
            this.size++;
        }
    }
    
    public void displayList(){
        if(this.head == null){
            System.out.println("List is empty");
        }
        Node runner = this.head; 
        int counter = 0;
        while(runner != null){
            if(counter < 1){
                System.out.println("Root: " + runner.value);
                counter++;
                runner = runner.next; 
            }else{
                System.out.println("Node " + counter + ":" + runner.value);
                runner = runner.next; 
                counter++;
            }
        }
    }

    public boolean searchList(int value){
        if(this.head == null){
            System.out.println("List is empty");
        }
        Node runner = this.head; 
        while (runner != null){
            if( runner.value == value){
                return true; 
            }
            runner = runner.next; 
        }
        return false; 
    }
public void remove(){
    if (this.head == null){
        System.out.println("List is empty, nothing to remove");
    }
    Node runner = this.head; 
    while (runner.next.next != null){
        runner = runner.next; 
    }
    runner.next = null; 
    }
//removes at index specified
    public void removeAt(int n){
    if( this.head == null){
        System.out.println("List is empty.");
    }
    Node runner = this.head; 
    if(n == 0 && this.size > 1){
        this.head = runner.next; 
    }else{
        int counter = 0;
        while(runner.next != null){
            if(counter == n - 1){
                runner.next = runner.next.next; 
                return; 
            }
            runner = runner.next; 
            counter++;
        }
    }
    }
}