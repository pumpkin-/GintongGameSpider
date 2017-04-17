package GintongameSpider.SpiderLG;
//class ProxyAuthenticator extends Authenticator {
//    private String user, password;
//
//    public ProxyAuthenticator(String user, String password) {
//        this.user     = user;
//        this.password = password;
//    }
//
//    protected PasswordAuthentication getPasswordAuthentication() {
//        return new PasswordAuthentication(user, password.toCharArray());
//    }
//}

/**
 * 注意：下面代码仅仅实现HTTP请求链接，每一次请求都是无状态保留的，仅仅是这次请求是更换IP的，如果下次请求的IP地址会改变
 * 如果是多线程访问的话，只要将下面的代码嵌入到你自己的业务逻辑里面，那么每次都会用新的IP进行访问，如果担心IP有重复，
 * 自己可以维护IP的使用情况，并做校验。
 */
public class ProxyTest {
}

