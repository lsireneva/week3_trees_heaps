public class Solution {
    
    public int sqrt(int a) {

        long i = 0, j = a / 2 + 1;

        while (i <= j) {
            long middle = (i + j) / 2;
            if (middle * middle == a)
                return (int) middle;

            if (middle *  middle < a)
                i = middle + 1;
            else
                j = middle - 1;
        }
        return (int) j;
    }
}