import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description todo
 * @ClassName test
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/21 19:16
 * @Version V1.0
 */
public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);
        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);

        List<Department> subDepartments = DepartmentTest.getSub(3, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }
    /**
     * 根据id，获取所有子部门列表(包括隔代子部门)
     * @param id
     * @return
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        allDepartment.forEach(t -> {
            if(hashMap.containsKey(t.getPid())){
                hashMap.get(t.getPid()).add(t.getId());
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(t.getId());
                hashMap.put(t.getPid(), list);
            }
        });
        if(!hashMap.containsKey(id)){
            return null;
        }
        List<Integer> integerList = hashMap.get(id);
        result.addAll(integerList);
        Stack<Integer> stack = new Stack<>();
        integerList.forEach(stack::push);
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            if(!hashMap.containsKey(pop)){
                continue;
            }
            List<Integer> lists = hashMap.get(pop);
            result.addAll(lists);
            lists.forEach(stack::push);
        }

        return allDepartment.stream().filter(t -> result.contains(t.getId())).collect(Collectors.toList());
    }
}
class Department {
    /** id */
    private int id;
    /** parent id */
    private int pid;
    /** 名称 */
    private String name;
    public Department(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}
