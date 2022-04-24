package principle.interfacesegregation.right;
//接口的方法很多, 不利于扩展. 比如: 学生只有查看成绩,打印成绩单的权限, 没有增删改的权限; 老师拥有所有的权限.
//即便新建一个只用得到一部分方法的class，也必须重写所有方法
public interface IStudentScoreWrong {
    // 查询成绩
    public void queryScore();

    // 修改成绩
    public void updateScore();

    // 添加成绩
    public void saveScore();

    // 删除成绩
    public void delete();

    // 计算总分
    public double sum();

    // 计算平均分
    public double avg();

    // 打印成绩单
    public void printScore();
}
