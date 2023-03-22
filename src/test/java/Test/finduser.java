package Test;

import com.itheima.dao.OrderMapper;
import com.itheima.domain.Order2;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;


public class finduser {
    /*@Test
    public void finduserby() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user1=new User();
        user1.setUsername("lan");
        user1.setPwd("123");
        User user = mapper.loginServlet(user1);
        System.out.println(user.toString());
        session.close();
    }*/
/*
    @Test
    public void insertor(){
        int bookid=4;
        int userid=1;
        int result;
        SqlSession session = MyBatisUtils.getSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        Order2 order2=new Order2();
        order2.setBookid(bookid);
        order2.setUserid(userid);
        order2.setNumber(1);
        order2.setAddress("s");
        order2.setPostcode("s");
        order2.setOrderdate(new Date(System.currentTimeMillis()));
        order2.setStatus(0);
        result=mapper.insertOrder(order2);
        System.out.println(result);
    }
*/
    public void findor(){
        SqlSession session = MyBatisUtils.getSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order2 order2=mapper.findOrder();
        System.out.println(order2.toString());
    }

}
