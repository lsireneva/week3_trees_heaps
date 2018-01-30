import java.util.ArrayList;

public class MatrixSearch {

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        if (a.size() == 0 || a.get(0).size() == 0) {
            return 0;
        }
        int rows = a.size(), cols = a.get(0).size(), left = 0, right = rows * cols - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int i = middle / cols;
            int j = middle % cols;
            int middle_value = a.get(i).get(j);
            if (middle_value == b) {
                return 1;
            } else if (middle_value < b) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return 0;
    }
}
