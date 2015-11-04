/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.omgtu.personsorter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gladkikh
 */
public class PersonComparatorTest {

    public PersonComparatorTest() {
    }

    @Test
    public void TestNameCompareNull() throws Exception {
        Person personLeft = new Person();
        Person personRight = new Person("Бунин Иван РН-231");
        PersonComparatorByName comparator = new PersonComparatorByName();
        assertEquals("Не выполнено сравнение по имени с пустым Person",
                -1, comparator.compare(personLeft, personRight));

    }

    @Test
    public void TestNameCompare() throws Exception {
        Person personLeft = new Person("Мандельштам Осип РН-231");
        Person personRight = new Person("Бунин Иван РН-231");
        PersonComparatorByName comparator = new PersonComparatorByName();
        assertEquals("Не выполнено сравнение по имени с равными группами",
                1, comparator.compare(personLeft, personRight));
    }

    @Test
    public void TestGroupNameSurnameCompareDifferentGroup() throws Exception {
        Person personLeft = new Person("Бунин Иван РН-231");
        Person personRight = new Person("Бунин Иван РН-131");
        PersonComparatorByGroupNameSurname comparator
                = new PersonComparatorByGroupNameSurname();
        assertEquals("Не выполнено полное сравнение с разными группами",
                1, comparator.compare(personLeft, personRight));
    }

    @Test
    public void TestGroupNameSurnameCompareSameGroup() throws Exception {
        Person personLeft = new Person("Мандельштам Осип РН-231");
        Person personRight = new Person("Бунин Иван РН-231");
        PersonComparatorByGroupNameSurname comparator
                = new PersonComparatorByGroupNameSurname();
        assertEquals("Не выполнено полное сравнение с одинаковыми группами",
                1, comparator.compare(personLeft, personRight));
    }

    @Test
    public void TestGroupNameSurnameCompareSameGroupName() throws Exception {
        Person personLeft = new Person("Некрасов Иван РН-231");
        Person personRight = new Person("Бунин Иван РН-231");
        PersonComparatorByGroupNameSurname comparator
                = new PersonComparatorByGroupNameSurname();
        assertEquals("Не выполнено полное сравнение с разными фамилиями",
                1, comparator.compare(personLeft, personRight));
    }
}
