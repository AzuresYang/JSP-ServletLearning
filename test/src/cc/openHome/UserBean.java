package cc.openHome;
import java.io.Serializable;
/**
 * Created by 28029 on 2017/9/9.
 */
public class UserBean {
    private String name;
    private String passw;

    public String getName(){
        return name;
    }

    public String getPass(){
        return passw;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassw(String iPassw){
        passw = iPassw;
    }

}
