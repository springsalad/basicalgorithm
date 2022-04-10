public class Solution {


    // recursive quick sort, ascending
    void sort(int[] number){
        partSort(number, 0, number.length -1);
    }



    // range is closed in both end,
    void partition(int start, int end, int[] number) {

        if (start >= end) {
            return;
        } else if (end - start == 1) {
            if (number[start] <= number[end]) {
                // do nothing
            } else {
                switchNumber(start, end, number);
            }

        } else
        {
            // end - start >1 , let partition actually


            int middleNumber = number[end];
            int indexLeft = -1;
            int indexRight = -1;
            boolean leftFrom = true;

            for ( int i = start;i <=end  ; i ++ ) {
                if (leftFrom) {
                    if ( number [ start + indexLeft + 1] <= middleNumber ) {
                        // corrent already
                        indexLeft ++ ;

                    }  else {
                        indexRight ++;
                        switchNumber(start + indexLeft + 1, end - indexRight, number);
                        leftFrom = false; //
                    }
                } else  {
                    // right from
                    if (number[end - indexRight - 1 ] > middleNumber) {
                        // correct already
                        indexRight ++;
                    } else {
                        indexLeft ++;
                        switchNumber(start + indexLeft, end - indexRight -1 , number);
                        leftFrom = true;
                    }
                }

            }

            //debug
            System.out.println("left:" + indexLeft  + " right:" + indexRight);
            // let us partition

            if (leftFrom) {
                partition(start, start + indexLeft -1  , number);
                partition(end - indexRight , end, number);

            } else {
                partition(start, start + indexLeft  , number);
                partition(end - indexRight + 1 , end, number);

            }

        }


    }



    void partSort(int [] number, int start, int end) {

        if (start >= end) {
            return;
        }

        int left = start -1;

        for (int i = start; i < end; i ++) {
            if ( number [i] <= number [end]) {
                left ++;
                switchNumber(start + left, i, number);
            }
        }
        switchNumber(start + left +1, end, number);

        partSort(number, start, start + left );
        partSort(number, start + left + 2 , end);

    }
    void switchNumber(int left, int right, int[] number) {
        int temp = number[left];
        number[left] = number[right];
        number[right] = temp;
    }

    public static void testOne() {
        int [] testArray = { 4,5,6,7,1,2,3,4,4,4,5,5,6,6,45,56,334,223};
        Solution solution = new Solution();
        solution.sort(testArray);
        printArray(testArray);

    }


    public static void main(String ... args) {
       testOne();
       testTwo();
       testThree();
    }

    public static void printArray(int[] numbers){
        for (int number: numbers
             ) {

            System.out.print(number + ", ");

        }
        System.out.println();
    }

    public static void testTwo() {
        int [] testArray = { 4};
        Solution solution = new Solution();
        solution.sort(testArray);
        printArray(testArray);

    }

    public static void testThree() {
        int [] testArray = { 4, 2};
        Solution solution = new Solution();
        solution.sort(testArray);
        printArray(testArray);

    }
}
