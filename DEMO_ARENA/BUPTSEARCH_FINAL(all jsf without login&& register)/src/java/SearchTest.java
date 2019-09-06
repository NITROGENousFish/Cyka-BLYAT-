/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lizon
 */
import com.sun.corba.se.impl.oa.toa.TOAImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sun.security.timestamp.TimestampToken;

@ManagedBean(name = "searchTest")
@SessionScoped
public class SearchTest implements Serializable {
    // Hyper parmeter
    private static final long serialVersionUID = 1L; 
//    private static final Integer MESSAGE_PER_PAGE = 6; //how many message per page to show
    
    public Integer MESSAGE_PER_PAGE = 6; //每一页显示数量
    
    public void setMessagePerPage(Integer MESSAGE_PER_PAGE) {
        this.MESSAGE_PER_PAGE = MESSAGE_PER_PAGE;
    }
    public Integer getMessagePerPage() {
        return MESSAGE_PER_PAGE;
    }

    public static Integer CURRENT_PAGE = 1; //id of current page
    public static Integer pages_num = 27; // total pages
    public Double searchtime = new Double(0.012312);    //  search time 
    public String universalVariable;
       

    
    
    public void setPagesNum(Integer pages_num) {
        this.pages_num = pages_num;
    }
    public Integer getPagesNum() {
        return pages_num;
    }
    public String getPagesNumString(){
        return pages_num.toString();
    }
    
    public Double getSearchTime() {
        return searchtime;
    }
    public void setSearchTime(Double searchtime) {
        this.searchtime = searchtime;
    }
    public String getSearchTimeString() {
        return searchtime.toString();
    }
    
    private static final ArrayList<Message> messageList
            = new ArrayList<Message>(Arrays.asList(
                    new Message("1  021333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("2  11333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("3  21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("4 213333332131<em>231232</em>13123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("5 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("6 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("7 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("8 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("9 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("10 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("11 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("12 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("13 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("14 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("15 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("16 13333332131<em>231232</em>13123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("17 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("18 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("19 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("20 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("21 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("22 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("23 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("24 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("25 21333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("26 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1),
                    new Message("27 1333333213123123213123123sfsdgwfvsadfce", "CSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAFDAFCSASSSSSSSS<em>SSSSSSDAFDSF重点S</em>SSSSSSSSSSSSSDAF", "https://www.baidu.com", 1)
            ));



    public List<Message> getMessageList() {
        System.out.println((CURRENT_PAGE - 1) * MESSAGE_PER_PAGE + "    " + (CURRENT_PAGE) * (MESSAGE_PER_PAGE));
        if((CURRENT_PAGE) * (MESSAGE_PER_PAGE)<=pages_num){
            return messageList.subList((CURRENT_PAGE - 1) * MESSAGE_PER_PAGE, (CURRENT_PAGE) * (MESSAGE_PER_PAGE));
        }
        else{
            return messageList.subList((CURRENT_PAGE - 1) * MESSAGE_PER_PAGE, pages_num);
        }
    }

    public static class Message {

        String title;
        String context;
        String url;
        Integer clickTimes;

        public Message(String title, String context, String url, Integer clickTimes) {
            this.title = title;
            this.context = context;
            this.url = url;
            this.clickTimes = clickTimes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getClickTimes() {
            return clickTimes;
        }

        public void setClickTimes(Integer clickTimes) {
            this.clickTimes = clickTimes;
        }
    }

    public ArrayList<Selectpagelistall> selectpage;
    public class Selectpagelistall {

        String selectpagelist;
        String spantag;
        String herftag;
        public Selectpagelistall(String selectpagelist, String spantag, String herftag) {
            this.selectpagelist = selectpagelist;
            this.spantag = spantag;
            this.herftag = herftag;
        }

        public String getSelectPageList() {

            return selectpagelist;
        }

        public void setSelectPageList(String selectpagelist) {
            this.selectpagelist = selectpagelist;
        }

        public String getSpanTag() {
            return spantag;
        }

        public void setSpanTag(String spantag) {
            this.spantag = spantag;
        }
        
        public String getHerfTag() {
            return herftag;
        }

        public void setHerfTag(String herftag) {
            this.herftag = herftag;
        }
    }
    public List<Selectpagelistall> getSelectPage(){
        selectpage = new ArrayList<Selectpagelistall>();
            int pages = pages_num/MESSAGE_PER_PAGE+1;
            int i;
            if (pages < 10) {
                if (pages == 1){
                    Selectpagelistall test;
                    test = new Selectpagelistall("pc current-page",1+"",1+"");
                    selectpage.add(test);
                    return selectpage;
                }
                else{
                for (i = 1; i <= pages; i++) {
                        Selectpagelistall test;
                        if(i == CURRENT_PAGE){
                            test = new Selectpagelistall("pc current-page",i+"",i+"");
                        }
                        else{
                            test = new Selectpagelistall("pc",i+"",i+"");
                        }
                    selectpage.add(test);
                }
                }
            } else {
                if (CURRENT_PAGE <= 5) {
                    for (i = 1; i <= 10; i++) {
                        Selectpagelistall test;
                        if(i == CURRENT_PAGE){
                            test = new Selectpagelistall("pc current-page",i+"",i+"");
                        }
                        else{
                            test = new Selectpagelistall("pc",i+"",i+"");
                        }
                        selectpage.add(test);
                    }
                } else if (CURRENT_PAGE >= pages - 4) {
                    for (i = pages - 9; i <= pages; i++) {
                        Selectpagelistall test;
                        if(i == CURRENT_PAGE){
                            test = new Selectpagelistall("pc current-page",i+"",i+"");
                        }
                        else{
                            test = new Selectpagelistall("pc",i+"",i+"");
                        }
                        selectpage.add(test);
                    }
                } else {
                    for (i = CURRENT_PAGE - 4; i <= CURRENT_PAGE + 5; i++) {
                        Selectpagelistall test;
                        if(i == CURRENT_PAGE){
                            test = new Selectpagelistall("pc current-page",i+"",i+"");
                        }
                        else{
                            test = new Selectpagelistall("pc",i+"",i+"");
                        }
                        selectpage.add(test);
                    }
                }
            }
            if(CURRENT_PAGE == 1){
                Selectpagelistall last = new Selectpagelistall("pc prompt","后一页",CURRENT_PAGE+1+"");
                selectpage.add(last);
            }
            else if (CURRENT_PAGE == pages){
                Selectpagelistall first = new Selectpagelistall("pc prompt","前一页",CURRENT_PAGE-1+"");
                selectpage.add(0,first);
            }
            else{
                Selectpagelistall last = new Selectpagelistall("pc prompt","后一页",CURRENT_PAGE+1+"");
                selectpage.add(last);
                Selectpagelistall first = new Selectpagelistall("pc prompt","前一页",CURRENT_PAGE-1+"");
                selectpage.add(0,first);
            }
            
            return selectpage;
    }
    
    
    // url parameter pasting
    private int param = 1;
    private String searchwd;
    
    public int getParam() {
        CURRENT_PAGE = param;
        System.err.println("getParam   view action into here,param value is "+this.param);
        return param;
    }
 
    public void setParam(int param) {
        System.err.println("setParam   view action into here,param value is "+this.param);
        this.param = param;
    }

    public String getSearchwd(){
        this.param = 1;
        System.err.println("searchwd  get "+this.searchwd);
        return searchwd;
    }
    public void setSearchwd(String searchwd){
        System.err.println("searchwd   set "+this.searchwd);
        this.searchwd = searchwd;
    }
    public void init(){
        CURRENT_PAGE = param;
        System.err.println("Init           Init           Init           Init           "+this.param);
        
    }

   
}
    