package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizen = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!this.citizen.containsKey(citizen.getPassport())) {
            this.citizen.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizen.get(passport);
    }
}
