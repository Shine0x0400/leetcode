package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-25
 */
public class Leet44_WildcardMatching {

    // http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, star = -1, ss = 0;

        while (si < s.length()) {

            if (pi < p.length()) {
                if (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi)) {
                    si++;
                    pi++;
                    continue;
                }

                if (p.charAt(pi) == '*') {
                    star = pi++;
                    ss = si;
                    continue;
                }
            }

            if (star >= 0) {
                pi = star + 1;
                si = ++ss;
                continue;
            }

            return false;
        }

        while (pi < p.length()) {
            if (p.charAt(pi) != '*') {
                return false;
            }
            pi++;
        }

        return true;
    }


//    /**
//     * Time Limit Exceeded:
//     * "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
//     * "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
//     */
//    public boolean isMatch(String s, String p) {
//
//        boolean firstMatch = s.length() == 0
//                ? (p.length() == 0 || p.charAt(0) == '*')
//                : p.length() != 0 && (p.charAt(0) == '?' || p.charAt(0) == '*' || p.charAt(0) == s.charAt(0));
//
//        if (p.length() == 0) {
//            return s.length() == 0;
//        } else if (p.charAt(0) != '*') {
//            return s.length() != 0 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
//        } else {// p.charAt(0) == '*'
//            /**
//             * "adceb"
//             * "*a*b"
//             */
//            int firstNonStar = 1;
//            for (; firstNonStar < p.length(); firstNonStar++) {
//                if (p.charAt(firstNonStar) != '*') {
//                    break;
//                }
//            }
//
//            // this '*' can match [0, s.length()] characters.
//            for (int i = 0; i <= s.length(); i++) {
//                if (isMatch(s.substring(i), p.substring(firstNonStar))) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
//
//    }
}
