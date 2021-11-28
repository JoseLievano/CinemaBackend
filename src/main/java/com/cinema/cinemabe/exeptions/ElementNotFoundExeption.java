package com.cinema.cinemabe.exeptions;

public class ElementNotFoundExeption extends Exception{

    public ElementNotFoundExeption(){
        super("This item doesn't exist!");
    }

}
