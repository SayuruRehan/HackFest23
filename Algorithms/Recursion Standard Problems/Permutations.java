import java.util.ArrayList;
import java.util.Arrays;

class Permutations {
    public static void main(String[] args) {
        // String str = "abc";
        // permutations(str, "");

        // ArrayList<String> ans = pString("abc", "");
        // System.out.println(ans);

        // int ans = permutationsCount("abc", "");
        // System.out.println(ans);

        //Strivers
        int []nums = {1,2,3};
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        striverPermutation(res,nums,0);
        for(int i=0;i<res.size();i++){
            System.out.println(Arrays.deepToString(res.get(i).toArray()));
        }
    }

    //Strivers video - permutation (approach 2)
    private static void striverPermutation(ArrayList<ArrayList<Integer>> res, int []nums, int index){
        if(index==nums.length){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int x : nums){
                temp.add(x);
            }
            res.add(temp);
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            striverPermutation(res,nums,index+1);
            swap(i, index, nums);
        }
    }

    private static void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    static void permutations(String str, String s){

        if(str.length() == 0){
            System.out.println(s);
            return;
        }

        for(int i=0;i<str.length();i++){ 
            char ch = str.charAt(i);
            String dhiraj = str.substring(0, i)+str.substring(i+1);
            permutations(dhiraj, s+ch);
        }
    }

    static ArrayList<String> pString(String str, String s){
        if(str.isEmpty()){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(s);
            return arr;
        }

        ArrayList<String> dhiraj = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String k = str.substring(0, i)+str.substring(i+1);
            dhiraj.addAll(pString(k, s+ch));
        }

        return dhiraj;
    }

    static int permutationsCount(String str, String s){
        if(str.length() == 0){
            return 1;
        }

        int count = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String dhiraj = str.substring(0, i)+str.substring(i+1);
            count = count+permutationsCount(dhiraj, s+ch);
        }
        return count;
    }
}
