package dao;

import bean.Card;
import bean.User;
import util.Page;

import java.util.List;

public interface IUserDao {
    int selectcount(Page page);

    List<User> selectAll(Page page);

    List<Card> selectcard();

    int deleteId(String id);

    int addAll(User user);

    User selectId(String id);

    int updateAll(User user);
}
