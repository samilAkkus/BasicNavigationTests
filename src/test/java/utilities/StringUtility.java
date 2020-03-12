package utilities;

public class StringUtility {

    public static void checkEquality(String expected, String actual){

        if(expected.equals(actual)){

            System.out.println("TEST PASSED");
        }else {

            System.out.println("TEST FAILED");
        }
    }
}
