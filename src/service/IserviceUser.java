package service;

import bean.Card;
import bean.User;
import util.Page;

import java.util.List;

public interface IserviceUser {
    List<User> selectAll(Page page);



    List<Card> selectCard();


    int deleteId(String id);

    int addAll(User user);

    User selectId(String id);

    int updateAll(User user);
}
