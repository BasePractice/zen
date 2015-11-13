package ru.zen.practice.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class FlatTriangularMatrixTest {
    private static final int COUNT = 200;
    private TriangularMatrix triangularMatrix;
    private FlatTriangularMatrix flatTriangularMatrix;

    @Before
    public void setUp() throws Exception {
        triangularMatrix = new TriangularMatrix(COUNT);
        flatTriangularMatrix = new FlatTriangularMatrix(COUNT);
        fill(triangularMatrix, flatTriangularMatrix, COUNT);
    }

    private static void fill(TriangularMatrix triangularMatrix, FlatTriangularMatrix flatTriangularMatrix, int count) {
        final Random random = new Random(new Date().getTime());
        for (int i = 0; i < count; ++i) {
            for (int j = i; j < count; ++j) {
                int value = random.nextInt();
                triangularMatrix.put(i, j, value);
                flatTriangularMatrix.put(i, j, value);
            }
        }
    }

    @Test
    public void testCompare() throws Exception {
        for (int i = 0; i < COUNT; ++i) {
            for (int j = i; j < COUNT; ++j) {
                assertEquals(triangularMatrix.get(i, j), flatTriangularMatrix.get(i, j));
            }
        }
    }

    private static final class TriangularMatrix {
        private final Number[][] data;

        public TriangularMatrix(int count) {
            this.data = new Number[count][count];
        }

        public void put(int row, int col, Number number) {
            this.data[row][col] = number;
        }

        public Number get(int row, int col) {
            return data[row][col];
        }

    }
}