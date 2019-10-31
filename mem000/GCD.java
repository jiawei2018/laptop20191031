package mem000;

public class GCD {

    public static int gcd1(int small, int big){
        //System.out.println(a + " <> " + b);
        //System.out.println( b % a);
        if(small == 0){
            return big;
        }
        return gcd1(big % small, small);//tail recursion
    }

    /**
     * 求最大公约数 辗转相除法(欧几里德算法) 例如，求（319，377）： ∵ 319÷377=0（余319）
     * ∴（319，377）=（377，319）； ∵ 377÷319=1（余58） ∴（377，319）=（319，58）； ∵
     * 319÷58=5（余29） ∴ （319，58）=（58，29）； ∵ 58÷29=2（余0） ∴ （58，29）= 29； ∴
     * （319，377）=29。 可以写成右边的格式。
     * 用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。
     * 最后所得的那个最大公约数，就是所有这些数的最大公约数。
     *
     * @param m
     * @param n
     * @return
     */
    public static int GCD(int m, int n) {
        /**
         * 求最大公约数 辗转相除法(欧几里德算法) 例如，求（319，377）： ∵ 319÷377=0（余319）
         * ∴（319，377）=（377，319）； ∵ 377÷319=1（余58） ∴（377，319）=（319，58）； ∵
         * 319÷58=5（余29） ∴ （319，58）=（58，29）； ∵ 58÷29=2（余0） ∴ （58，29）= 29； ∴
         * （319，377）=29。 可以写成右边的格式。
         * 用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。
         * 最后所得的那个最大公约数，就是所有这些数的最大公约数。
         */
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;


    }


    public static void main(String[] args) {
        System.out.println(GCD(88888, 6666));


        //System.out.println( 6 % 12);
    }
}