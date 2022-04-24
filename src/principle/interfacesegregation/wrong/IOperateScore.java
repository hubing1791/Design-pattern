package principle.interfacesegregation.wrong;

public interface IOperateScore {

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

}
