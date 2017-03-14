package com.gwtjs.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.authc.Account;

import com.gwtjs.core.test.SpringTestBase;


/**
 * <b>function:</b> AccountMapper JUnit测试类
 * @version 1.0
 */
public class AccountMapperTest extends SpringTestBase {

    /*@Inject
    private AccountMapper<Account> mapper;

    public void testGetAccount() {
        Account acc = new Account();
        acc.setAccountId(28);
        System.out.println(mapper.get(acc));
    }

    public void testAdd() {
        Account account = new Account();
        account.setUsername("lisi@155.com");
        account.setPassword("abc");
        mapper.add(account);
    }

    public void testEditAccount() {
        Account acc = new Account();
        acc.setAccountId(28);
        acc = mapper.get(acc);
        System.out.println(acc);
        acc.setUsername("Zhangsan22");
        acc.setPassword("123123");
        mapper.edit(acc);
        System.out.println(mapper.get(acc));
    }

    public void testRemoveAccount() {
        Account acc = new Account();
        acc.setAccountId(28);
        mapper.remvoe(acc);
        System.out.println(mapper.get(acc));
    }

    public void testAccountList() {
        List<Account> acc = mapper.getAllAccount();
        System.out.println(acc.size());
        System.out.println(acc);
    }

    public void testList() {
        Account acc = new Account();
        acc.setUsername("@qq.com");
        List<Account> list = mapper.getList(acc);
        System.out.println(list.size());
        System.out.println(list);
    }*/
}
