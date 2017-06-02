/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import trees.TreesTest;
import DiffEvolution.DiffEvolutionTest;
import HillClimbing.HillClimbingTest;
import particleSwarm.PSwarmTest;

/**
 *
 * @author root
 */
public class MainTest {
    public static void main(String[] args) {
        //TreesTest treeTest= new TreesTest(1000000,2);
        DiffEvolutionTest diffTest = new DiffEvolutionTest(100000,30,"DiffEvolutionStyblinski.csv");
        PSwarmTest psTest = new PSwarmTest(100000,30,"ParticleSwarmStyblinski.csv");
        HillClimbingTest hcTest = new HillClimbingTest(100000,30,"HillClimbingStyblinski.csv");
        //treeTest.run();
        psTest.run();
        //diffTest.run();
        //hcTest.run();
    }
    
}
