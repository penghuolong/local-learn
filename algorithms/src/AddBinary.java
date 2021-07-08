public class AddBinary {
    public String addBinary(String a, String b) {
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int temp = 0;
        StringBuilder builder = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || temp > 0) {
            char c1 = '0';
            char c2 = '0';

            if (len1 >= 0) {
                c1 = a.charAt(len1);
            }
            if (len2 >= 0) {
                c2 = b.charAt(len2);
            }
            int s = c1 + c2 - '0' - '0' + temp;
            int value = s % 2;
            temp = s / 2;
            builder.append(value);
            len1--;
            len2--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("1");

    }
}
