package com.common.utils;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-4-25
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */

public class HashHandler {

    /**
     * ELF算法
     */
    public static int ELFHash(String str) {
        int hash = 0;
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            //hash左移4位，把当前字符ASCII存入hash低四位。
            hash = (hash << 4) + str.charAt(i);
            //如果最高的四位不为0，则说明字符多余7个，现在正在存第8个字符，如果不处理，再加下一个字符时，第一个字符会被移出，因此要有如下处理。
            //该处理，如果对于字符串(a-z 或者A-Z)就会仅仅影响5-8位，否则会影响5-31位，因为C语言使用的算数移位
            //因为1-4位刚刚存储了新加入到字符，所以不能>>28
            if ((x = (int) (hash & 0xF0000000L)) != 0) {
                hash ^= (x >> 24);
                //上面这行代码并不会对X有影响，本身X和hash的高4位相同，下面这行代码&~即对28-31(高4位)位清零。
                hash &= ~x;
            }
        }
        //返回一个符号位为0的数，即丢弃最高位，以免函数外产生影响。(我们可以考虑，如果只有字符，符号位不可能为负)
        return (hash & 0x7FFFFFFF);
    }

    public static void main(String[] args) {
        String str = "大连大商电字商务大连大商电字商务大连大商电字商务大连大商电字商务大连大商电字商务大连大商电字商务";
        System.out.println (HashHandler.ELFHash (str));
        
    }
}
