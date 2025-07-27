import java.util.HashMap;
import java.util.Scanner;
public class Caeser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<25;i++){
            char ch = 65;
            map.put(ch++,i);
        }
        String st = sc.nextLine();
        int arr[] = new int[st.length()];
        for(int i =0 ;i<st.length();i++){
            arr[i] = (map.get(st.charAt(i)) + 3)%25;
        }
        String res = "";
        for(int i =0 ;i<arr.length;i++){
            res += map.getvalue()
            p

            
        }

    }
}
