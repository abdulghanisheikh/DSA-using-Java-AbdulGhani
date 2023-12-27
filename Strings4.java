class Strings4 {
    public static void main(String[] args) {
        String str = "Abdul";
        
// -----Case Conversion Methods--------------------------------

        // toUpperCase() method
        // System.out.println(str.toUpperCase());

        // toLowerCase() method
        // System.out.println(str.toLowerCase());


//------Type Casting Methods------------------------------------

        // valueOf() method  (static method hai)
        int a = 10, b = 20;
        System.out.println(a + b);   // addition
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        System.out.println(s1 + s2);  // concatinate
        String s3 = s1 + s2;
        

        // toCharArray() method
        char c[] = s3.toCharArray();
        System.out.println(c);

    }
}