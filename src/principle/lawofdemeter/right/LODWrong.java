package principle.lawofdemeter.right;


import java.util.ArrayList;
import java.util.List;

//Teacher有两个朋友，一个是GroupLeader，它是Teacher的command()方法的入参；另一个是Student，因为在Teacher的command()方法体中使用了Student。
//按照直接的朋友的定义:出现在成员变量、方法的输入输出参数中的类就是直接的朋友
//只有GroupLeader是Teacher的直接的朋友。
//Teacher在command()方法中创建了Student的数组，和非直接的朋友Student发生了交流，所以，上述例子违反了迪米特法则。
public class LODWrong {
        public static void main(String[] args) {
        // 老师类
        ITeacher wangTeacher = new Teacher();

        // 班长
        IGroupLeader zhangBanzhang = new GroupLeader();
        wangTeacher.command(zhangBanzhang);
    }
}

interface ITeacher {
    void command(IGroupLeader groupLeader);
}

class Teacher implements ITeacher{
    @Override
    public void command(IGroupLeader groupLeader) {
        // 全班同学
        List<Student> allStudent = new ArrayList<>();
        allStudent.add(new Student());
        allStudent.add(new Student());
        allStudent.add(new Student());
        allStudent.add(new Student());
        allStudent.add(new Student());
        // 班长清点人数
        groupLeader.count(allStudent);

    }
}

//班长类
interface IGroupLeader {

    // 班长清点人数
    void count(List<Student> students);
}

// 班长类
class GroupLeader implements IGroupLeader{
    //班长清点人数
    @Override
    public void count(List<Student> students) {
        // 班长清点人数
        System.out.println("上课的学生人数是: " + students.size());
    }
}

//学生类
interface IStudent {
}

//学生类
class Student implements IStudent {

}