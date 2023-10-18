import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        // subsetGeneration(nums);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset(ans,new ArrayList<>(),nums,0,3);

        for(int i=0;i<ans.size();i++){
            System.out.println(Arrays.deepToString(ans.get(i).toArray()));
        }
    }

    private static void subset(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int []nums,int start,int size){
        ans.add(new ArrayList<>(curr));

        for(int i=start;i<size;i++){
            curr.add(nums[i]);
            subset(ans,curr,nums,i+1,size);
            curr.remove(curr.size()-1);
        }
    }

    private static void subsetGeneration(int[] nums){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();  //power set
        ans.add(new ArrayList<>());

        for(int num : nums){
            int size = ans.size();
            for(int i=0;i<size;i++){
                ArrayList<Integer> temp = new ArrayList<>(ans.get(i));
                temp.add(num);
                ans.add(temp);
            }
        }

        for(int i=0;i<ans.size();i++){
            System.out.println(Arrays.deepToString(ans.get(i).toArray()));
        }
    }
}
