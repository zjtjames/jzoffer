/**
 * created by Zheng Jiateng on 2019/2/21.
 */

/**
 * 替换空格:replace
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String origin = str.toString();
        String result = origin.replace(" ", "%20");
        return result;
    }
}
