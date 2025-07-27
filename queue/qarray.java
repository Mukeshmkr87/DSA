class qarray{
    static int arr[];
    static int n;
    static int rear = -1;
    qarray(int n){
        this.n = n;
        arr = new int[n];
    }
    static boolean isEmpty(){
        return rear == -1;
    }
    static void add(int data){
        if(rear == n-1){
            System.out.println("Queue is full");
        }
        rear++;
        arr[rear] = data;
    }
    static int remove(){
        if(rear == -1){
            return -1;
        }
        int data = arr[0];
        for(int i = 0;i<rear;i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return data;
    }
    static int peek(){
        if(rear == -1){
            return -1;
        }
        return arr[0];
    }
    public static void main(String[] args) {
        qarray q = new qarray(5);
        q.add(50);
        q.add(45);
        q.add(93);
        while(!isEmpty()){
            System.out.print(q.remove() +  " ");
        }

        
    }
}