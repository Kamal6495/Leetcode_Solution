class Solution {
  public int findKthPositive(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
   
    while (low <= high) {
      int mid = low + ((high - low) / 2);
      int missing=arr[mid]-(mid+1);
      if (missing< k)
        low = mid + 1;
      else
        high = mid - 1;
    }

   // return arr[high] + k - missing;
/*
*arr[high]=lower neighbor of missing number but if low=0 then high=-1 so ARRAYINDEXOUTOFBOUNDEXCEPTION
*as we know missing=arr[high]-(high+1);eq1 for low neighbor missing values
*return arr[high] + k - missing; eq2
*putting value of missing from eq1 to eq2 
*arr[high]+k-(arr[high]-(high+1))
*arr[high]+k-arr[high]+high+1
*k+high+1// this will be return also removed dependency of array element ARRAYINDEXOUTOFBOUNDEXCEPTION
*/
return high+k+1;

  }
}