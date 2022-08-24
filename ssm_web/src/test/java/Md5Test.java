import org.example.utils.Md5;

/**
 * @author: ymm
 * @date: 2022/8/24
 * @version: 1.0.0
 * @description:
 */
public class Md5Test {

    public static void main(String[] args) {
        String lagou = null;
        try {
            lagou = Md5.md5("123456", "lagou");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("lagou = " + lagou);

    }
}
