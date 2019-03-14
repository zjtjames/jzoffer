/**
 * Created by Zheng Jiateng on 2019/3/14.
 */

/**
 * 正则表达式匹配：注意 .* 可以匹配任何字符串 如abcde 而不仅是aaaaa
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match__ {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // str到尾 pattern到尾 匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        // pattern到尾 str没到尾 匹配失败   str到尾 pattern没到尾是可以的 只要pattern有第二个字符，且为*就可以
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 如果上面两个if过了 说明pattern一定还没到尾 patternIndex至多为pattern.length-1
        // pattern的第二个字符是*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //如果str第一个字符跟pattern第一个字符匹配，可以有2种匹配方式：
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] || strIndex!=str.length && pattern[patternIndex]=='.') {
                // 利用||的短路特点 两条路有一条走通都返回true
                return matchCore(str, strIndex + 1, pattern, patternIndex) // 匹配1个，再匹配str中的下一个
                        || matchCore(str, strIndex, pattern, patternIndex + 2);// pattern后移2，视为x*匹配0个字符
            } else { //如果str已经到尾，或str第一个字符跟pattern第一个字符不匹配，则pattern后移2个字符(即把a*视为0个a)，继续匹配
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 第三个if过了 说明要不然pattern没有第二个字符了 要不然有第二个字符但不是*
        // pattern第2个不是*，且str第1个跟pattern第1个匹配，则都后移1位，否则直接返回false
        if (strIndex != str.length && pattern[patternIndex] == str[strIndex] ||
                strIndex != str.length && pattern[patternIndex] == '.') {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        } else {
            return false;
        }

    }
}
