package com.hhxy.SuanFa;

/**
 * 分块查找拓展:
 *
 */
public class Demo02_FenKue {
    public static void main(String[] args) {
        //数据:{27,22,30,40,36,13,19,16,20,7,10,43,50,48}
        //观察数据可知不适合分块查找,可以对其进行改进
        /**
         * 思想:{27,22,30,40,36,
         *      13,19,16,20,
         *      7,10,
         *      43,50,48}
         * 由此分可以将数据分为4组,数据都是有最大与最小值,
         */
        int[] arr={27,22,30,40,36,13,19,16,20,7,10,43,50,48};
        //查找值
        int number = 48;
        Block block1 = new Block(22,40,0,4);
        Block block2 = new Block(13,20,5,8);
        Block block3 = new Block(7,10,9,10);
        Block block4 = new Block(43,50,11,13);

        Block[] blocks = {block1,block2,block3,block4};

        System.out.println(getIndex(blocks, arr, number));


    }
    //创建一个方法用于判断块索引
    public static int getIndex(Block[] block,int[] arr,int number){
        int index = findIndexBlock(block,number);
        if (index==-1){
            return -1;
        }
        int startIndex = block[index].getStartIndex();
        int endIndex = block[index].getEndIndex();

        //3.遍历
        for (int i = startIndex; i <= endIndex; i++) {
            if(arr[i] == number){
                return i;
            }
        }
        return -1;

    }
    //定义一个方法，用来确定number在哪一块当中
    public static int findIndexBlock(Block[] blocks,int number){ //100
        //从0索引开始遍历blockArr，如果number小于max，那么就表示number是在这一块当中的
        for (int i = 0; i < blocks.length; i++) {
            if (number>=blocks[i].getMin() && number<=blocks[i].getMax()){
                return i;
            }
        }
        return -1;
    }

}
//创建一个索引类
class Block{
    int min;
    int max;
    int startIndex;
    int endIndex;

    public Block() {
    }

    public Block(int min, int max, int startIndex, int endIndex) {
        this.min = min;
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}

