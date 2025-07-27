import java.util.*;
public class merge{
    public static void conquer(int []arr,int start,int mid,int end){
        int res[] = new int[end-start+1];
        int idx = 0;
        int idx1 = start;
        int idx2 = mid+1;
        while(idx1<=mid && idx2<=end){
            if(arr[idx1]<=arr[idx2]){
                res[idx++] = arr[idx1++];
            }else{
                res[idx++] = arr[idx2++];
            }
        }
        while(idx1<=mid){
            res[idx++] = arr[idx1++];
        }
        while(idx2<=end){
            res[idx++] = arr[idx2++];
        }
        for(int i = 0,j = start;i<res.length;i++ ,j++){
            arr[j] = res[i];
        }

    }
    public static void divide(int []arr,int start,int end){
        if(start>=end){
            return;
        }
        int mid = start + (end - start)/2;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        conquer(arr,start,mid,end);
    }
    public static void main(String[] args) {
        int arr[] = {32,4,34,2,12,13};
        int n = arr.length;
        divide(arr, 0, n-1);
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}