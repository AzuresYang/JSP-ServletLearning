package customerSys.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28029 on 2017/9/19.
 */
public class PageBean <T> {
    private long totalRecords;
    private long totalPage;
    private int peerPageRecords;
    private int currentPageRecords;
    private int currentPageCode;
    private String url;

    private List<T> beanList= new ArrayList<T>();


    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public long getTotalPage(){
        return totalPage;
    }
    public void setTotalPage(long i){
        totalPage = i;

    }
    public int getCurrentPageCode()
    {
        return currentPageCode;
    }

    public void setCurrentPageCode(int pc){
        currentPageCode = pc;
    }

    public long getToTalRecords(){
        return totalRecords;
    }

    public void setTotalRecords(long tr){
        totalRecords = tr;
    }

    public void setPeerPageRecords(int ppr){
        peerPageRecords = ppr;
    }
    public int getPeerPageRecords(){
        return peerPageRecords;
    }

    public int getCurrentPageRecords(){
        return currentPageRecords;
    }
    public void setCurrentPageRecords(int cpr)
    {
        currentPageRecords = cpr;
    }
    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
    public static long  calTotalPage(long allRecords, long pageRecords){
        if(pageRecords <=0)
            return 1;
        long lastPageRecorders = allRecords % pageRecords;
        long allPages = allRecords / pageRecords;

        if(lastPageRecorders == 0)
            allPages +=1;

        return allPages;
    }
}
