package manager;

import model.Student;
import view.MenuUser;

import java.util.ArrayList;

public class StudentManager implements IManager<Student>{
    ArrayList<Student> listStudent;
    private MenuUser menuUser;
    public StudentManager() {
        this.listStudent = new ArrayList<>();
    }

    public StudentManager(MenuUser menuUser) {
        this.menuUser = menuUser;
    }

    @Override
    public void add(Student student) {
        listStudent.add(student);
    }

    @Override
    public void remove(int id) {
        int index = findById(id);
        listStudent.remove(index);
    }

    @Override
    public void update(int id, Student student) {
        int index = findById(id);
        listStudent.set(index, student);
    }

    @Override
    public int findById(int id) {
        for(int i = 0; i<listStudent.size(); i++){
            if(listStudent.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Student> getAll() {
        return listStudent;
    }

    @Override
    public ArrayList<Student> getByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i<listStudent.size(); i++){
            if(listStudent.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                students.add(listStudent.get(i));
            }
        }
        return students;
    }

    public ArrayList<Student> getByRangeMark(double min, double max){
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i<listStudent.size(); i++){
            if(listStudent.get(i).getAverageMark() >= min && listStudent.get(i).getAverageMark() <= max){
                students.add(listStudent.get(i));
            }
        }
        return students;
    }

    public ArrayList<Student>  getByRangeAge(int minAge, int maxAge){
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i<listStudent.size(); i++){
            if(listStudent.get(i).getAge()>=minAge && listStudent.get(i).getAge()<=maxAge){
                students.add(listStudent.get(i));
            }
        }
        return students;
    }
}
