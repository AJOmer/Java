public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove(){
        if( head == null){
            return;
        }else{
            Node runner = head;
            while(runner.next.next != null){
                runner = runner.next;
            }
            runner.next = null;
        }
    }
    public void printValues(){
        Node runner = this.head;
        if ( runner == null){
            System.out.println(runner);
        }else{
            while(runner != null){
                System.out.println(runner.value);
                runner = runner.next;
            }
        }
    }
    public Node findNode(int value){
        Node runner = this.head;
        while(runner.value != value){
            runner = runner.next;
        }
        return runner;
    }
    public void removeAt(int x){
        Node runner = this.head;
        if(runner == null){
            System.out.println("EMPTY");
        }else{
            for(int i = 0; i< x-1; i++){
                runner = runner.next;
            }
            runner.next = runner.next.next;
        }
    }    
}