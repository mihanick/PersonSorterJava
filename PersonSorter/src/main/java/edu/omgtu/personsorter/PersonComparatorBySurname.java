/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.omgtu.personsorter;

import java.util.Comparator;

/**
 *
 * @author gladkikh
 */
public class PersonComparatorBySurname implements Comparator<Person> {

    @Override
    public int compare(Person leftPerson, Person rightPerson) {
        //TODO: Добавить реализацию сравнения по именам
        String str1=leftPerson.Surname;
        String str2=rightPerson.Surname;
        return  str1.compareTo(str2);
    }
}
