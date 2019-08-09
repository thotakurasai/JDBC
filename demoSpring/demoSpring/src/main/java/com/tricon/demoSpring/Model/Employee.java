package com.tricon.demoSpring.Model;


public class Employee {
    
    public String Name;
    public String Position;
    int Id;
    
    public Employee()
    {
        
    }
    
    public Employee(String Name, String Position, int Id) {
        this.Name = Name;
        this.Position = Position;
        this.Id = Id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPosition() {
        return Position;
    }
    public void setPosition(String Position) {
        this.Position = Position;
    }
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

}
 