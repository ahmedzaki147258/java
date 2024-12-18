class Program1 {
    public static void main(String[] args) {
        int min, max, arr[] = new int[1000];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random() * 9999999);
        }

        min = max = arr.length>0 ? arr[0]:0;
        long start = System.nanoTime();
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min) min=arr[i];
            if(arr[i] > max) max=arr[i];
        }
        long end = System.nanoTime();

        System.out.println("Task1:");
        System.out.println("Min: "+min);
        System.out.println("Max: "+max);
        System.out.println("Time: " + (end-start));

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }

        Program1 p = new Program1();
        start = System.nanoTime();
        int minIdx = p.binarySearch(arr, 0, arr.length-1, min);
        int maxIdx = p.binarySearch(arr, 0, arr.length-1, max);
        end = System.nanoTime();

        System.out.println("\nTask2:");
        System.out.println("Min Index: "+minIdx);
        System.out.println("Max Index: "+maxIdx);
        System.out.println("Time: " + (end-start));
    }

    int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if(arr[mid] == value) return mid;
        else if(arr[mid] < value) return binarySearch(arr, mid+1, right, value);
        else if(arr[mid] > value) return binarySearch(arr, left, mid-1, value);
        return -1;
    }
}