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
    public class PersonComparatorByName implements Comparator<Person>
    {
        @Override
        public int compare(Person leftPerson, Person rightPerson) 
        {
            String str1=leftPerson.Name;
            String str2=rightPerson.Name;
            return str1.compareTo(str2);

            return 0;
        }
    }