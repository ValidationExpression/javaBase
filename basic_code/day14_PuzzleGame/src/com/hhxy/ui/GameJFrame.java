package com.hhxy.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    //使用构造方法便于主类调用
    //创建二维数组
    int[][] data = new int[4][4];
    //记录空白方格位置
    int x = 0;
    int y = 0;

    //图片路径
    String pathStart ="day14_PuzzleGame\\image\\";
    String pathEnd="";
    //定义一个数组用于判断结果是否正确
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0},
    };
    //记录步数
    int count=0;

    //创建一个条目
    JMenu changeItem = new JMenu("更换图片");
    //对图片分类的菜单
    JMenuItem beautifulGirl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem replyItem = new JMenuItem("重新开始");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");


    public GameJFrame() {
        //设置界面
        initJFrame();

        //初始化菜单
        initJMenu();
        //初始化数据
        initData();
        //初始化图片
        initImage();

        //界面默认不显示,使用
        this.setVisible(true);
    }

    //初始化数据(将二维数组打乱)
    private void initData() {
        //1.图片索引位置
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            //获取随机索引
            int index = r.nextInt(arr.length);
            //打乱顺序
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            //进行条件判断找出空白格的位置索引(x,y)
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            //注意不要写在else中,因为在遇见0时,若原0的位置有图片,此时不会进行覆盖,导致bug
            data[i / 4][i % 4] = arr[i];


        }
    }

    //初始化图片
    private void initImage() {
        //移除原本图片
        this.getContentPane().removeAll();
        //胜利图标
        if (victory()){
            JLabel jLabel =new JLabel(new ImageIcon(pathStart+"win.png"));
            jLabel.setBounds(203,283,197,73);
            this.getContentPane().add(jLabel);
        }
        //步数界面
        JLabel step = new JLabel("步数:"+count);
        step.setBounds(50,30,100,20);
        this.getContentPane().add(step);
        //图片加载顺序,先加载的图片在上方,后加载的在下方
        //循环行数(利用的是坐标)
        for (int i = 0; i < 4; i++) {
            //列数
            for (int j = 0; j < 4; j++) {
                //获取加载图片的索引
                int number = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(pathEnd + number + ".jpg"));
                //指定图片位置(105图片大小)
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //添加到容器中
                this.getContentPane().add(jLabel);
                number++;
            }
        }
        //添加背景图片
        JLabel jLabel1 = new JLabel(new ImageIcon(pathStart+"background.png"));
        jLabel1.setBounds(40, 40, 508, 560);
        this.getContentPane().add(jLabel1);

        //刷新界面
        this.getContentPane().repaint();
        //路径置空(不可在此处置空),因为在移动时会重新加载图片,若在此处置空就会是图片丢失
        //pathEnd="";
    }

    private void initJMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单选项
        JMenu functionJmenu = new JMenu("功能");

        //将条目添加到选项中
        functionJmenu.add(changeItem);
        functionJmenu.add(replyItem);
        functionJmenu.add(reLoginItem);
        functionJmenu.add(closeItem);
        //将二级菜单添加到(更换图片下)
        changeItem.add(beautifulGirl);
        changeItem.add(animal);
        changeItem.add(sport);
        //对图片设置监听
        beautifulGirl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);

        //条目设置监听
        replyItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        //将菜单选项放到菜单中
        jMenuBar.add(functionJmenu);
        //设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面大小
        this.setSize(603, 680);
        //设置标签
        this.setTitle("拼图 v1.0");
        //标签设置位置-一直在上
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式-3表示关闭一个界面就会将虚拟机关闭
        this.setDefaultCloseOperation(3);
        //设置取消默认居中
        this.setLayout(null);
        //监听键盘
        this.addKeyListener(this);
    }

    //监听键盘
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键盘按下不松时
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code==32)
        {
            //界面图片删除
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel jLabel=new JLabel(new ImageIcon(pathEnd+"all.jpg"));
            jLabel.setBounds(83,134,420,420);
            this.getContentPane().add(jLabel);
            //添加背景
            JLabel jLabel1 = new JLabel(new ImageIcon(pathStart+"background.png"));
            jLabel1.setBounds(40, 40, 508, 560);
            this.getContentPane().add(jLabel1);

            //刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断是否已经胜利,如果胜利结束
        if (victory()){
            return;
        }
        //判断上:38下:49左:37,右:39
        //上:87,下:83,左:65,右:68
        int code = e.getKeyCode();
        //System.out.println(code);
        if (code==87){
            System.out.println("向上");
            //进行一个条件判断(空格位于最下方时)
            if (x==3){
                //此时不能在移动
                return;
            }
            //逻辑:将空白格下方分数字向上移动
            //x,y:空白格
            //x+1,y:空白格下方数字
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            count++;
            initImage();
        } else if (code==83) {
            System.out.println("向下");
            if (x==0){
                //此时不能在移动
                return;
            }
            //x,y:空白格
            //x-1,y:空白格下方数字
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            count++;
            initImage();
        } else if (code==65) {
            System.out.println("向左");
            if (y==3){
                //此时不能在移动
                return;
            }
            //x,y:空白格
            //x+1,y:空白格下方数字
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            count++;
            initImage();
        } else if (code==68) {
            System.out.println("向右");
            if (y==0){
                //此时不能在移动
                return;
            }
            //x,y:空白格
            //x,y:空白格下方数字
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            count++;
            initImage();
        } else if (code==32) {
            //当不按时会显示原本图片
            initImage();
        } else if (code==81) {
            //作弊码
            data =new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0},
            };
            initImage();
        }

    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j]!=win[i][j]){
                    //数据判断
                    return false;
                }
            }
        }
        return true;
    }


    Random r = new Random();
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前条目点击的对象
        Object obj=e.getSource();
        if (obj==replyItem){
            System.out.println("重新游戏");
            //打乱二维数组的顺序
            initData();
            //计数器清零
            count=0;
            //加载图片
            initImage();

        } else if (obj==reLoginItem) {
            System.out.println("重新登录");
            //关闭当前页面
            this.setVisible(false);
            //实例化登陆类
            new LoginJFrame();
        } else if (obj==closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (obj==beautifulGirl) {
            pathEnd="";
            //产生一个随机数用于设置随机的图片
            int num = r.nextInt(13)+1;
            System.out.println(num);
            pathEnd=pathStart+"girl\\"+"girl"+num+"\\";
            //打乱二维数组的顺序
            initData();
            //计数器清零
            count=0;
            //加载图片
            initImage();
        } else if (obj==animal) {
            pathEnd="";
            int num =r.nextInt(8)+1;
            pathEnd=pathStart+"animal\\"+"animal"+num+"\\";
            //打乱二维数组的顺序
            initData();
            //计数器清零
            count=0;
            //加载图片
            initImage();
        } else if (obj == sport) {
            pathEnd="";
            int num = r.nextInt(10)+1;
            System.out.println(num);
            pathEnd=pathStart+"sport\\"+"sport"+num+"\\";
            System.out.println(pathEnd);
            //打乱二维数组的顺序
            initData();
            //计数器清零
            count=0;
            //加载图片
            initImage();
        }
    }
}
