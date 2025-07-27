import java.util.*;
public class recursion {
    public static void solve(List<Integer> arr,int idx,List<Integer> ans,List<List<Integer>> pf){
        if(idx == arr.size()){
            pf.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr.get(idx));
        solve(arr, idx + 1, ans,pf);
        ans.remove(ans.size()-1);
        solve(arr, idx + 1, ans,pf);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> pf = new ArrayList<>();
        solve(list,0,ans,pf);
        for(List<Integer> prt : pf){
            System.out.print(prt);
        }

    }
}