package Crawl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.UtilsFunc;

public class RedirectPageJsFunctionImpl implements RedirectPageFunction {

    @Override
    public String locationSearch(String url) {
        String[] list = url.split("?");
        return list[list.length - 1];
    }

    @Override
    public String[] getValueOfVariable(Object dom, String name) {
        // convert to string
        String domStr = dom.toString();
        domStr = ignoreCommentAdvance(domStr, "//", "/*||*/");
        String PATTERN = "\\s*(?:const|var|let|\\s*)?\\s*" + name + "\\s*=\\s*";
        Pattern p = Pattern.compile(PATTERN, Pattern.MULTILINE);
        Matcher m = p.matcher(domStr);
        List<String> res = new ArrayList<>();

        while (m.find()) {
            int end = m.end();
            String value = "";
            boolean isInString = false;
            while (end < domStr.length()) {
                if (domStr.charAt(end - 1) != '\\'
                     && (domStr.charAt(end) == '"' || domStr.charAt(end) == '\''))
                    isInString = !isInString;
                if (!isInString) {
                    if (domStr.charAt(end) == ';' || domStr.charAt(end) == ',' || domStr.charAt(end) == '\n')
                        break;
                    value += domStr.charAt(end);
                } else
                    value += domStr.charAt(end);
                end++;
            }
            res.add(value);
        }

        return res.toArray(new String[res.size()]);
    }

    @Override
    public Boolean isRedirectPageJs(Object dom) {
        String DomStr = dom.toString();
        return DomStr.matches("window.location.href|window.location.replace");
    }

    @Override
    public String ignoreComment(Object dom) {
        String domStr = dom.toString();
        // get in new line
        String[] breakLines = domStr.split("\n\r");
        List<String> newStringList = new ArrayList<String>();
        String tmp, res = "";
        boolean commentMultiLine = false;

        for (int i = 0; i < breakLines.length; i++) {
            tmp = breakLines[i];
            String newStr = "";
            boolean isInString = false;
            for (int j = 0; j < tmp.length(); j++) {
                // check is start or end of a string
                if (j > 0 && tmp.charAt(j - 1) != '\\' && tmp.charAt(j) == '"')
                    isInString = !isInString;
                if (!isInString && !commentMultiLine && j < tmp.length() - 1 && tmp.charAt(j) == '/') {
                    if (tmp.charAt(j + 1) == '/')
                        break;
                    if (tmp.charAt(j + 1) == '*') {
                        commentMultiLine = true;
                        j += 2;
                    }
                }
                if (!isInString && commentMultiLine && j < tmp.length() - 1 && tmp.charAt(j) == '*'
                        && tmp.charAt(j + 1) == '/') {
                    commentMultiLine = false;
                    j += 1;
                    continue;
                }
                if (!isInString && j < tmp.length() && !commentMultiLine)
                    newStr += tmp.charAt(j);
            }
            newStringList.add(newStr.trim());
        }
        res = newStringList.size() > 1 ? String.join("\n\r", newStringList) : newStringList.get(0);
        return res;
    }

    @Override
    public String ignoreCommentAdvance(Object dom, String onlineCmtSign, String mutilLineCmtSign) {
        String[] domStr = dom.toString().split("\n\r"), mutiLineCmtList = mutilLineCmtSign.split("##");
        int index = 0;
        while (index < mutiLineCmtList.length) {
            String mutiLineCmt = mutiLineCmtList[index];
            if (mutiLineCmtList.length > 0) {
                mutiLineCmt = mutiLineCmtList[index].substring(1, mutiLineCmtList[index].length() - 1);
            }
            String[] oliCmtSign = onlineCmtSign.split("\\|\\|");
            domStr = this.ignoreOneTypeCommentAdvance(domStr, oliCmtSign, mutiLineCmt);
            index++;
        }

        String res = domStr.length > 1 ? String.join("\n\r", Arrays.asList(domStr)) : domStr[0];
        return res;
    }

    /**
     * 
     * @param object
     * @param onlineCommentSignal
     * @param mutilLineCommentSignal
     * @return
     */
    private String[] ignoreOneTypeCommentAdvance(String[] breakLines, String[] onelineCmtSignal,
            String mutilLineCmtSignal) {
        // get in new line
        List<String> newStringList = new ArrayList<String>();
        String tmp;
        boolean isMultiLine = false;
        String[] getSignOpenAndClose = mutilLineCmtSignal.split("\\|\\|");
        String openSignMutiLine = getSignOpenAndClose[0], closeSignMutiLine = getSignOpenAndClose[1];

        for (int i = 0; i < breakLines.length; i++) {
            boolean isInString = false;
            Integer startCut = 0;
            tmp = breakLines[i];

            for (int j = 0; j < tmp.length(); j++) {
                // check is start or end of a string
                if (j > 0 && tmp.charAt(j - 1) != '\\' && (tmp.charAt(j) == '"' || tmp.charAt(j) == '\''))
                    isInString = !isInString;
                // oneline comment
                if (!isMultiLine && !isInString && this.checkCmtSign(j, tmp, onelineCmtSignal)) {
                    tmp = j <= 0 ? "" : tmp.substring(0, j);
                    break;
                }
                // mutiline comment
                if (!isMultiLine && !isInString && this.checkMatchingComment(j, tmp, openSignMutiLine)) {
                    isMultiLine = true;
                    startCut = j;
                    j += openSignMutiLine.length() - 1;
                    continue;// not run comment if right below
                }
                if (isMultiLine && !isInString && this.checkMatchingComment(j, tmp, closeSignMutiLine)) {
                    isMultiLine = false;
                    tmp = tmp.substring(0, startCut) + tmp.substring(j + closeSignMutiLine.length());
                    j = startCut - 1;
                }
            }
            // add to list
            tmp = tmp.trim();
            if (!isMultiLine && !UtilsFunc.isEmpty(tmp)) {
                newStringList.add(tmp);
            } else if (startCut > 0) {
                tmp = tmp.substring(0, startCut - 1);
                if (!UtilsFunc.isEmpty(tmp))
                    newStringList.add(tmp);
            }
        }

        return newStringList.toArray(new String[newStringList.size()]);
    }

    /**
     * 
     * @param start
     * @param command
     * @param commentSignal
     * @return
     */
    private boolean checkCmtSign(Integer start, String command, String[] commentSignal) {
        int index = 0;
        while (index < commentSignal.length)
            if (checkMatchingComment(start, command, commentSignal[index++]))
                return true;
        return false;
    }

    /**
     * 
     * @param start
     * @param command
     * @param onlineCommentSignal
     * @return
     */
    private boolean checkMatchingComment(Integer start, String command, String commentSignal) {
        Integer j = 0;
        while (j < commentSignal.length() && j + start < command.length()) {
            if (command.charAt(start + j) != commentSignal.charAt(j))
                break;
            j++;
        }
        if (j == commentSignal.length())
            return true;
        return false;
    }

}
