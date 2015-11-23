package ru.zen.practice.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by r.korobeynikov, 23.11.15
 */
public class BinarySearchTest {

    @Test
    public void oneElementReturnItself() {
        assertEquals(BinarySearch.find(new Integer[]{1}, 1), 0);
    }

    @Test
    public void testTwoElements() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3}, 3), 1);
    }

    @Test
    public void test2ElementsAbsent() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3}, 7), -1);
    }

    @Test
    public void test4ElementsAbsent() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 7), -1);
    }

    @Test
    public void test4Elements0Position() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 1), 0);
    }

    @Test
    public void test4Elements1Position() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 3), 1);
    }

    public void test4Elements2Position() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 6), 2);
    }

    public void test4Elements3Position() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 11), 3);
    }

    public void test4ElementsLess0() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 0), -1);
    }

    public void test4ElementsLess1() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 2), -1);
    }

    public void test4ElementsMore3() {
        assertEquals(BinarySearch.find(new Integer[]{1, 3, 6, 11}, 12), -1);
    }

}
