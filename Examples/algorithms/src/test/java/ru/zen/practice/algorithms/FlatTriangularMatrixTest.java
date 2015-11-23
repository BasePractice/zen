package ru.zen.practice.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class FlatTriangularMatrixTest {
    private static final int COUNT = 10;
    private TriangularMatrix triangularMatrix;
    private FlatTriangularMatrix flatTriangularMatrix;
    private FlatTriangularMatrix2 flatTriangularMatrix2;

    @Before
    public void setUp() throws Exception {
        triangularMatrix = new TriangularMatrix(COUNT);
        flatTriangularMatrix = new FlatTriangularMatrix(COUNT);
        flatTriangularMatrix2 = new FlatTriangularMatrix2(COUNT);
    }

    private static void fill(int count, TriangularMatrix triangularMatrix, AbstractMatrix2D... matrixes) {
//        final Random random = new Random(new Date().getTime());
        BigInteger it = new BigInteger("0");
        for (int i = 0; i < count; ++i) {
            for (int j = i; j < count; ++j) {
                //int value = random.nextInt();
                triangularMatrix.put(i, j, it.longValue());
                for (AbstractMatrix2D matrix : matrixes) {
                    matrix.put(i, j, it.longValue());
                }
                it = it.add(BigInteger.ONE);
            }
        }
    }

    @Test
    public void testCompare() throws Exception {
        fill(COUNT, triangularMatrix, flatTriangularMatrix);
        for (int i = 0; i < COUNT; ++i) {
            for (int j = i; j < COUNT; ++j) {
                assertEquals(triangularMatrix.get(i, j), flatTriangularMatrix.get(i, j));
            }
        }
    }

    @Test
    public void testCompare2() throws Exception {
        fill(COUNT, triangularMatrix, flatTriangularMatrix2);
        for (int i = 0; i < COUNT; ++i) {
            for (int j = i; j < COUNT; ++j) {
                assertEquals(triangularMatrix.get(i, j), flatTriangularMatrix2.get(i, j));
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