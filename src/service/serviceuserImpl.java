package service;

import bean.Card;
import bean.User;
import dao.IUserDao;
import dao.userImpl;
import util.Page;

import java.util.List;

public class serviceuserImpl implements IserviceUser {
    IUserDao dao = new userImpl();

    @Override
    public List<User> selectAll(Page page) {

        int i = dao.selectcount(page);
        page.setCount(i);//总页数
        page.setSumpage(i % page.getSize() == 0 ? (page.getCount() / page.getSize()) : (page.getCount() / page.getSize() + 1));

        return dao.selectAll(page);
    }

    @Override
    public List<Card> selectCard() {
        return dao.selectcard();
    }

    @Override
    public int deleteId(String id) {
        return dao.deleteId(id);
    }

    @Override
    public int addAll(User user) {
        return dao.addAll(user);
    }

    @Override
    public User selectId(String id) {
        return dao.selectId(id);
    }

    @Override
    public int updateAll(User user) {
        return dao.updateAll(user);
    }

}
