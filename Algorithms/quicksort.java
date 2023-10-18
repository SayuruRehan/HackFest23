//Java code for quicksort
private int partition(int arr[], int begin, int end) {
    int p = arr[end];
    int i = (begin-1);
//Loop
    for (int j = begin; j < end; j++) {
        if (arr[j] <= p) {
            i++;

            int swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }
//Swapping 
    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
}
