/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import trees.TreesTest;
import DiffEvolution.DiffEvolutionTest;
import particleSwarm.PSwarmTest;

/**
 *
 * @author root
 */
public class MainTest {
    public static void main(String[] args) {
        TreesTest treeTest= new TreesTest(1000000,2);
        DiffEvolutionTest diffTest = new DiffEvolutionTest(100000,30,"DiffEvolution.csv");
        PSwarmTest psTest = new PSwarmTest(1000,30,"ParticleSwarm.csv");
        //treeTest.run();
        //diffTest.run();
        psTest.run();
    }
    
}
