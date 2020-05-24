import org.junit.Test;

import java.util.*;

public class TestSnippet {
    @Test
    public void printArray() {
        String[] array = new String[]{"John", "Mary", "Bob"};
        System.out.println(Arrays.toString(array));

        String[][] deepArray = new String[][]{{"John", "Mary"}, {"Alice", "Bob"}};
        System.out.println(Arrays.deepToString(deepArray));

        double[] doubleArray = {7.0, 9.0, 5.0, 1.0, 3.0};
        System.out.println(Arrays.toString(doubleArray));

        int[] intArray = {7, 9, 5, 1, 3};
        System.out.println(Arrays.toString(intArray));
    }

    @Test
    public void sort() {
        // char[]
        String before = "34925757451";
        char[] charArr = before.toCharArray();
        Arrays.sort(charArr); //오름차순 정렬
        String after = String.valueOf(charArr);
        System.out.println(String.format("before(%s), after(%s)", before, after));

        // List<String>
        List<String> list = Arrays.asList(
                "IB00021",
                "AC00001",
                "CC00011",
                "IB00003",
                "AC10001",
                "AD00004"
        );
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.reverse(list);
        System.out.println(list.toString());
    }

    @Test
    public void convert() {
        int num = 15;
        String numStr = Integer.toString(num);// 숫자 -> 문자열
        int strNum = Integer.parseInt(numStr);// 문자열 -> 숫자
        String strArray = Integer.toBinaryString(strNum);// 숫자 -> 이진수(문자열)
        System.out.println(strArray);
    }

    @Test
    public void ComparatorTest() {
        List<String> list = Arrays.asList("z", "a", "A", "c");
        Collections.sort(list); // 대소문자 구별하여 오름차순 정렬
        System.out.println(list); //[A, a, c, z]
        Collections.sort(list, Collections.reverseOrder()); //[z, c, a, A]
        System.out.println(list);
    }
}
