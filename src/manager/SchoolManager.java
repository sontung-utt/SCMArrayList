package manager;

import model.School;

import java.util.ArrayList;

public class SchoolManager implements IManager<School>{
    ArrayList<School> listSchool;
    public SchoolManager() {
        this.listSchool = new ArrayList<>();
    }
    @Override
    public void add(School school) {
        listSchool.add(school);
    }

    @Override
    public void remove(int id) {
        int index = findById(id);
        listSchool.remove(index);
    }

    @Override
    public void update(int id, School school) {
        int index = findById(id);
        listSchool.set(index, school);
    }

    @Override
    public int findById(int id) {
        for(int i = 0; i < listSchool.size(); i++){
            if(listSchool.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<School> getAll() {
        return listSchool;
    }

    @Override
    public ArrayList<School> getByName(String name) {
        ArrayList<School> schools = new ArrayList<>();
        for(School school: listSchool){
            if(school.getName().toLowerCase().contains(name.toLowerCase())){
                schools.add(school);
            }
        }
        return schools;
    }
}
