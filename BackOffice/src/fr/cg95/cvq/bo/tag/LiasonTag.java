package fr.cg95.cvq.bo.tag;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

public class LiasonTag extends BaseTag {

    String prefix = "";
    String article = "";
    
    public int doEndTag() {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();

            try {
                String subject = (String)RequestUtils.lookup(pageContext, name, property, getScope());

                out.println(liason(getPrefix(), getArticle(), subject));
                
            } catch (Exception e) {
            }
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    private String liason(String prefix, String article, String subject) {

        if (subject.toLowerCase().startsWith(prefix.toLowerCase()))
            return subject;

        String vowels = "aeiou";

        if (vowels.indexOf(subject.toLowerCase().charAt(0)) != -1)
            article = article.substring(0, article.length() - 1) + "'";
        else
            article += " ";

        return prefix + " " + article + subject;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
