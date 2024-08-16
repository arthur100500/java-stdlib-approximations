package generated.java.util.array;

import org.jacodb.approximation.annotation.Approximate;

import java.util.Comparator;

@SuppressWarnings("unused")
@Approximate(java.util.Arrays.class)
public class ArraysImpl {

    private static void _checkArrayNull(Object array) {
        if (array == null)
            throw new NullPointerException();
    }

    private static void _rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        if (fromIndex < 0)
            throw new ArrayIndexOutOfBoundsException();

        if (toIndex > arrayLength)
            throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean _isEmpty(int arrayLength, int fromIndex, int toIndex) {
        return toIndex - fromIndex == 0 || arrayLength == 0;
    }

    private static void _sortIntArray(int[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                int a = array[j];
                int b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static void _sortLongArray(long[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                long a = array[j];
                long b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static void _sortShortArray(short[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                short a = array[j];
                short b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static void _sortCharArray(char[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                char a = array[j];
                char b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static void _sortByteArray(byte[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                byte a = array[j];
                byte b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static void _sortFloatArray(float[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                float a = array[j];
                float b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static void _sortDoubleArray(double[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                double a = array[j];
                double b = array[idxB];
                if (a > b) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    private static <T extends Comparable<? super T>> void _sortArray(T[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                T a = array[j];
                T b = array[idxB];
                if (a.compareTo(b) > 0) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> void _sortArray(T[] array, int fromIndex, int toIndex, Comparator<? super T> comparator) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                T a = array[j];
                T b = array[idxB];
                if (comparator != null && comparator.compare(a, b) > 0 || ((Comparable<? super T>) a).compareTo(b) > 0) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void _sortArray(Object[] array, int fromIndex, int toIndex) {
        if (_isEmpty(array.length, fromIndex, toIndex))
            return;

        int outerLimit = toIndex - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = toIndex - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                Object a = array[j];
                Object b = array[idxB];
                if (((Comparable<? super Object>) a).compareTo(b) > 0) {
                    array[j] = b;
                    array[idxB] = a;
                }
            }
        }
    }

    public static void sort(int[] a) {
        _checkArrayNull(a);
        _sortIntArray(a, 0, a.length);
    }

    public static void sort(int[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortIntArray(a, fromIndex, toIndex);
    }

    public static void sort(long[] a) {
        _checkArrayNull(a);
        _sortLongArray(a, 0, a.length);
    }

    public static void sort(long[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortLongArray(a, fromIndex, toIndex);
    }

    public static void sort(short[] a) {
        _checkArrayNull(a);
        _sortShortArray(a, 0, a.length);
    }

    public static void sort(short[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortShortArray(a, fromIndex, toIndex);
    }

    public static void sort(char[] a) {
        _checkArrayNull(a);
        _sortCharArray(a, 0, a.length);
    }

    public static void sort(char[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortCharArray(a, fromIndex, toIndex);
    }

    public static void sort(byte[] a) {
        _checkArrayNull(a);
        _sortByteArray(a, 0, a.length);
    }

    public static void sort(byte[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortByteArray(a, fromIndex, toIndex);
    }

    public static void sort(float[] a) {
        _checkArrayNull(a);
        _sortFloatArray(a, 0, a.length);
    }

    public static void sort(float[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortFloatArray(a, fromIndex, toIndex);
    }

    public static void sort(double[] a) {
        _checkArrayNull(a);
        _sortDoubleArray(a, 0, a.length);
    }

    public static void sort(double[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortDoubleArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(byte[] a) {
        _checkArrayNull(a);
        _sortByteArray(a, 0, a.length);
    }

    public static void parallelSort(byte[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortByteArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(char[] a) {
        _checkArrayNull(a);
        _sortCharArray(a, 0, a.length);
    }

    public static void parallelSort(char[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortCharArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(short[] a) {
        _checkArrayNull(a);
        _sortShortArray(a, 0, a.length);
    }

    public static void parallelSort(short[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortShortArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(int[] a) {
        _checkArrayNull(a);
        _sortIntArray(a, 0, a.length);
    }

    public static void parallelSort(int[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortIntArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(long[] a) {
        _checkArrayNull(a);
        _sortLongArray(a, 0, a.length);
    }

    public static void parallelSort(long[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortLongArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(float[] a) {
        _checkArrayNull(a);
        _sortFloatArray(a, 0, a.length);
    }

    public static void parallelSort(float[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortFloatArray(a, fromIndex, toIndex);
    }

    public static void parallelSort(double[] a) {
        _checkArrayNull(a);
        _sortDoubleArray(a, 0, a.length);
    }

    public static void parallelSort(double[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortDoubleArray(a, fromIndex, toIndex);
    }

    public static <T extends Comparable<? super T>> void parallelSort(T[] a) {
        _checkArrayNull(a);
        _sortArray(a, 0, a.length);
    }

    public static <T extends Comparable<? super T>> void parallelSort(T[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortArray(a, fromIndex, toIndex);
    }

    public static <T> void parallelSort(T[] a, Comparator<? super T> cmp) {
        _checkArrayNull(a);
        _sortArray(a, 0, a.length, cmp);
    }

    public static <T> void parallelSort(T[] a, int fromIndex, int toIndex, Comparator<? super T> cmp) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortArray(a, fromIndex, toIndex, cmp);
    }

    public static void sort(Object[] a) {
        _checkArrayNull(a);
        _sortArray(a, 0, a.length);
    }

    public static void sort(Object[] a, int fromIndex, int toIndex) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortArray(a, fromIndex, toIndex);
    }

    public static <T> void sort(T[] a, Comparator<? super T> c) {
        _checkArrayNull(a);
        _sortArray(a, 0, a.length, c);
    }

    public static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c) {
        _checkArrayNull(a);
        _rangeCheck(a.length, fromIndex, toIndex);
        _sortArray(a, fromIndex, toIndex, c);
    }
}
