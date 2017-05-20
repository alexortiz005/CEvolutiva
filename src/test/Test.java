/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Processor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public abstract class Test implements Runnable{
    
    protected int iterations;
    protected int experiments;
    protected int step;
    protected int steps;     
    protected double bests[][];
    protected double avgs[][];
    protected double worsts[][];
    protected double results[][];
    protected int k;
    protected String outputFileName;

    public Test(int iterations, int experiments,String outputFileName) {
        this.iterations = iterations;
        this.experiments = experiments;
        this.step=iterations/1000;
        this.steps=iterations/step; 
        this.bests= new double[steps][experiments];
        this.avgs= new double[steps][experiments];
        this.worsts= new double[steps][experiments];
        this.results= new double[experiments][];   
        this.outputFileName=outputFileName;        
    }
    
    

    @Override
    public void run() {
        
        for (int j = 0;j < experiments; j++) {
            k=0;             
            experiment(j);            
        }
        
        processData(outputFileName);
        
    }
    
    public abstract void experiment(int j);
    
    public void processData(String fileName){
        
        Processor processor= new Processor(bests, avgs, worsts, results);
        
        processor.setFileName(fileName);
        processor.setStep(step);
        processor.process();        
        
        try {
            processor.toFile();
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
