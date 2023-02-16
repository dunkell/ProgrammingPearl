public class test {


    public static void main(String[] args) {


        String s = null;
        if(s.isEmpty())
            System.out.println(1);


        //te(s);







    }


    public static void te(String s){
        s = s.replaceAll("\\s","");
        System.out.println(s);
    }
}
