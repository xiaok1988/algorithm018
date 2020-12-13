初级排序算法Java实现

1. 选择排序

   ```
   private int[] selectionSort(int[] arr) {
       int len = arr.length;
       int minIndex, temp;
       for(int i = 0; i < len - 1; i++) {
           minIndex = i;
           for(int j = i + 1; j < len; j++) {
               if(arr[j] < arr[minIndex]) {     
                   minIndex = j;                
               }
           }
           temp = arr[i];
           arr[i] = arr[minIndex];
           arr[minIndex] = temp;
       }
       return arr;
   }
   ```

2. 插入排序

   ```
   private int[] insertionSort(int[] arr) {
       int len = arr.length;
       int preIndex, current;
       for(int i = 1; i < len; i++) {
           preIndex = i - 1;
           current = arr[i];
           while(preIndex >= 0 && arr[preIndex] > current) {
               arr[preIndex + 1] = arr[preIndex];
               preIndex--;
           }
           arr[preIndex + 1] = current;
       }
       return arr;
   }
   ```

3. 冒泡排序

   ```
   private int[] bubbleSort(int[] arr) {
       int len = arr.length;
       for(int i = 0; i < len - 1; i++) {
           for(int j = 0; j < len - 1 - i; j++) {
               if(arr[j] > arr[j+1]) {        
                   int temp = arr[j+1];        
                   arr[j+1] = arr[j];
                   arr[j] = temp;
               }
           }
       }
       return arr;
   }
   ```

