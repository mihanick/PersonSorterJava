/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.omgtu.personsorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gladkikh
 */
public class PersonSorterTest {

    private List<String> readSampleFile(String inputFileName) throws Exception {
        List<String> result = new ArrayList<>();

        // http://stackoverflow.com/questions/4716503/best-way-to-read-a-text-file-in-java
        FileReader fr = new FileReader(inputFileName);
        BufferedReader textReader = new BufferedReader(fr);
        try {
            String line = textReader.readLine();
            while (line != null) {
                result.add(line);
                line = textReader.readLine();
            }
        } finally {
            textReader.close();
        }

        return result;
    }

    @Test
    public void testPersonCollectionSortByName() throws Exception {
        List<String> linesFromFile = readSampleFile("./group.txt");
        List<Person> students = new ArrayList<>();
        for (String line : linesFromFile) {
            students.add(new Person(line));
        }

        List<String> expectedList = new ArrayList<>();
        for (Person student : students) {
            expectedList.add(student.Name);
        }

        Collections.sort(expectedList);

        Collections.sort(students, new PersonComparatorBySurname());

        for (int i = 0; i < students.size(); i++) {
            String expected = expectedList.get(i);
            String actual = students.get(i).Name;
            assertEquals("Не совпадает сортировка только по именам",
                    expected, actual);
        }
    }

    @Test
    public void testPersonCollectionSortBySurname() throws Exception {
        List<String> linesFromFile = readSampleFile("./group.txt");
        List<Person> students = new ArrayList<>();
        for (String line : linesFromFile) {
            students.add(new Person(line));
        }

        List<String> expectedList = new ArrayList<>();
        for (Person student : students) {
            expectedList.add(student.Surname);
        }

        Collections.sort(expectedList);

        Collections.sort(students, new PersonComparatorByName());

        for (int i = 0; i < students.size(); i++) {
            String expected = expectedList.get(i);
            String actual = students.get(i).Surname;
            assertEquals("Не совпадает сортировка только по именам",
                    expected, actual);
        }
    }

    @Test
    public void testPersonCollectionSortByGroupNameSurname() throws Exception {
        List<String> linesFromFile = readSampleFile("./group.txt");
        List<Person> students = new ArrayList<>();
        for (String line : linesFromFile) {
            students.add(new Person(line));
        }

        List<String> expectedList = new ArrayList<>();
        for (Person student : students) {
            expectedList.add(student.Group + " " + student.Name + " " + student.Surname);
        }

        Collections.sort(expectedList);

        Collections.sort(students, new PersonComparatorByGroupNameSurname());

        for (int i = 0; i < students.size(); i++) {
            String expected = expectedList.get(i);
            String actual = students.get(i).Group + " "
                    + students.get(i).Name + " "
                    + students.get(i).Surname;
            assertEquals("Не совпадает сортировка только по именам",
                    expected, actual);
        }
    }
}
