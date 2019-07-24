package bean;

import java.sql.Date;

public class User {
    private int id;
    private int num;
    private String name;
    private String addr;
    private Date date;
    private  int userId;

    private Card card;

    public String toString1() {
        return  num + "," + name + "," + addr + "," + date + "," + userId ;
    }

    public String toString2() {
        return  num + "," + name + "," + addr + "," + date + "," + userId+","+id ;
    }



    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
