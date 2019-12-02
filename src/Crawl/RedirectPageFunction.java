package Crawl;

public interface RedirectPageFunction {
    /**
     * 
     * @param url
     * @return
     */
    public String locationSearch(String url);

    /**
     * 
     * @param name
     * @return
     */
    public String[] getValueOfVariable(Object dom, String name);

    /**
     * 
     * @param dom
     * @return
     */
    public Boolean isRedirectPageJs(Object dom);

    /**
     * get my code in shortsolutionLength of codesignal company.
     * url: https://codesignal.com/
     * 
     * @param dom
     * @return
     */
    public String ignoreComment(Object dom) throws NullPointerException;

    /**
     * 
     * @param dom
     * @param onlineCommentSignal.
     *            ex: //||# or //
     * @param mutilLineCommentSignal.
     *            ex: (/*||*\/)##(<!--||-->)) or <!--||-->
     * @return
     */
    public String ignoreCommentAdvance(Object dom, String onlineCommentSignal, String mutilLineCommentSignal)
            throws NullPointerException, ArrayIndexOutOfBoundsException;
}
