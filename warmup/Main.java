package warmup;

public class Main {
 int sum;
 int a = 1;
int b = 2;
    public static void main(String[] args) {
        int sum = 0;
        int a = 1;
        int b = 2;


        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
 
        while (b <= 4_000_000) {
            if (b % 2 == 0) {
                sum += b;
            }

            int next = a + b;
            a = b;
            b = next;
        }

        System.out.println(sum);

    }
}


