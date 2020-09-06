package interview.arrays.leftrotation;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LeftRotationTest {

    @Test
    public void rotLeftTest() {
        LeftRotation leftRotation = new LeftRotation();

        int[] array = {1, 2, 3, 4, 5};
        int[] result = {5, 1, 2, 3, 4};
        assertArrayEquals(result, leftRotation.rotLeft(array, 4));
    }
}