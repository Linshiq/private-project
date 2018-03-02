package menu_center.translation.base;

import java.util.List;

/** 
 * 调用百度翻译api查询结果 
 *  
 */  
public class TranslateResult {  
    // 实际采用的源语言  
    private String from;  
    // 实际采用的目标语言  
    private String to;  
    // 结果体  
    private List<ResultPair> trans_result;  
  
    public String getFrom() {  
        return from;  
    }  
  
    public void setFrom(String from) {  
        this.from = from;  
    }  
  
    public String getTo() {  
        return to;  
    }  
  
    public void setTo(String to) {  
        this.to = to;  
    }  
  
    public List<ResultPair> getTrans_result() {  
        return trans_result;  
    }  
  
    public void setTrans_result(List<ResultPair> trans_result) {  
        this.trans_result = trans_result;  
    }
    
    /** 
     * 结果对 
     */  
    public class ResultPair {  
        // 原文  
        private String src;  
        // 译文  
        private String dst;  
      
        public String getSrc() {  
            return src;  
        }  
      
        public void setSrc(String src) {  
            this.src = src;  
        }  
      
        public String getDst() {  
            return dst;  
        }  
      
        public void setDst(String dst) {  
            this.dst = dst;  
        }  
    }  
} 
