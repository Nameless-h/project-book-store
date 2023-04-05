package function_user;

public class fun_group {
    String ma;
    String ten;
    String datecrt;
    String dateup;
    public fun_group() {
    }

    public fun_group(String ma, String ten,String date_crt,String date_up) {
        this.ma = ma;
        this.ten = ten;
        this.datecrt=date_crt;
        this.dateup=date_up;
    }
    public String getMa(){
        return this.ma;
    }
    public String getTen(){
        return this.ten;
    }
    public String getDatecrt(){
        return this.datecrt;
    }
    public String getDateup(){
        return this.dateup;
    }
    public void setMa(String ma){
        this.ma=ma;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public void setDatecrt(String datecrt){
        this.datecrt=datecrt;
    }
    public void setDateup(String dateup){
        this.dateup=dateup;
    }
}
