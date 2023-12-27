class StringBuffers {

    public static void main(String[] args) {
        // StringBuffer name = new StringBuffer("Abdul Ghani");
        StringBuffer name = new StringBuffer();

        // System.out.println(name.equals(name2));
        // System.out.println(name2);
        // System.out.println(name.indexOf("a"));
        // System.out.println(name.lastIndexOf("a"));
        // // System.out.println(name.insert(5, "lah"));
        // System.out.println(name.replace(0, 5, "Mohd"));
        // System.out.println(name.subSequence(0, 10));
        // System.out.println(name.substring(4));
        // name.ensureCapacity(200);
        // System.out.println(name.capacity());
        // name.setCharAt(7, 'o');
        // System.out.println(name);

        name.ensureCapacity(100);
        name.append("Ghani");
        name.trimToSize();
        System.out.println(name.capacity());
    }
}