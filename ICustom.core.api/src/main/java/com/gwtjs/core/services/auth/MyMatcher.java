package com.gwtjs.core.services.auth;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

import com.gwtjs.core.services.utils.CodecUtil;

/**
 * 用于比较密码是否相等
 */
@Component
public class MyMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        // 加密后由表单提交过来的密码
        String tokenPassword = CodecUtil.encryptMD5(super.toString(token.getCredentials()));
        // 从 Realm 中传递过来的密码
        String infoPassword = super.toString(info.getCredentials());
        // 比较两密码是否相等
        return tokenPassword.equals(infoPassword);
    }
}
