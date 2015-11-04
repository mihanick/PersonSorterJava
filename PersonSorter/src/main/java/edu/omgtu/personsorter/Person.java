/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.omgtu.personsorter;

/**
 *
 * @author gladkikh
 */
public class Person {
        public String Name;

        public String Surname;

        public String Group;

        /**
         * Инициализирует пустого человека без имени
         */
        public Person()
        {
            this.Name = "";
            this.Surname = "";
            this.Group = "";
        }

        public Person(String surnameNameGroup) throws Exception
        {
            String[] splittedStrings = surnameNameGroup.split(" ", 0);
            if (splittedStrings.length !=3)
                throw new Exception("Неверный формат текстового файла");

            this.Surname = splittedStrings[0];
            this.Name = splittedStrings[1];
            this.Group = splittedStrings[2];
        }

        @Override
        public String toString()
        {
            return this.Name+" "+this.Surname+" "+this.Group;
        }
    
}
