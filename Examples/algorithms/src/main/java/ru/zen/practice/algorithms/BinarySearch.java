package ru.zen.practice.algorithms;

/**
 * Created by r.korobeynikov, 23.11.15
 */
public class BinarySearch {

    static int find(Integer[] elements, int elementToFind) {
        int min = 0;
        int max = elements.length - 1;
        int position = 0;
        while (max > min) {
            position = (min + max) / 2;
            if (elements[position] == elementToFind) {
                return position;
            }
            if (elements[position] > elementToFind) {
                if (max > position)
                    max = position;
                else {
                    max--;
                    position--;
                }
            } else {
                if (min < position) {
                    min = position;
                } else {
                    min++;
                    position++;
                }
            }
        }
        if (elements[position] == elementToFind)
            return position;
        else return -1;
    }

}
