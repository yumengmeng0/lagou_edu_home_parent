/**
 * @author: ymm
 * @date: 2022/8/24
 * @version: 1.0.0
 * @description:
 */
public class LocalVarTest {

    public static String localFunction(){
        String s = new String("hello");

        return s;
    }

    public static void main(String[] args) {
        localFunction();
    }
}
