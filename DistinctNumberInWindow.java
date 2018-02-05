import java.util.*;

public class DistinctNumberInWindow {


    public static void main (String[] args){

        ArrayList<Integer> arr = new ArrayList<>();//{1, 2, 1, 3, 4, 2, 3};
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(4);
        arr.add(2);
        arr.add(3);
        int k = 3;
        System.out.println(arr.toString());

        System.out.println(dNums(arr, k).toString());

    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> arr, int k) {

        ArrayList<Integer> result = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int distinct_count = 0;

        for (int i = 0; i < k; i++)
        {
            if (map.get(arr.get(i)) == null)
            {
                map.put(arr.get(i), 1);
                distinct_count++;
            }
            else
            {
                int count = map.get(arr.get(i));
                map.put(arr.get(i), count+1);
            }
        }

        result.add(distinct_count);

        for (int i = k; i < arr.size(); i++)
        {
            if (map.get(arr.get(i-k)) == 1)
            {
                map.remove(arr.get(i-k));
                distinct_count--;
            }
            else
            {
                int count = map.get(arr.get(i-k));
                map.put(arr.get(i-k), count-1);
            }

            if (map.get(arr.get(i)) == null)
            {
                map.put(arr.get(i), 1);
                distinct_count++;
            }
            else
            {
                int count = map.get(arr.get(i));
                map.put(arr.get(i), count+1);
            }

            result.add(distinct_count);


        }
        return result;
    }

}
