package function_user;

public class detail_fun_group {
    String code_gr_fun,code_fun,action,visibel;
    public detail_fun_group(){}
    public detail_fun_group(String code_gr_fun,String code_fun,String action,String visibel ){
        this.code_gr_fun=code_gr_fun;
        this.code_fun=code_fun;
        this.action=action;
        this.visibel=visibel;
    }
    public void setCode_gr_fun(String code_gr_fun) {
        this.code_gr_fun = code_gr_fun;
    }
    public void setVisibel(String visibel) {
        this.visibel = visibel;
    }
    public void setCode_fun(String code_fun) {
        this.code_fun = code_fun;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }
    public String getCode_fun() {
        return code_fun;
    }
    public String getCode_gr_fun() {
        return code_gr_fun;
    }
    public String getVisibel() {
        return visibel;
    }
    
}
