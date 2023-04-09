package function_user;

public class function {
    String code_fun,name_fun;
    public function(){
    }

    public function(String code_fun,String name_fun){
        this.code_fun=code_fun;
        this.name_fun=name_fun;
    }
    public String getCode_fun() {
        return code_fun;
    }
    public String getName_fun() {
        return name_fun;
    }
    public void setName_fun(String name_fun) {
        this.name_fun = name_fun;
    }
    public void setCode_fun(String code_fun) {
        this.code_fun = code_fun;
    }
}
