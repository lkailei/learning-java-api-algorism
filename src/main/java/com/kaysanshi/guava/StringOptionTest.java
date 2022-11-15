package com.kaysanshi.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.Arrays;

/**
 * guava字符粗操作
 *
 */
public class StringOptionTest {
    public static void main(String[] args) {
        StringOptionTest test = new StringOptionTest();
        test.testJoiner();
        test.testSplitter();
        test.testCharMatcher();
    }
    // joiner
    private void testJoiner(){
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1,2,3,4,5,null,6)));
    }

    /**
     * spiltter
     */
    private void testSplitter(){
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }

    /**
     *
     */
    private void testCharMatcher(){
        System.out.println(CharMatcher.digit().retainFrom("mahesh123")); // only the digits 123
        System.out.println(CharMatcher.whitespace().trimAndCollapseFrom("     Mahesh     Parashar ", ' '));// Mahesh Parashar
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.javaDigit().replaceFrom("mahesh123", "*")); // star out all digits mahesh***
        System.out.println(CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom("mahesh123"));// mahesh123
        // eliminate all characters that aren't digits or lowercase
    }






}
