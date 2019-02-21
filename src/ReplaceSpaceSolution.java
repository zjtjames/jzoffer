/**
 * created by Zheng Jiateng on 2019/2/21.
 */

public class ReplaceSpaceSolution {
    public String replaceSpace(StringBuffer str) {
        String origin = str.toString();
        String result = origin.replace(" ", "%20");
        return result;
    }
}
