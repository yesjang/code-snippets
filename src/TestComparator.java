import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
//https://stackoverflow.com/questions/4258700/collections-sort-with-multiple-fields/20093589

    public class Student {
        String name;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", length=" + length +
                    ", score=" + score +
                    '}';
        }

        public Student(String name, Double length, Integer score) {
            this.name = name;
            this.length = length;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getLength() {
            return length;
        }

        public void setLength(Double length) {
            this.length = length;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        Double length;
        Integer score;


    }

    @Test
    public void test() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Jang", 8.0, 70));
        students.add(new Student("lee", 8.0, 60));
        students.add(new Student("Jang", 8.0, 90));
        students.add(new Student("Jang", 7.0, 80));
        students.add(new Student("lee", 7.0, 90));
        students.add(new Student("Jang", 7.0, 80));

        Collections.sort(students, Comparator.comparing(Student::getLength)
                .thenComparing(Student::getName)
                .thenComparing(Student::getScore));

        System.out.println(students.toString());
    }

    @Test
    public void test2() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jang", 8.0, 70));
        students.add(new Student("lee", 8.0, 60));
        students.add(new Student("Jang", 8.0, 90));
        students.add(new Student("Jang", 7.0, 80));
        students.add(new Student("lee", 7.0, 90));
        students.add(new Student("Jang", 7.0, 80));

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student p1, Student p2) {
                int lengthCmp = p1.length.compareTo(p2.length);
                if (lengthCmp != 0) {
                    return lengthCmp;
                }

                int nameCmp = p1.name.compareTo(p2.name);
                if (nameCmp != 0) {
                    return nameCmp;
                }

                int scoreCmp = p1.score.compareTo(p2.score);
                if (scoreCmp != 0) {
                    return scoreCmp;
                }

                return p1.score.compareTo(p2.score);
            }
        });

        System.out.println(students.toString());

    }
}
