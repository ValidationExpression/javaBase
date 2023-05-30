package example;

public class People {
    private String name;
    private int age;
    private double high;

    public People() {
    }

    public People(String name, int age, double high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return high
     */
    public double getHigh() {
        return high;
    }

    /**
     * 设置
     * @param high
     */
    public void setHigh(double high) {
        this.high = high;
    }

    public String toString() {
        return "People{name = " + name + ", age = " + age + ", high = " + high + "}";
    }
}
