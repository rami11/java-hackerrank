package interview.arrays.leftrotation;

public class LeftRotation {

    public int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        int index = 0;
        for (int i = d; i < a.length; i++) {
            result[index++] = a[i];
        }
        for (int i = 0; i < d; i++) {
            result[index++] = a[i];
        }
        return result;
    }
}
