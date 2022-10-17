import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class test {

    public static void main(String[] args) {
        System.out.println(8>>1);
        ArrayList<Integer> al = new ArrayList();
        al.add(123);
        al.add(123);
        for (int i:
        al){
            System.out.println(i);
        }
    }


    public void test() {
        getSomething();
    }

    public void getSomething() throws IllegalArgumentException {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
//            e.printStackTrace();
            throw new IllegalArgumentException("参数不合法");
        }

        System.out.println("xxxxxxxx");
    }


}

class MyException extends Exception {
    static final long serialVersionUID = -70348971907L;
    public MyException(){
    }
    public MyException(String msg){
        super(msg);
    }
}