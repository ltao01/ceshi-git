package util;

public class Page {
    private int startpage = 1;//开始位置
    private int size = 4;//每页显示的行数
    private int count;//总记录数
    private int sumpage;//平均总页数


    //区间查询
    private String kaname;//卡种
    private String username;//姓名

    @Override
    public String toString() {
        return "Page{" +
                "startpage=" + startpage +
                ", size=" + size +
                ", count=" + count +
                ", sumpage=" + sumpage +
                ", cityname='" + kaname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKaname() {
        return kaname;
    }

    public void setKaname(String kaname) {
        this.kaname = kaname;
    }

    public int getStartpage() {
        return startpage;
    }

    public void setStartpage(int startpage) {
        this.startpage = startpage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSumpage() {
        return sumpage;
    }

    public void setSumpage(int sumpage) {
        this.sumpage = sumpage;
    }
}




