public class cqueuearr {
    static int rear = -1;
    static int front = -1;
    static int[] arr;
    static int n;
    cqueuearr(int n){
        this.n = n;
        arr = new int[n];
    }
    static boolean isEmpty(){
        return front == -1 &&  rear == -1;
    }
    static boolean isFull(){
        return (rear+1)%n == front; 
    }
    static void add(int data){
        if(isFull()){
            System.out.println("Queue is full");
        }
        if(front == -1){
            front = 0;
        }
        rear = (rear + 1) % n;
        arr[rear] = data;
    }
    static int remove(){
        if(isEmpty()){
            return -1;
        }
        int res = arr[front];
        if(rear == front){
            rear = front = -1;
        }
        else{
            front = (front+1)%n;
        }
        return res;

    }


    public static void main(String[] args) {
        cqueuearr q = new cqueuearr(4);
        q.add(45);
        q.add(23);
        q.add(22);
        q.add(33);
        System.out.println(q.remove());
        q.add(19);
    }
    
}
