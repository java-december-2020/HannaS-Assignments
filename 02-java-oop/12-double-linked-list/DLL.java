public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
        public void push(Node newNode) {
// if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    public void printValuesForward() {
        Node current = this.head;
        
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    public void printValuesBackward(){
        Node current = this.tail; 
        while(current != null){
            System.out.println(current.value);
            current = current.previous; 
        }
    }

    public Node pop(){
        if(this.head == null){
            System.out.println("List is empty, nothing to remove");
        }
        Node runner = this.head; 
        while(runner.next.next != null){
            runner = runner.next; 
        }
        runner.next = null; 
        return runner; 
    }

    public boolean contains(Integer value){
        Node current = this.head; 
        while(current != null){
            if(current.value.equals(value)){
                return true; 
            }else{
                current = current.next; 
            }
        }
        return false; 
    }
    public int size(Node node){
        int count = 0; 
        while(node != null){
            count++;
            node = node.next; 
        }
        return count; 
    }

    /*public void insertAt(Node newNode, int index){
        Node current = this.head; 
        if(index == 0){
            newNode = this.head; 
            current = newNode.next; 
        }else

        }

    }*/



}