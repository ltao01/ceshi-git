package dao;

import bean.Card;
import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;
import util.Page;

import java.sql.SQLException;
import java.util.List;

public class userImpl implements IUserDao {
    QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    //    查询总页数
    @Override
    public int selectcount(Page page) {
        String sql = "select COUNT(*) from user where 1=1 ";
        try {
            //姓名模糊查询
            String username = page.getUsername();

            if (username != null && !username.equals("")) {
                sql += " and name like '%" + username.trim() + "%'";
            }
            //卡种查询
            String aname = page.getKaname();
            if (aname != null && !aname.trim().equals("0")) {
                sql += " and userId = " + aname.trim();
            }

            return qr.query(sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //查询所有分页
    @Override
    public List<User> selectAll(Page page) {
        try {
            String sql = "select * from user where 1=1 ";
            //姓名模糊查询
            String username = page.getUsername();
            if (username != null && !username.equals("")) {
                sql += " and name like '%" + username.trim() + "%'";
            }
            //卡种查询
            String aname = page.getKaname();
            if (aname != null && !aname.trim().equals("0")) {
                sql += " and userId = " + aname.trim();
            }

            sql += " limit ?,?";
            List<User> list = qr.query(sql, new BeanListHandler<User>(User.class), (page.getStartpage() - 1) * page.getSize(), page.getSize());
            for (User tif : list) {
                Card city = qr.query("select * from card where cardId=?", new BeanHandler<Card>(Card.class), tif.getUserId());
                tif.setCard(city);
            }
            System.out.println(list);
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //  副表查询
    @Override
    public List<Card> selectcard() {
        try {

            return qr.query("select * from card ", new BeanListHandler<Card>(Card.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //删除
    @Override
    public int deleteId(String id) {
        try {
            return qr.update("delete from user where id  in (" + id + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //新增
    @Override
    public int addAll(User user) {
        try {
            return qr.update("insert into user (num,name,addr,date,userId) values(?,?,?,?,?)", user.toString1().split(","));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询单条数据
    @Override
    public User selectId(String id) {
        try {

            return qr.query("select * from user where id=? ", new BeanHandler<User>(User.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //x         修改
    @Override
    public int updateAll(User user) {
        try {
            return qr.update("update user set num=?,name=?,addr=?,date=?,userId=? where id=?", user.toString2().split(","));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
