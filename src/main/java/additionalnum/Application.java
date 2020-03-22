package additionalnum;

public class Application {
    public static void main(String[] args) {

//        int A[] = {3,2,1,2,1,7};
//        int A[] = {2,2,2,2,0};
        int A[] = {19,15,45,27,48,38,28,13,34,22,36,20,24,1,36,1,34,29,38,14,34,10,26,17,48,48,10,28,16,48,46,29,36,34,17,45,44,16,37,0,40,28,47,18,31,16,39,30,49,0};

        try {
            Solution solution = new Solution();
            int a = solution.minIncrementForUnique(A);
            System.out.println(a);
        } catch (Exception exp) {
            exp.printStackTrace();
        }


    }
}
