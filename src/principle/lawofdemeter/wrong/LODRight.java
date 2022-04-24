package principle.lawofdemeter.wrong;

import java.util.ArrayList;
import java.util.List;

public class LODRight {
        public static void main(String[] args) {
        // 老师类
        ITeacher wangTeacher = new Teacher();

        List<Student> allStudent = new ArrayList(10);
        allStudent.add(new Student());
        allStudent.add(new Student());
        allStudent.add(new Student());
        allStudent.add(new Student());

        // 班长
        IGroupLeader zhangBanzhang = new GroupLeader(allStudent);
        wangTeacher.command(zhangBanzhang);
    }
}

interface ITeacher {
    void command(IGroupLeader groupLeader);
}

class Teacher implements ITeacher {
    @Override
    public void command(IGroupLeader groupLeader) {
        // 班长清点人数
        groupLeader.count();
    }
}

//班长类
interface IGroupLeader {
    // 班长清点人数
    void count();
}


// 班长类
class GroupLeader implements IGroupLeader {

    private List<Student> students;

    public GroupLeader(List<Student> students) {
        this.students = students;
    }
    @Override
    public void count() {
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