import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class addTest {

    add obj = new add();

    // ---------- ADDITION TESTS ----------

    @Test
    void addPositiveNumbers() {
        assertEquals(5, obj.addNumbers(2,3));
    }

    @Test
    void addWithZero() {
        assertEquals(7, obj.addNumbers(7,0));
    }

    @Test
    void addTwoZeros() {
        assertEquals(0, obj.addNumbers(0,0));
    }

    @Test
    void addNegativeNumbers() {
        assertEquals(-5, obj.addNumbers(-2,-3));
    }

    @Test
    void addPositiveAndNegative() {
        assertEquals(1, obj.addNumbers(3,-2));
    }

    @Test
    void addLargeNumbers() {
        assertEquals(2000000, obj.addNumbers(1000000,1000000));
    }

    // @Test
    // void failDemo() {
    //     assertEquals(100, obj.addNumbers(2,3));
    // }


    // ---------- SUBTRACTION TESTS ----------

    @Test
    void subPositiveNumbers() {
        assertEquals(2, obj.subNumbers(5,3));
    }

    @Test
    void subResultZero() {
        assertEquals(0, obj.subNumbers(4,4));
    }

    @Test
    void subWithZero() {
        assertEquals(9, obj.subNumbers(9,0));
    }

    @Test
    void subNegativeNumbers() {
        assertEquals(-1, obj.subNumbers(-3,-2));
    }

    @Test
    void subPositiveMinusNegative() {
        assertEquals(8, obj.subNumbers(5,-3));
    }

    @Test
    void subNegativeMinusPositive() {
        assertEquals(-8, obj.subNumbers(-5,3));
    }
}
