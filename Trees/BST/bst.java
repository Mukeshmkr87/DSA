import java.util.*;
public class bst{
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            left = right = null;
        }
    }
    public static Node insert(Node root,int data){
        if(root == null){
            return new Node(data);
        }
        if(root.val<data){
            root.right = insert(root.right, data);
        }
        if(root.val>data){
            root.left = insert(root.left, data);
        }
        return root;

    }
    public static Node inorderIncrement(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void searchdata(Node root,int data){
        if(root == null){
            System.out.println("No there is no such data: ");
            return;
        }
        if(root.val == data){
            System.out.println("Finally founded");
            return;
        }
        else if(root.val>data){
            searchdata(root.left, data);
        }
        else{
            searchdata(root.right, data);
        }
    }
    public static Node delete(Node root,int data){
        if(root.val<data){
            root.right = delete(root.right, data);
        }
        else if(root.val>data){
            root.left = delete(root.left, data);
        }
        else{
            //Case I
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }
            //Case II 
            else if(root.left == null){
                root = root.right;
            }else if(root.right == null){
                root = root.left;
            }
            //Case III
            else{
                Node  IP = inorderIncrement(root.right);
                root.val = IP.val;
                root.right = delete(root.right, IP.val);

            }
        }
        return root;
    }
    public static void nodebetweenrange(Node root,int lower,int higher){
        if(root == null){
            return;
        }
        if(root.val>higher){
            nodebetweenrange(root.left, lower, higher);
        }
        else if(root.val<lower){
            nodebetweenrange(root.right, lower, higher);
        }
        else{
            nodebetweenrange(root.left, lower, higher);
            System.out.println(root.val + " ");
            nodebetweenrange(root.right, lower, higher);
        }
    }
    public static void independentpath(Node root,String str){
        if(root == null){
            return;
        }
        str += root.val;
        if(root.left == null && root.right == null){
            System.out.println(str);
            return;
        }

        independentpath(root.left,str);
        independentpath(root.right,str);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr =  new ArrayList<>();
        while(true){
            int n = sc.nextInt();
            arr.add(n);
            if(n == -1){
                break;
            }
        }
        Node root = new Node(arr.get(0));
        for(int i = 1;i<arr.size()-1;i++){
            root = insert(root, arr.get(i));
        }
        int searchval = sc.nextInt();
        searchdata(root, searchval);
        int deletedata = sc.nextInt();
        delete(root, deletedata);
        int x = sc.nextInt();
        int y = sc.nextInt();
        nodebetweenrange(root, x, y);
        independentpath(root, "");
        
    }
}