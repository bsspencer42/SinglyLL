public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000021));
    }
    public static boolean isPalindrome(int x){
        String stringX = String.valueOf(x);
        return innerPalindrome(stringX);
    }
    public static boolean innerPalindrome(String x){
        System.out.println(x);
        if (x.length() == 1)
            return true;
        if (x.length() < 3) {
            return x.charAt(0) == x.charAt(x.length()-1);
        }
        String innerX = x.substring(1,x.length()-1);
        return x.charAt(0) == x.charAt(x.length()-1) && innerPalindrome(innerX);
    }
}
