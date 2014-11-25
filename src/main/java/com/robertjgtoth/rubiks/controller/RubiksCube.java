package com.robertjgtoth.rubiks.controller;

import com.robertjgtoth.rubiks.model.Cube;

/**
 * Created by rtoth on 11/22/2014.
 */
public class RubiksCube {
    public static void main(String args[])
    {
        Cube cube = new Cube();
        cube.front();
        System.out.println(cube);
    }
}
