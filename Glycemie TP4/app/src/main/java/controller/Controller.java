package controller;

import model.Patient;



    public  class Controller
    {
        private static Patient patient;
        public static Controller instance;
        public Controller()
        {
            super();
        }
        public static Controller getinstance(){
            if (instance == null)
            {return instance = new Controller();}

            return instance;
        }
        public void createPatient(int age,float valeur,boolean jen)
        {
            patient=new Patient(age,valeur,jen);
        }
        public String getResult()
        {
            return patient.getResult();
        }
    }

