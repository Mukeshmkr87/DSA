import java.util.Scanner;

public class bitmanup {
    public static int get(int num,int n){//Get in bit manupulation   
        int r = 1;
        n = r<<n;
        if((n & num) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int set(int num,int n){//set in bit manupulation
        int r = 1;
        n = r<<n;
        num = num | n;
        return num;
    }
    public static int clear(int num,int n){//clear in bit manupulation
        int r = 1;
        n = r<<n;
        n = ~n;
        num = num & n;
        return num;
    }
    public static void update(int num,int n,boolean bool){//Update in bit manupulation
        if(bool){
            num = set(num,n);
        }
        else{
           num = clear(num, n); 
        }
        System.out.println(num);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = sc.nextInt();
        boolean bool = sc.nextBoolean();
        // System.out.println(get(num,n));
        // System.out.println(set(num,n));
        update(num, n,bool);
       
    }
}
