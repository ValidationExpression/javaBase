package comexample.studentsystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        //定义一个集合用于存储注册信息
        ArrayList<User> userList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            accountLook();
            System.out.println("请输入你的选项:");
            String choose = sc.next();
            switch (choose) {
                case "1":
                    System.out.println("登录");
                    login(userList);
                    break;
                case "2":
                    System.out.println("注册");
                    logIn(userList);
                    break;
                case "3":
                    System.out.println("退出");
                    break loop;
                case "4":
                    System.out.println("忘记密码");
                    forgetPassword(userList);
                    break;
                default:
                    System.out.println("没有这个选项,请重新输入...");
            }
        }
    }

    //注册提示
    public static void accountLook() {
        System.out.println("欢迎来到学生管理系统");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        System.out.println("4.忘记密码");
    }

    //注册需求实现
    public static void logIn(ArrayList<User> userList) {
        User user = new User();
        //1.用户名
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("用户名");
            String username = sc.next();
            //1.定义方法实现
            /**
             * 用户名唯一
             * 用户名长度必须在3~15之间
             * 只能是字母加数字的组合
             */
            if (user(userList, username)) {
                user.setUsername(username);
                break;
            }
        }
        //2.密码
        while (true) {
            System.out.println("请输入密码:");
            String passwordOne = sc.next();
            System.out.println("请再次输入密码:");
            String passwordTwo = sc.next();
            /**
             * 判断两次密码是否相同
             */
            if (passwordOne.equals(passwordTwo)) {
                user.setPassword(passwordOne);
                break;
            } else {
                System.out.println("两次密码不相同,请重新输入...");
                continue;
            }
        }
        //3.身份证号
        while (true) {
            System.out.println("请输入身份号:");
            String card = sc.next();
            /**
             * 验证:
             * 长度为18位
             * 不能以0开头
             * 前17位必须位数字
             * 最后一位可以是数字也可以是大写X,小写x
             */
            if (cardJudge(card)) {
                user.setCard(card);
                break;
            }
        }
        //4.手机号
        while (true) {
            System.out.println("请输入手机号:");
            String phone = sc.next();
            /**
             * 验证:
             * 长度11位
             * 不能0开头
             * 必须为数字
             */
            if (phoneJudge(phone)) {
                user.setPhone(phone);
                break;
            }
        }
        //注意一定要写入到列表中
        userList.add(user);
        System.out.println("注册成功");
        print(userList);
    }

    //查看注册结果
    public static void print(ArrayList<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            System.out.println(user.getUsername() + "  " + user.getPassword() + "  " + user.getCard() + "  " + user.getPhone());
        }
    }

    //1.验证需求方法
    public static boolean user(ArrayList<User> userList, String username) {
        //数字与字母组合
        boolean countJudge = false;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    count1++;
                }
                if (c >= '0' && c <= '9') {
                    count2++;
                }
            }
        }
        if (count1 > 0 && count2 > 0) {
            countJudge = true;
        } else {
            System.out.println("用户名须为字母数字组合");
        }

        //用户名唯一判断--judgeId返回true表示存在
        if (judgeId(userList, username)) {
            System.out.println("用户名已经存在");
            return false;
        } else {
            //长度判断
            int longUsername = username.length();
            if (longUsername < 3 || longUsername > 15) {
                System.out.println("用户名须在3~15之间");
            }
            if ((longUsername > 3 && longUsername < 15) && countJudge) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeId(ArrayList<User> userList, String username) {
        return indexId(userList, username) >= 0;
    }

    //获取id索引
    public static int indexId(ArrayList<User> userList, String username) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }


    //3.身份证号验证
    public static boolean cardJudge(String card) {
        //不能以0开头
        boolean firstCard = card.charAt(0) != '0';
        if (!firstCard) {
            System.out.println("首位不能为0");
        }
        //身份证号前17位应为数字
        int count = 0;
        boolean moCard = false;
        for (int i = 0; i < card.length() - 1; i++) {
            char c = card.charAt(i);
            if (c >= '0' && c <= '9') {
                count++;
            }
        }
        if (count == 17) {
            moCard = true;
        }
        //长度
        if (card.length() == 18) {
            //最后一位(应当加一个条件判断,不然card.charAt(17)会超出索引报错)
            boolean lastCard = false;
            if ((card.charAt(17) >= '0' && card.charAt(17) <= '9') || card.charAt(17) == 'X' || card.charAt(17) == 'x') {
                lastCard = true;
            } else {
                System.out.println("最后一位应当为数字或X,x");
            }

            //--最终判断
            if (firstCard && moCard && lastCard) {
                return true;
            }
        } else {
            System.out.println("身份证号长度不对");
        }
        return false;
    }

    //4.手机号验证
    public static boolean phoneJudge(String phone) {
        //长度11位
        if (phone.length() == 11) {
            //不能以0开头
            boolean firstPhone = phone.charAt(0) != '0';
            if (!firstPhone) {
                System.out.println("手机号起始位不能为零");
            }
            //全为数字
            int count = 0;
            for (int i = 0; i < phone.length(); i++) {
                char c = phone.charAt(i);
                if (c >= '0' && c <= '9') {
                    count++;
                }
            }
            if (count == 11 && firstPhone) {
                return true;
            } else {
                System.out.println("手机号应全为数字");
            }
        } else {
            System.out.println("手机号位数不够");
        }
        return false;
    }


    /**
     * 登录功能
     */
    public static void login(ArrayList<User> userList) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名:");
            String username = sc.next();
            //判断用户名是否存在
            if (!judgeId(userList, username)) {
                System.out.println("用户名未注册,请先进行注册");
                return;
            }
            System.out.println("请输入密码:");
            String password = sc.next();
            while (true) {
                //创建一个生成验证码的方法
                String code1 = codeString();
                System.out.println("验证码是:" + code1);
                System.out.println("请输入验证码:");
                String code = sc.next();
                //忽略大小写
                if (code1.equalsIgnoreCase(code)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码有误,请重新输入...");
                    continue;
                }
            }
            if (usernamePassword(userList, username, password)) {
                System.out.println("账号密码正确");
                //实例化
                StudentSystem stu = new StudentSystem();
                stu.startStudentSystem();
                break;
            } else {
                System.out.println("账号或密码有误...还有" + (2 - i) + "次机会");
            }
        }

    }


    /**
     * 生成验证码
     */
    public static String codeString() {
        //随机产生索引
        Random r = new Random();
        //定义一个中间变量
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(52);
            str.append(randomString(index));
        }
        int number = r.nextInt(10);
        str.append(number);
        String strToString = str.toString();
        return dislocate(strToString);
    }

    public static char randomString(int index) {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 's', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'S', 'Y', 'Z'};
        return c[index];
    }

    public static String dislocate(String str) {
        char[] c = str.toCharArray();
        Random r = new Random();
        //产生一个随机索引,进行交换
        char str1;
        for (int i = 0; i < c.length; i++) {
            int index1 = r.nextInt(c.length);
            if (i != index1) {
                //注意应当先存储需要交换的变量的值,因为赋值会进行覆盖原来的值,为了保证元数据不发生改变.
                str1 = c[i];
                c[i] = c[index1];
                c[index1] = str1;
            }
        }
        return new String(c);
    }

    //定义方法实现用户名与密码是否正确,有三次机会
    public static boolean usernamePassword(ArrayList<User> userList, String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                return true;
            }
        }
        return false;
    }


    /**
     * 忘记密码
     */
    public static void forgetPassword(ArrayList<User> userList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        //判断用户名是否存在
        if (!judgeId(userList, username)) {
            System.out.println("用户名未注册,请先进行注册");
            return;
        }
        System.out.println("请输入身份号:");
        String card = sc.next();
        System.out.println("请输入手机号:");
        String phone = sc.next();

        //判断是否正确
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getCard().equals(card) && user.getPhone().equals(phone)) {
                System.out.println("验证通过");
                System.out.println("请输入修改的密码");
                String password = sc.next();
                user.setPassword(password);
                print(userList);
                break;
            } else {
                System.out.println("信息不匹配,修改失败");
            }
        }

    }
}
