package lsq.model;

public class Html {
    private String htmlid;

    private String htmldsc;

    public String getHtmlid() {
        return htmlid;
    }

    public void setHtmlid(String htmlid) {
        this.htmlid = htmlid == null ? null : htmlid.trim();
    }

    public String getHtmldsc() {
        return htmldsc;
    }

    public void setHtmldsc(String htmldsc) {
        this.htmldsc = htmldsc == null ? null : htmldsc.trim();
    }
}