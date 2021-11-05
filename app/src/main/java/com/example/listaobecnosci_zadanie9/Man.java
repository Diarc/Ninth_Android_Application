package com.example.listaobecnosci_zadanie9;

    public class Man{
        private String name;
        private String lastName;
        private String subject;
        private Long id;

        private boolean active;

        public  Man()
        {

        }

        public Man(String name, String lastName, String subject)
        {
            this.name=name;
            this.lastName=lastName;
            this.subject=subject;
            this.active=true;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }

