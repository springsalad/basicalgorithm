public class Solutions {



    // A length may not be heapsize
    public void maxHeapify(int [] A, int heapSize, int arrayIndex) {

        int HeapLeft = Ai2Hi(arrayIndex) * 2;
        int HeapRight = Ai2Hi(arrayIndex) * 2 +1;

        int ALeft = Hi2Ai(HeapLeft);
        int ARight = Hi2Ai(HeapRight);

        int largest = arrayIndex;

        if ( ALeft < heapSize && A[ALeft] > A [largest] ) {
            largest =  ALeft;
        }
        if (ARight < heapSize && A[ARight] > A [largest]) {
            largest = ARight;
        }

        if (largest != arrayIndex) {
            switchNumber(A, largest, arrayIndex);
            maxHeapify(A, heapSize, largest);
        }

    }

    public void maxHeapifyUsingLoog(int [] A, int heapSize, int arrayIndex) {

        // init
        int ai = arrayIndex;


        while (true) {
            int HeapLeft = Ai2Hi(ai) * 2;
            int HeapRight = Ai2Hi(ai) * 2 +1;

            int ALeft = Hi2Ai(HeapLeft);
            int ARight = Hi2Ai(HeapRight);

            int largest = ai;

            if ( ALeft < heapSize && A[ALeft] > A [largest] ) {
                largest =  ALeft;
            }
            if (ARight < heapSize && A[ARight] > A [largest]) {
                largest = ARight;
            }

            if (largest == ai) {
                break;
            } else {
                switchNumber(A, largest, ai);
                //push and reset for new round
                ai = largest;
                continue;
            }



        }

    }

    public void heapSort(int [] A){
        //first build heap
        buildHeap(A);

        printArray(A);

        // then sort it
        for ( int loop = 0; loop < A.length; loop ++ ) {
            switchNumber(A, 0, A.length -1 -loop);
            maxHeapify(A, A.length - 1 -loop, 0);
        }

    }

    private void buildHeap(int [] A) {
        int length = A.length;

        int leafIndex = length /2 +1;
        int ALeafIndex = Hi2Ai(leafIndex);
        System.out.println("build heap debug ====");
        System.out.println("ALeafIndex :" +  ALeafIndex);

        for (int loop = ALeafIndex - 1; loop >= 0; loop --) {

            maxHeapify(A, length, loop);

            printArray(A);
        }

    }


    private void switchNumber(int [] A, int one, int other ) {
        int temp = A[one];
        A[one] = A[other];
        A[other] = temp;
    }

    private  int Ai2Hi( int arrayIndex) {
        return arrayIndex + 1;
    }

    private int Hi2Ai( int HeapIndex) {
        return  HeapIndex -1;
    }

    private void printArray(int [] A) {
        for (int n: A ) {
            System.out.print( n + ",");
        }

        System.out.println();
    }

    public static void testOne () {
        int [] A = { 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        Solutions solutions = new Solutions();
        solutions.maxHeapify(A, A.length, 2);

        solutions.printArray(A);
    }

    public static void testTwo() {
        int [] A = { 27, 17, 2, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        Solutions solutions = new Solutions();
        solutions.maxHeapifyUsingLoog(A, A.length, 2);

        solutions.printArray(A);
    }

    public static void testThree() {
        int [] A = { 27, 17, 2, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        Solutions solutions = new Solutions();
        solutions.heapSort(A);

        solutions.printArray(A);
    }

    public static void main (String ...args) {
        testOne();
        testTwo();
        testThree();
    }
}
