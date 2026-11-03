package Project.UniqueNames;

import java.util.HashSet;

public class UniqueNames {

    private HashSet<String> names;

    public UniqueNames(){
        names = new HashSet<>();
    }

    public boolean addName(String name){

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        return names.add(name);
    }


    public void removeName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        if(names.isEmpty()){
            System.out.println("The list is empty");
            return;
        }else {
            names.remove(name);
        }
    }

    public boolean  containsName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        if(names.isEmpty()){
            System.out.println("The list is empty");
            return false;
        }

        return names.contains(name);
    }

    public void printNames(){
        if(names.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        for (String name : names){
            System.out.println(name);
        }
    }

    public int countNames(){
      return names.size();
    }
}
