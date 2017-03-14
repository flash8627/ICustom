package com.gwtjs.email.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.email.exception.AccountEmailException;
import com.gwtjs.email.services.IAccountEmailService;

/**
 */
public class AccountEmailService implements IAccountEmailService 
{
	//spring的邮件发送工具,get 和 set 实现注入
	private JavaMailSender javaMailSender;
	//
	private String systemEmail;

    public ResultWrapper sendMail( String to, String subject, String htmlText )
        throws AccountEmailException
    {
        try
        {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper( msg );

            msgHelper.setFrom( systemEmail );
            msgHelper.setTo( to );
            msgHelper.setSubject( subject );
            msgHelper.setText( htmlText, true );

            javaMailSender.send( msg );
        }
        catch ( MessagingException e )
        {
            throw new AccountEmailException( "Faild to send mail.", e );
        }
        return ResultWrapper.successResult();
    }

    public JavaMailSender getJavaMailSender()
    {
        return javaMailSender;
    }

    public void setJavaMailSender( JavaMailSender javaMailSender )
    {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail()
    {
        return systemEmail;
    }

    public void setSystemEmail( String systemEmail )
    {
        this.systemEmail = systemEmail;
    }
}
