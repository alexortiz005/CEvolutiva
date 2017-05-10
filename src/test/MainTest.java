/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import trees.TreesTest;
import DiffEvolution.DiffEvolutionTest;

/**
 *
 * @author root
 */
public class MainTest {
    public static void main(String[] args) {
        TreesTest treeTest= new TreesTest(1000000,2);
        DiffEvolutionTest diffTest = new DiffEvolutionTest();
        //treeTest.run();
        diffTest.run();
    }
    
}
