///**
// * created by Zheng Jiateng on 2019/3/14.
// */
//
///**
// * 表示数值的字符串:
// *
// * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
// * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
// */
//public class IsNumeric {
//    private static final String SIGN = "sign";
//    private static final String NUMBER = "number";
//    private static final String POINT = "point";
//    private static final String E = "e";
//    private static final String ILLEGAL = "illegal";
//
//    public boolean isNumeric(char[] str) {
//        int len = str.length;
//        String[] types = new String[len];
//        boolean flagSign = false;
//        boolean flagPoint = false;
//        boolean flagE = true;
//        for (int i = 0; i < len; i++) {
//            types[i] = getType(str[i]);
//        }
//        String type = types[0];
//        if (type != SIGN && type != NUMBER) {
//            return false;
//        }
//        for (int i = 1; i < len; i++) {
//            type = types[i];
//            if ()
//        }
//
//        return true;
//    }
//
//    private String getType(char c) {
//        if (c == 'e' || c == 'E') {
//            return E;
//        }
//        if (c == '+' || c == '-') {
//            return SIGN;
//        }
//        if (c >= '0' && c <= '9') {
//            return NUMBER;
//        }
//        if (c == '.') {
//            return POINT;
//        }
//        return ILLEGAL;
//    }
//}
