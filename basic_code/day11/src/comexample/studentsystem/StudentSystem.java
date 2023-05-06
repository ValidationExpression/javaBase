package comexample.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 需求:
 * 学生管理系统:
 * 1.添加学生: id唯一
 * 2.删除学生: id存在删除,不存在提示
 * 3.修改学生: id存在修改,不存在提示
 * 4.查询学生: id存在查询,不存在提示
 * 5.退出
 */
public class StudentSystem {
    public static void startStudentSystem() {
        //创建一个集合用于存储学生信息
        ArrayList<Student> list = new ArrayList<>();
        //键盘录入
        Scanner sc = new Scanner(System.in);
        //使用loop的含义是对这个循环定义一个标号,可以用于下方循环终止时使用
        loop:
        while (true) {
            //1.定义一个界面方法
            look();
            System.out.println("请输入你的选择:");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    //2. 添加学生
                    addStudent(list);
                    break;
                case 2:
                    //3.删除学生
                    deleteStudent(list);
                    break;
                case 3:
                    updateStudent(list);
                    break;
                case 4:
                    queryStudent(list);
                    break;
                case 5:
                    System.out.println("退出");
                    //System.exit(0);也可以退出
                    break loop;
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }

    }

    //1.
    public static void look() {
        System.out.println("-------------学生管理系统-------------");
        System.out.println("1.添加学生:");
        System.out.println("2.删除学生:");
        System.out.println("3.修改学生:");
        System.out.println("4.查询学生:");
        System.out.println("5.退出:");
    }

    //2.添加学生
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        while (true) {
            System.out.println("请输入id:");
            String id = sc.next();
            if (judgeId(list, id)) {
                System.out.println("id存在请重新输入...");
            } else {
                stu.setId(id);
                break;
            }
        }
        System.out.println("请输入姓名:");
        String name = sc.next();
        stu.setName(name);
        System.out.println("请输入年龄:");
        int age = sc.nextInt();
        stu.setAge(age);
        System.out.println("请输入性别:");
        char sex = sc.next().charAt(0);
        stu.setSex(sex);
        System.out.println("请输入住址:");
        String address = sc.next();
        stu.setAddress(address);
        //添加数据
        list.add(stu);
        System.out.println("添加成功");
    }

    public static boolean judgeId(ArrayList<Student> list, String id) {
//        for (int i = 0; i < list.size(); i++) {
//            Student stu = list.get(i);
//            if (stu.getId().equals(id)){
//                return true;
//            }
//        }
//        return false;
        //使用indexId方法进行代码复用
        return indexId(list, id) >= 0;
    }

    //获取id索引
    public static int indexId(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //3.删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除学生的id:");
        String id = sc.next();
        //获取信息索引
        int index = indexId(list, id);
        if (index >= 0) {
            //此时找到id
            list.remove(index);
            System.out.println("id" + id + "学生删除成功");
        } else {
            System.out.println("删除失败...");
        }
    }

    //4.修改学生
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改学生的id:");
        String id = sc.next();
        //获取信息索引
        int index = indexId(list, id);
        if (index == -1) {
            System.out.println("不存在这个学生,请重新输入");
            return;
        }
        //当id存在时,则进行修改
        Student stu = list.get(index);//获取要修改学生的索引

        System.out.println("请输入姓名:");
        String newName = sc.next();
        stu.setName(newName);
        System.out.println("请输入年龄:");
        int newAge = sc.nextInt();
        stu.setAge(newAge);
        System.out.println("请输入性别:");
        char newSex = sc.next().charAt(0);
        stu.setSex(newSex);
        System.out.println("请输入住址:");
        String newAddress = sc.next();
        stu.setAddress(newAddress);
        System.out.println("修改完成");
    }

    //5.查询
    public static void queryStudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("请输入信息后在查询...");
            return;
        }
        //输出
        System.out.println("id\t\t姓名\t年龄\t性别\t住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t"
                    + stu.getName() + "\t"
                    + stu.getAge() + "\t"
                    + stu.getSex() + "\t"
                    + stu.getAddress());
        }

    }
}
