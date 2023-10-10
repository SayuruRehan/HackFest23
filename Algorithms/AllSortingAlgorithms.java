public class AllSortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 5, 1, 2, 8 };
        print(arr);

        bubbleSort(arr);
        selectionSort(arr);
        insertionSort(arr);
        mergeSort(arr,0,arr.length-1);
        quickSort(arr, 0, arr.length-1);
        System.out.println();
        print(arr);

    }

    private static void quickSort(int[] arr, int low, int high){
    /************************************************************ 
                Time Complexity                  Space Complexity
        Best	  Average	    Worst                   Worst
    Ω(nlog(n))	θ(n log(n))	    O(n^2)	                O(n)
    *************************************************************/
        if(low<high){
            int partition = qs(arr,low,high);
            quickSort(arr, low, partition-1 );
            quickSort(arr, partition+1, high);
        }
    }

    private static int qs(int[] arr, int low, int high){
        int i=low, j=high, pivot = arr[low];
        while(i<j){
            while(arr[i]<=pivot && i<high) i++;
            while(arr[j]>pivot && j>low) j--;
            if(i<j) swap(arr,i,j);
        }
        swap(arr, low, j);
        return j;
    }

    private static void mergeSort(int []arr, int low, int high){
    /************************************************************ 
                Time Complexity                  Space Complexity
        Best	  Average	      Worst                Worst
    Ω(nlog(n))	θ(n log(n))	    O(n log(n))	            O(n)
    *************************************************************/
        if(low==high) return;
        int mid = low+(high-low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }

    private static void merge(int []arr, int low, int mid, int high){
        int []temp = new int[high-low+1];
        int i=0, left = low, right = mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[i] = arr[left];
                left++;
            }else{
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        while(left<=mid){
            temp[i] = arr[left];
            i++; left++;
        }

        while(right<=high){
            temp[i] = arr[right];
            i++; right++;
        }

        for(int k=low;k<=high;k++){
            arr[k] = temp[k-low];
        }
    }

    private static void insertionSort(int[] arr){
    /************************************************************ 
                Time Complexity                  Space Complexity
        Best	  Average	    Worst                   Worst
        Ω(n)	  θ(n^2)	   O(n^2)                  	O(1)
    *************************************************************/

        //shift element from unsorted array side to original position in sorted array
        int n = arr.length;
        //arr[0] is already considered as sorted
        for(int i=1;i<n;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                swap(arr, j, j-1);
                j--;
            }
        }
    }

    private static void selectionSort(int []arr){
    /************************************************************ 
                Time Complexity                  Space Complexity
        Best	  Average	    Worst                   Worst
       Ω(n^2)	  θ(n^2)    	O(n^2)	                O(1)
    *************************************************************/

        //find minimum element and swap with first
        int n = arr.length;
        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }

            if(minIndex!=i){
                swap(arr, i, minIndex);
            }
        }
    }

    private static void bubbleSort(int[] arr) {
    /************************************************************ 
                Time Complexity                  Space Complexity
        Best	  Average	    Worst                   Worst
        Ω(n)	  θ(n^2)	   O(n^2)                  	O(1)
    *************************************************************/
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void print(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

