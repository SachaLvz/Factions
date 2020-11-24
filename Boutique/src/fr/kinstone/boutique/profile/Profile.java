package fr.kinstone.boutique.profile;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Profile {

    private String name;
    private double points;

    public Profile(String name){
        this.name = name;
        this.points = 0;
    }

}
