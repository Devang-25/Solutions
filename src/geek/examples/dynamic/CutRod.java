package geek.examples.dynamic;

public class CutRod {
    public static void main(String[] args) {
        int price[] = {0, 1, 5, 8, 9, 10, 17, 17, 20};
        int maxPrice[] = new int[price.length];
        maxPrice[0] = 0;
        for (int i = 1; i < maxPrice.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                System.out.println("j=" + (price[j] + maxPrice[i - j]));
                max = Math.max(max, price[j] + maxPrice[i - j]);
            }
            maxPrice[i] = max;
            System.out.println("MaxPrice[" + i + "]=" + max);
        }
        System.out.println(maxPrice[maxPrice.length - 1]);

    }
}
